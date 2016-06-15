package map;


import org.apache.spark.api.java.function.PairFunction;
import output.Student;
import scala.Tuple2;

/**
 * Created by pavan.r on 28/04/16.
 */
public class StudentToSectionTuple implements PairFunction<Student, Integer, Long> {
    public Tuple2<Integer, Long> call(Student student) throws Exception {
        Tuple2<Integer, Long> sectionTuple = new Tuple2(student.getSection(),1L);
        return sectionTuple;
    }
}
