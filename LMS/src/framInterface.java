package Lms.Interfaces;

import java.sql.SQLException;

public interface framInterface {
    //Book function
    public void getAllBooks() throws SQLException;
    public void getBookByAuthor() throws SQLException;
    public void getBookByName() throws SQLException;
    public void getBookBySerialNo() throws SQLException;
    public void AddBook() throws SQLException;
    //Student function
    public void getAllStudent() throws SQLException;
    public void getStudentByName() throws SQLException;
    public void getStudentByEnroll() throws SQLException;
    public void AddStudent() throws SQLException;


    //Book Java frame
    public void AddBookInteface();
    public void AddStudentInterface();
    public void getBookByAuthorInterface();
    public void getBookByNameInterface();
    public void getBookBySerialNoInterface();

    //Student java frame
    public void getStudentByNameInterface();
    public void getStudentByEnrollInterface();


    //Issues
    public void issuebooktostudentbynameInterface();
    public void issuebooktostudentbyname() throws SQLException;
    public void issuebooktostudentbyserialInterface();
    public void returnBook2(String studentName,String bookName) throws SQLException;

}
