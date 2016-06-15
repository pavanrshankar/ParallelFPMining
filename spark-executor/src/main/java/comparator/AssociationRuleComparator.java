package comparator;

import output.AssociationRule;

import java.util.Comparator;

/**
 * Created by pavan.r on 02/06/16.
 */
public class AssociationRuleComparator implements Comparator<AssociationRule> {
    @Override
    public int compare(AssociationRule o1, AssociationRule o2) {
        return o1.getConfidence() > o2.getConfidence() ? -1 : o1.getConfidence() == o2.getConfidence() ?  0 : 1;
    }
}
