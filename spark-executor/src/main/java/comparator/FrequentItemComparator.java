package comparator;

import output.FrequentItem;

import java.util.Comparator;

/**
 * Created by pavan.r on 02/06/16.
 */
public class FrequentItemComparator implements Comparator<FrequentItem> {
    @Override
    public int compare(FrequentItem o1, FrequentItem o2) {
        return o1.getValue() > o2.getValue() ? -1 : o1.getValue() == o2.getValue() ?  0 : 1;
    }
}
