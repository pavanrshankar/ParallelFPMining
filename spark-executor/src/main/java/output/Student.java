package output;

/**
 * Created by pavan.r on 15/06/16.
 */
public class Student {
    private int id;
    private int rollno;
    private int section;
    private String grade;

    public Student(int id, int rollno, int section,String grade) {
        this.id = id;
        this.rollno = rollno;
        this.section = section;
        this.grade = grade;
    }

    public int getId(){
        return id;
    }

    public int getRollno(){
        return rollno;
    }

    public int getSection(){
        return section;
    }

    public String getGrade(){
        return grade;
    }
}
