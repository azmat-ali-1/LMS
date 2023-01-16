

import java.sql.SQLException;
import java.util.*;
public interface serverInterface {
    //get database system
    public Map<String, Student>getStudentDb() throws SQLException;
    public Map<String, Books>getBooksDb() throws SQLException;
    public Map<String,List<Books>>getStudentBookDb() throws SQLException;

    //set database system
    public void setStudentDb(Student s)throws SQLException;
    public void setBookDb(Books b) throws SQLException;
    public void setStudentBookDb(String student, Books books) throws SQLException;
    //update db
    public void updateBookCount(String name,int count) throws SQLException;
    public void removeBook(String bookname) throws SQLException;
    public void removeStudent(String studentname) throws SQLException;
    public void removeAllData(String password) throws SQLException;
    public void returnBook(String studentName,String bookName) throws SQLException;
}