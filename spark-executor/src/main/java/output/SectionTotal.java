package output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pavan.r on 02/05/16.
 */
public class SectionTotal {
    List<SectionTuple> sectionTotal;

    public SectionTotal(List<SectionTuple> sectionTotal) {
        this.sectionTotal = sectionTotal;
    }

    @JsonProperty
    public List<SectionTuple> getSectionTotal(){
        return sectionTotal;
    }
}
