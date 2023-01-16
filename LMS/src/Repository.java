



import java.sql.SQLException;
import java.util.*;

public class Repository implements Funtions {
    Server server = new Server();
    //database
    public HashMap<String, Student>studentdb = new HashMap<>();
    public HashMap<String, Books>bookdb = new HashMap<>();
    public HashMap<String,List<Books>>studentbookdb=new HashMap<>();

    public Repository() throws SQLException {
    }

    @Override
    public List<Books> getAllBooks() throws SQLException {


            bookdb = (HashMap<String, Books>) server.getBooksDb();
        List<Books>books=new ArrayList<>();
        for(String i : bookdb.keySet()){
            books.add(bookdb.get(i));
        }
        return books;
    }

    @Override
    public List<Books> getBookByAuthor(String author) throws SQLException {
        if(bookdb.size()==0){
            bookdb= (HashMap<String, Books>) server.getBooksDb();
        }
        List<Books> list = new ArrayList<>();
        for(String i : bookdb.keySet()){
            Books b = bookdb.get(i);
            if(author.equals(b.getAuthor())){
                list.add(b);
            }
        }
        return list;
    }

    @Override
    public List<Books> getBookByName(String bookName) throws SQLException {
        if(bookdb.size()==0){
            bookdb= (HashMap<String, Books>) server.getBooksDb();
        }
        List<Books> list = new ArrayList<>();
        for(String i : bookdb.keySet()){
            Books b = bookdb.get(i);
            if(bookName.equals(b.getName())){
                list.add(b);
            }
        }
        return list;
    }

    @Override
    public List<Books> getBookBySerialNo(String SerialNo) throws SQLException {
        if(bookdb.size()==0){
            bookdb= (HashMap<String, Books>) server.getBooksDb();
        }
        List<Books> list = new ArrayList<>();
        for(String i : bookdb.keySet()){
            Books b = bookdb.get(i);
            if(SerialNo.equals(b.getSerialNo())){
                list.add(b);
            }
        }
        return list;
    }

    @Override
    public List<Books> IssueBooks(String StudentName) {
        List<Books>listOfBook = new ArrayList<>();

        if(studentbookdb.containsKey(StudentName)){
            listOfBook = studentbookdb.get(StudentName);
        }

        return listOfBook;
    }

    @Override
    public List<Student> SearchStudentByName(String name) throws SQLException {
        studentdb = (HashMap<String, Student>) server.getStudentDb();
        List<Student> list = new ArrayList<>();
        for (String i : studentdb.keySet()){
            Student s = studentdb.get(i);
            if(name.equals(s.getName())){
                list.add(s);
            }
        }
        return list;
    }

    @Override
    public List<Student> SearchStudentByEnroll(String name) throws SQLException {
        studentdb = (HashMap<String, Student>) server.getStudentDb();
        List<Student> list = new ArrayList<>();
        for (String i : studentdb.keySet()){
            Student s = studentdb.get(i);
            if(name.equals(s.getEnrolment())){
                list.add(s);
            }
        }
        return list;
    }

    @Override
    public List<Student> ListOfNumberOfStudent() {
        List<Student>listOfStudent =new ArrayList<>();
        for(String i : studentdb.keySet()){
            listOfStudent.add(studentdb.get(i));
        }
        return listOfStudent;
    }

    @Override
    public int numberOfBooksIssueByStudent(String name) {
        for(String i : studentdb.keySet()){
            Student s = studentdb.get(i);
            if(name.equals(s.getName())){
                return s.getNumberOfBookIssue();
            }
        }
        return 0;
    }

    @Override
    public List<Student> getAllStudentDetail() throws SQLException {
        studentdb = (HashMap<String, Student>) server.getStudentDb();
        List<Student> student =new ArrayList<>();
        for(String i : studentdb.keySet()){
            student.add(studentdb.get(i));
        }
        return student;
    }

    @Override
    public List<Books> getStudentIssueBooks(String StudentName) {
           return studentbookdb.get(StudentName);
    }

    @Override
    public List<Student> getBookIssueToStudent(String BookName) {
        return null;
    }

    public List<Student> getStudentIssueToBook(String BookName) {
        List<Student> list = new ArrayList<>();

        for(String i : studentbookdb.keySet()){
            List<Books> books = studentbookdb.get(i);
            for(Books j: books){
                if(BookName.equals(j.getName())){
                    list.add(studentdb.get(i));
                }
            }
        }
        return list;
    }

