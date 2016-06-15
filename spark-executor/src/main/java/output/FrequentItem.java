package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pavan.r on 25/05/16.
 */
public class FrequentItem implements Serializable{
    private long value;
    private List<String> frequentItem;

    public FrequentItem(long value, List<String> frequentItem) {
        this.value = value;
        this.frequentItem = frequentItem;
    }

    @JsonProperty
    public long getValue(){
        return value;
    }

    @JsonProperty
    public List<String> getFrequentItem(){
        return frequentItem;
    }
}
