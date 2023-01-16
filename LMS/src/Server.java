

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server implements serverInterface {
    public  ResultSet resultSet;
    public Statement statement;
    Server() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem","root","Al256282786#");
        statement = connection.createStatement();
        resultSet = statement.executeQuery(
                "select * from student"
        );

        while (resultSet.next()){
            System.out.println(resultSet.getString("name")+" "+resultSet.getString("enrolmentid")+" "+resultSet.getString("branch")+" "+resultSet.getInt("numberofbooks"));
        }
    }


    @Override
    public Map<String, Student> getStudentDb() throws SQLException {
        Map<String, Student> studentMap = new HashMap<>();
        resultSet = statement.executeQuery(
                "select * from student"
        );
        while (resultSet.next()){
            Student student = new Student(resultSet.getString("name"),resultSet.getString("enrolmentid"),resultSet.getString("branch"),resultSet.getInt("numberofbooks"));
            studentMap.put(resultSet.getString("name"),student);
        }
        return studentMap;
    }

    @Override
    public Map<String, Books> getBooksDb() throws SQLException {
        Map<String, Books> booksMap = new HashMap<>();
        resultSet = statement.executeQuery(
                "select * from book"
        );
        while (resultSet.next()){
            Books books = new Books(resultSet.getString("name"),resultSet.getString("author"),resultSet.getString("serialno"),resultSet.getInt("bookcount"));
            booksMap.put(resultSet.getString("name"),books);
        }
        return booksMap;
    }

    @Override
    public Map<String, List<Books>> getStudentBookDb() throws SQLException {
        Map<String,List<Books>> stringListMap = new HashMap<>();

        resultSet = statement.executeQuery(
                "select * from studentbook"
        );
        while (resultSet.next()){
            List<Books> books = new ArrayList<>();
            Books b = new Books(resultSet.getString("name"),resultSet.getString("author"),resultSet.getString("serialno"),resultSet.getInt("bookcount"));
            if(stringListMap.containsKey(resultSet.getString("studentname"))){

                books = stringListMap.get(resultSet.getString("studentname"));
                books.add(b);
                stringListMap.put(resultSet.getString("studentname"),books);

            }
            else{
                books.add(b);
                stringListMap.put(resultSet.getString("studentname"),books);
            }
        }
        return stringListMap;
    }

    @Override
    public void setStudentDb(Student s) throws SQLException {
        String name = s.getName();
        String enrol = s.getEnrolment();
        String branch = s.getBranch();
        int j=statement.executeUpdate(
                "insert into student(name,enrolmentid,branch,numberofbooks)"+"values('"+name+"','"+enrol+"','"+branch+"',"+5+")"
        );

    }

    @Override
    public void setBookDb(Books b) throws SQLException {

        String name = b.getName();
        String author = b.getAuthor();
        String serialno = b.getSerialNo();
        int bookcount = b.getBookCount();
        int j=statement.executeUpdate(
                "insert into book(name,author,serialno,bookcount)"+"values('"+name+"','"+author+"','"+serialno+"',"+bookcount+")"
        );

    }

    @Override
    public void setStudentBookDb(String student, Books s) throws SQLException {
        String studentname  = student;
        String name = s.getName();
        String author = s.getAuthor();
        String serialno = s.getSerialNo();
        int bookcount = s.getBookCount();
        int j=statement.executeUpdate(
                "insert into studentbook(studentname,name,author,serialno,bookcount)"+"values('"+studentname+"','"+name+"','"+author+"','"+serialno+"',"+bookcount+")"
        );
    }

    @Override
    public void updateBookCount(String name,int count) throws SQLException {
        int j=statement.executeUpdate(
                "update book set bookcount = "+count+" where name = '"+name+"'"
        );
    }

    @Override
    public void removeBook(String bookname) throws SQLException {
        int j=statement.executeUpdate(
                "delete from book where name='"+bookname+"'"
        );
    }

    @Override
    public void removeStudent(String studentname) throws SQLException {
        int j=statement.executeUpdate(
                "delete from student where name='"+studentname+"'"
        );
    }

    @Override
    public void removeAllData(String password) throws SQLException {
        int j=statement.executeUpdate(
                "drop database new"
        );
    }

    @Override
    public void returnBook(String studentName, String bookName) throws SQLException {
        int j=statement.executeUpdate(
                "delete from studentbook where name='"+bookName+"' and studentname='"+studentName+"'"
        );
    }

    public static void main(String[] args) throws SQLException {
        Server s = new Server();
//        Map<String,Books>map = new HashMap<>();
//        map.put("azmat",new Books("azmat","azmat","dadqd878",5));
//        s.setBookDb(map);
//        s.updateBookCount("azmat",10);
//        s.removeBook("azmat");
        s.removeAllData("sdfdwqf");
    }

}