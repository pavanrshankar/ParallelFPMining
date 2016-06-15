package output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Comparator;
import java.util.List;

/**
 * Created by pavan.r on 26/05/16.
 */
public class AssociationRule{
    private List<String> antecedent;
    private List<String> consequent;
    private double confidence;

    public AssociationRule(List<String> antecedent,List<String> consequent,double confidence) {
        this.antecedent = antecedent;
        this.consequent = consequent;
        this.confidence = confidence;
    }

    @JsonProperty
    public List<String> getAntecedent(){
        return antecedent;
    }

    @JsonProperty
    public List<String> getConsequent() { return consequent; }

    @JsonProperty
    public double getConfidence(){
        return confidence;
    }
}
