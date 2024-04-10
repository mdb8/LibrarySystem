import java.util.ArrayList;

public class Student {
    public int studentID;
    public String name;
    public ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public Student(String name, int id){
        this.name = name;
        this.studentID = id;
    }
}
