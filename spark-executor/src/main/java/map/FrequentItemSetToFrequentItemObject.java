package map;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.fpm.FPGrowth;
import output.FrequentItem;

/**
 * Created by pavan.r on 25/05/16.
 */
public class FrequentItemSetToFrequentItemObject implements Function<FPGrowth.FreqItemset<String>, FrequentItem> {
    @Override
    public FrequentItem call(FPGrowth.FreqItemset<String> freqItemset) throws Exception {
        FrequentItem frequentItem = new FrequentItem(freqItemset.freq(),freqItemset.javaItems());
        return frequentItem;
    }
}
