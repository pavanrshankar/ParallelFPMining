package output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pavan.r on 26/05/16.
 */
public class MiningResult {
    private List<FrequentItem> clusters;
    private List<AssociationRule> associationRules;

    public MiningResult(List<FrequentItem> clusters, List<AssociationRule> associationRules) {
        this.clusters = clusters;
        this.associationRules = associationRules;
    }

    @JsonProperty
    public List<FrequentItem> getClusters(){
        return clusters;
    }

    @JsonProperty
    public List<AssociationRule> getAssociationRules(){
        return associationRules;
    }
}
