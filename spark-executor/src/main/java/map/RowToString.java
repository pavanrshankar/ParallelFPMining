package map;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Row;
import output.Student;

/**
 * Created by pavan.r on 06/05/16.
 */
public class RowToStudent implements Function<Row, Student> {
    public Student call(Row message) throws Exception {
        Student student = new Student(message.getInt(0),message.getInt(1),message.getInt(2),message.getString(3));
        return student;
    }
}
