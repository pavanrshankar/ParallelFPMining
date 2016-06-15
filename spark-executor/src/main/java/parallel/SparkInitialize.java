package parallel;

import comparator.AssociationRuleComparator;
import comparator.FrequentItemComparator;
import executor.SparkExecutor;
import map.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.fpm.AssociationRules;
import org.apache.spark.mllib.fpm.FPGrowth;
import org.apache.spark.mllib.fpm.FPGrowthModel;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import output.*;
import reduce.SectionSum;

import java.util.*;

/**
 * Created by pavan.r on 04/04/16.
 */

public class SparkInitialize {
    private JavaSparkContext sc;
    private SparkExecutor sparkExecutor;
    private SQLContext sqlContext;
    private Properties properties;

    public SparkInitialize(SparkExecutor sparkExecutor){
        this.sparkExecutor = sparkExecutor;
    }

    public void start() throws ClassNotFoundException{
        properties = sparkExecutor.getProperties();
        SparkConf conf = new SparkConf().
                         setAppName(properties.getProperty("name")).
                         setMaster(properties.getProperty("master"));
        sc = new JavaSparkContext(conf);
        sqlContext = new SQLContext(sc);
    }


    public SectionTotal group(){
        String table = "student_info";
        DataFrame df = sqlContext.read().format(properties.getProperty("dbtype")).
                option("url",properties.getProperty("dburl")).
                option("dbtable",table).
                option("driver",properties.getProperty("driver")).
                option("partitionColumn", properties.getProperty("partitionColumn")).
                option("lowerBound", properties.getProperty("lowerBound")).
                option("upperBound", properties.getProperty("upperBound")).
                option("numPartitions", properties.getProperty("numPartitions")).
                load();

        JavaRDD<Student> data = df.javaRDD().map(new RowToStudent());
        JavaPairRDD<Integer, Long> sectionRDD = data.mapToPair(new StudentToSectionTuple());
        JavaPairRDD<Integer, Long> sectionTotalRDD = sectionRDD.reduceByKey(new SectionSum());
        JavaRDD<SectionTuple> issueTuple = sectionTotalRDD.map(new LongTupleToSectionTuple());
        List<SectionTuple> result = issueTuple.collect();
        SectionTotal sectionTotal = new SectionTotal(result);
        return sectionTotal;
    }

    public MiningResult mineRules(double support,double confidence){
        JavaRDD<String> data = sc.textFile("/Users/pavan.r/repos/demo-ps2/spark-executor/src/main/resources/data.txt");
        JavaRDD<List<String>> transactions = data.map(new StringToListOfString());
        FPGrowth fpg = new FPGrowth().setMinSupport(support).setNumPartitions(10);
        FPGrowthModel<String> model = fpg.run(transactions);
        JavaRDD<FPGrowth.FreqItemset<String>> resultCollected = model.freqItemsets().toJavaRDD();
        JavaRDD<FrequentItem> resultRDD = resultCollected.map(new FrequentItemSetToFrequentItemObject());
        List<FrequentItem> clusters = resultRDD.collect();
        Collections.sort(clusters,new FrequentItemComparator());

        List<AssociationRule> associationRules = new ArrayList();
        for (AssociationRules.Rule<String> rule : model.generateAssociationRules(confidence).toJavaRDD().collect()) {
            AssociationRule associationRule = new AssociationRule(rule.javaAntecedent(),rule.javaConsequent(),rule.confidence());
            associationRules.add(associationRule);
        }
        Collections.sort(associationRules,new AssociationRuleComparator());

        MiningResult miningResult = new MiningResult(clusters,associationRules);
        return miningResult;
    }
}
