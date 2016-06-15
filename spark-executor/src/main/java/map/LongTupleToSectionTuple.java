package map;

import org.apache.spark.api.java.function.Function;
import output.SectionTuple;
import scala.Tuple2;

import java.util.Map;

/**
 * Created by pavan.r on 17/05/16.
 */
public class LongTupleToSectionTuple implements Function<Tuple2<Integer, Long>, SectionTuple> {
    @Override
    public SectionTuple call(Tuple2<Integer, Long> result) throws Exception {
        SectionTuple sectionTuple = new SectionTuple(result._2(),result._1());
        return sectionTuple;
    }
}
