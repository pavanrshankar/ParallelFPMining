package reduce;

import org.apache.spark.api.java.function.Function2;

/**
 * Created by pavan.r on 28/04/16.
 */
public class SectionSum implements Function2<Long,Long,Long> {
    public Long call(Long count1, Long count2) throws Exception {
        return count1+count2;
    }
}
