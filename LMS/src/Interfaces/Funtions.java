package Interfaces;

import Models.Books;
import Models.Student;

import java.sql.SQLException;
import java.util.*;

public interface Funtions {

    //Book function get function
    public List<Books>getAllBooks() throws SQLException;
    public List<Books> getBookByAuthor(String author) throws SQLException;
    public List<Books> getBookByName(String bookName) throws SQLException;
    public List<Books>getBookBySerialNo(String SerialNo) throws SQLException;
    public List<Books> IssueBooks(String StudentName);

    //Models.Student Function get function
    public List<Student> SearchStudentByName(String name) throws SQLException;
    public  List<Student> SearchStudentByEnroll(String name)throws SQLException;
    public List<Student> ListOfNumberOfStudent();
    public int numberOfBooksIssueByStudent(String name);
    public List<Student> getAllStudentDetail() throws SQLException;

    //Combine details get function
    public List<Books>  getStudentIssueBooks(String StudentName);
    public List<Student> getBookIssueToStudent(String BookName);

    //book set function
    public String addBooks(String name,String author,String serialNo,int numberOfBook) throws SQLException;
    public void increaseBookCount(String name,int count) throws SQLException;
    public void decreaseBookCount(String name,int count) throws SQLException;
    public String removeBook(String name) throws SQLException;

    //student function
    public String addStudent(String name, String Enrolment, String Branch ,int count) throws SQLException;

    //studentbookdb function
    public String issueBookToStudent(String student,String book) throws SQLException;
    public Map<String,List<Books>> getStudentBookdb() throws SQLException;
    public void returnBook(String studentName ,String bookname) throws SQLException;

}