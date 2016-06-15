package output;

import java.io.Serializable;

/**
 * Created by pavan.r on 17/05/16.
 */
public class SectionTuple implements Serializable{
    private Long value;
    private int section;

    public SectionTuple(Long value, int section){
        this.value = value;
        this.section = section;
    }
    public Long getValue(){
        return value;
    }

    public int getSection(){
        return section;
    }

}