    public Map<String,List<Books>> getStudentBookdb() throws SQLException {
        studentbookdb = (HashMap<String, List<Books>>) server.getStudentBookDb();
        return studentbookdb;
    }

    @Override
    public void returnBook(String studentName, String bookname) throws SQLException {
        if(studentbookdb.containsKey(studentName)){
            studentbookdb.remove(bookname);
            System.out.println("bookname"+bookname);
            server.returnBook(studentName,bookname);
        }
    }

    //set
    @Override
    public String addBooks(String name, String author, String serialNo, int numberOfBook) throws SQLException {
        Books b = new Books(name,author,serialNo,numberOfBook);
        if(!bookdb.containsKey(name)){
            bookdb.put(name,b);
            server.setBookDb(b);
            return "Successfull";
        }
        return "Book already Present";
    }

    //update
    @Override
    public void increaseBookCount(String name, int count) throws SQLException {
        if(bookdb.containsKey(name)){
            Books b = bookdb.get(name);
            b.setBookCount(count+b.getBookCount());
            bookdb.put(name,b);
            server.updateBookCount(name,count+b.getBookCount());
        }
    }

    //update
    @Override
    public void decreaseBookCount(String name, int count) throws SQLException {
        if(bookdb.containsKey(name)){
            Books b = bookdb.get(name);
            if(count>b.getBookCount()){
                System.out.println("number Of books are :-"+b.getBookCount()+" you want to remove:- "+count);
                return;
            }
            b.setBookCount(b.getBookCount()-count);
            bookdb.put(name,b);
            server.updateBookCount(name,b.getBookCount()-count);
        }

    }
    //update
    @Override
    public String removeBook(String name) throws SQLException {
        if(bookdb.containsKey(name)){
            bookdb.remove(name);
            server.removeBook(name);
            return "OK";
        }
       return "Not present";
    }
    //set
    @Override
    public String addStudent(String name, String Enrolment, String Branch ,int count) throws SQLException {
        Student s = new Student(name,Enrolment,Branch,count);
        studentdb.put(name,s);
        server.setStudentDb(s);
        return "Successful";
    }
    //set
    @Override
    public String issueBookToStudent(String student, String book) throws SQLException {

        studentdb = (HashMap<String, Student>) server.getStudentDb();
        bookdb = (HashMap<String, Books>) server.getBooksDb();
        if(studentdb.containsKey(student)){
            if(bookdb.containsKey(book)){
                if(!studentbookdb.containsKey(student)){
                    List<Books> b = new ArrayList<>();
                    b.add(bookdb.get(book));
                    studentbookdb.put(student,b);
                    Student s  = studentdb.get(student);
                    s.setNumberOfBookIssue(b.size());
                    System.out.println();
                }
                else{
                    List<Books> b = studentbookdb.get(student);
                    b.add(bookdb.get(book));
                    studentbookdb.put(student,b);
                    Student s  = studentdb.get(student);
                    s.setNumberOfBookIssue(b.size());
                }
                server.setStudentBookDb(student,bookdb.get(book));
                return book+" Book Successfully issue to "+student;
            }
            return "Book not present "+book;

        }
        return "Student not present in list "+student;
    }
    public String issueBookToStudentserial(String student,String serialNo) throws SQLException {
        studentdb = (HashMap<String, Student>) server.getStudentDb();
        bookdb = (HashMap<String, Books>) server.getBooksDb();
        boolean bookp=false;
        String bookname="";

        for (String i: bookdb.keySet()){
            if(serialNo.equals(bookdb.get(i).getSerialNo())){
                bookp=true;
                bookname = bookdb.get(i).getName();
            }
        }
        if(bookp){
            return issueBookToStudent(student,bookname);
        } else if (bookp == false) {
            return "BookSerialNo. not present "+serialNo;
        }
        return "Student not present in list "+student;
    }
    public void update() throws SQLException {
        studentdb= (HashMap<String, Student>) server.getStudentDb();
        bookdb= (HashMap<String, Books>) server.getBooksDb();
        studentbookdb= (HashMap<String, List<Books>>) server.getStudentBookDb();
    }
}