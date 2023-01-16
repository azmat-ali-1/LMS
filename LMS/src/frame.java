import Lms.Interfaces.framInterface;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.*;
import java.util.List;


public class frame extends framehelper implements ActionListener, framInterface, MouseListener {

    frame() throws SQLException {
        //new popWindow();
        f = new JFrame("Menu and MenuItem Example");
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Menu");
        book = new JMenu("Books");
        student = new JMenu("Student");
        issue = new JMenu("Issue");
        logout = new JMenu("Log out");

        AddBook = new JMenuItem("Add Book");
        AddStudent = new JMenuItem("Add Student");
        i3 = new JMenuItem("Item 3");
        i4 = new JMenuItem("Item 4");
        i5 = new JMenuItem("Item 5");
        menu.add(AddBook);menu.add(AddStudent);menu.add(i3);
        AddStudent.addActionListener(this);AddBook.addActionListener(this);
        mb.add(menu);

        view = new JMenuItem("View All Books");
        author = new JMenuItem("Books by Author");
        name = new JMenuItem("Books by Name");
        serial = new JMenuItem("Books by SerialNo");
        book.add(view);book.add(author);book.add(name);book.add(serial);
        mb.add(book);
        view.addActionListener(this);author.addActionListener(this);name.addActionListener(this);serial.addActionListener(this);

        viewstudent = new JMenuItem("View All Student");
        studentname = new JMenuItem("Student by name");
        studentenrollment = new JMenuItem("Student by Enrolment");
        student.add(viewstudent);student.add(studentname);student.add(studentenrollment);
        viewstudent.addActionListener(this);studentname.addActionListener(this);studentenrollment.addActionListener(this);
        mb.add(student);

        issuebyname = new JMenuItem("By Name");
        issuebookbyserial = new JMenuItem("By Serial");
        issuebookBySelection = new JMenuItem("By Selection");
        issue.add(issuebyname);issue.add(issuebookbyserial);issue.add(issuebookBySelection);
        issuebyname.addActionListener(this);
        issuebookbyserial.addActionListener(this);
        issuebookBySelection.addActionListener(this);
        mb.add(issue);

        l = new JMenuItem("out->");
        l.addActionListener(this);
        logout.add(l);
        mb.add(logout);
        //l.addActionListener(this);

        //Panel creation
        JPanel  p = new JPanel();
        p.setBackground(Color.DARK_GRAY);
        p.setBounds(400,100,175,500);

        l1 = new JButton("# Books Issue");
        l2 = new JButton("# Update Book");
        l3 = new JButton("# Delete Book");
        l4 = new JButton("# Return Book");
        l1.addActionListener(this);
        l1.setForeground(Color.WHITE);l1.setBackground(Color.DARK_GRAY);l1.setBorder(new LineBorder(Color.DARK_GRAY));
        l1.addActionListener(this);
        l2.setForeground(Color.white);l3.setForeground(Color.WHITE);l4.setForeground(Color.WHITE);
        l2.setBackground(Color.DARK_GRAY);l3.setBackground(Color.DARK_GRAY);l4.setBackground(Color.DARK_GRAY);
        l2.setBorder(new LineBorder(Color.DARK_GRAY));l3.setBorder(new LineBorder(Color.DARK_GRAY));l4.setBorder(new LineBorder(Color.DARK_GRAY));
        l3.addActionListener(this);l4.addActionListener(this);l2.addActionListener(this);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);

        p2 = new JPanel();
        p2.setBounds(0,100,400,500);
        p2.setBackground(Color.BLACK);
        f.add(p2);

        f.setJMenuBar(mb);
        f.add(p);
        f.setSize(600, 700);
        f.setLayout(null);
        f.setVisible(true);
        //home.addMenuListener(listener);


    }

    public void getAllBooks() throws SQLException {
       // String str [][] = {{"Azmat","azmat","azmat"}};
        List<Books> f = repository.getAllBooks();
        //System.out.println(f.get(0).getName());
        String str [][] = new String[f.size()][4];
        for (int i=0;i<f.size();i++){
            Books h = f.get(i);
            String name = h.getName();
            String Author = h.getAuthor();
            String serialNo = h.getSerialNo();
            int bookCount = h.getBookCount();
            str[i][0]=name;str[i][1]=Author;str[i][2]=serialNo;str[i][3]=String.valueOf(bookCount);
        }
        String c[] = {"Name","Author","serialNo","count"};
        jTable = new JTable(str,c);
        jTable.setLayout(null);
        jTable.setVisible(true);
        jTable.setDragEnabled(true);
        jTable.setForeground(Color.white);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setShowGrid(true);
        jTable.setGridColor(Color.BLACK);
        jTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
       // p2.setLayout(new BorderLayout());
        jTable.setFillsViewportHeight(true);
        jTable.setPreferredScrollableViewportSize(new Dimension(300,500));
        p2.add(sp);
    }
    public void getBookByAuthorInterface(){
        authortextField = new JTextField(10);
        authorlabel = new JLabel("Enter Author Name");
        authorlabel.setForeground(Color.WHITE);
        authorbutton = new JButton("Search");
        p2.add(authorbutton);
        p2.add(authorlabel);
        p2.add(authortextField);
        authorbutton.addActionListener(this);

    }
    public void getBookByAuthor() throws SQLException {

       List<Books> b = repository.getBookByAuthor(authortextField.getText());

        String str [][] = new String[b.size()][4];

        for (int i=0;i<b.size();i++){
            Books h = b.get(i);
            String name = h.getName();
            String Author = h.getAuthor();
            String serialNo = h.getSerialNo();
            int bookCount = h.getBookCount();
            str[i][0]=name;str[i][1]=Author;str[i][2]=serialNo;str[i][3]=String.valueOf(bookCount);
        }
        String c[] = {"Name","Author","serialNo","count"};
        jTable = new JTable(str,c);
        jTable.setLayout(null);
        jTable.setVisible(true);
        jTable.setDragEnabled(true);
        jTable.setForeground(Color.white);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setShowGrid(true);
        jTable.setGridColor(Color.BLACK);
        jTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        // p2.setLayout(new BorderLayout());
        jTable.setFillsViewportHeight(true);
        jTable.setPreferredScrollableViewportSize(new Dimension(300,500));
        p2.add(sp);
    }
    public void getBookByNameInterface(){
        nametextField = new JTextField(10);
        namelabel = new JLabel("Enter Name");
        namelabel.setForeground(Color.WHITE);
        namebutton = new JButton("Search");
        p2.add(namebutton);
        p2.add(namelabel);
        p2.add(nametextField);
        namebutton.addActionListener(this);
    }
    public void getBookByName() throws SQLException {
        List<Books> b = repository.getBookByName(nametextField.getText());

        String str [][] = new String[b.size()][4];

        for (int i=0;i<b.size();i++){
            Books h = b.get(i);
            String name = h.getName();
            String Author = h.getAuthor();
            String serialNo = h.getSerialNo();
            int bookCount = h.getBookCount();
            str[i][0]=name;str[i][1]=Author;str[i][2]=serialNo;str[i][3]=String.valueOf(bookCount);
        }
        String c[] = {"Name","Author","serialNo","count"};
        jTable = new JTable(str,c);
        jTable.setLayout(null);
        jTable.setVisible(true);
        jTable.setDragEnabled(true);
        jTable.setForeground(Color.white);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setShowGrid(true);
        jTable.setGridColor(Color.BLACK);
        jTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        // p2.setLayout(new BorderLayout());
        jTable.setFillsViewportHeight(true);
        jTable.setPreferredScrollableViewportSize(new Dimension(300,500));
        p2.add(sp);
    }
    public void getBookBySerialNoInterface(){
        serialtextField = new JTextField(10);
        seriallabel = new JLabel("Enter Serial No.");
        seriallabel.setForeground(Color.WHITE);
        serialbutton = new JButton("Search");
        p2.add(serialbutton);
        p2.add(seriallabel);
        p2.add(serialtextField);
        serialbutton.addActionListener(this);
    }

    public void getBookBySerialNo() throws SQLException {
        List<Books> b = repository.getBookBySerialNo(serialtextField.getText());

        String str [][] = new String[b.size()][4];

        for (int i=0;i<b.size();i++){
            Books h = b.get(i);
            String name = h.getName();
            String Author = h.getAuthor();
            String serialNo = h.getSerialNo();
            int bookCount = h.getBookCount();
            str[i][0]=name;str[i][1]=Author;str[i][2]=serialNo;str[i][3]=String.valueOf(bookCount);
        }
        String c[] = {"Name","Author","serialNo","count"};
        jTable = new JTable(str,c);
        jTable.setLayout(null);
        jTable.setVisible(true);
        jTable.setDragEnabled(true);
        jTable.setForeground(Color.white);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setShowGrid(true);
        jTable.setGridColor(Color.BLACK);
        jTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        // p2.setLayout(new BorderLayout());
        jTable.setFillsViewportHeight(true);
        jTable.setPreferredScrollableViewportSize(new Dimension(300,500));
        p2.add(sp);
    }
    public void getStudentByNameInterface(){
        studentnamefield = new JTextField(10);
        studentnamelabel = new JLabel("Enter Student Name");
        studentnamelabel.setForeground(Color.WHITE);
        studentnamebutton = new JButton("Search");
        p2.add(studentnamebutton);
        p2.add(studentnamelabel);
        p2.add(studentnamefield);
        studentnamebutton.addActionListener(this);
    }
    public void getStudentByName() throws SQLException {
        List<Student> b = repository.SearchStudentByName(studentnamefield.getText());

        String str [][] = new String[b.size()][4];

        for (int i=0;i<b.size();i++){
            Student h = b.get(i);
            String name = h.getName();
            String Author = h.getEnrolment();
            String serialNo = h.getBranch();
            int bookCount = h.getNumberOfBookIssue();
            str[i][0]=name;str[i][1]=Author;str[i][2]=serialNo;str[i][3]=String.valueOf(bookCount);
        }
        String c[] = {"Name","Enrolement","Branch","count"};
        jTable = new JTable(str,c);
        jTable.setLayout(null);
        jTable.setVisible(true);
        jTable.setDragEnabled(true);
        jTable.setForeground(Color.white);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setShowGrid(true);
        jTable.setGridColor(Color.BLACK);
        jTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        // p2.setLayout(new BorderLayout());
        jTable.setFillsViewportHeight(true);
        jTable.setPreferredScrollableViewportSize(new Dimension(300,500));
        p2.add(sp);
    }
    public void getStudentByEnrollInterface(){
        studentenrollfield = new JTextField(10);
        studentenrolllabel = new JLabel("Enter Enrollment No");
        studentenrolllabel.setForeground(Color.WHITE);
        studentenrollbutton = new JButton("Search");
        p2.add(studentenrollbutton);
        p2.add(studentenrolllabel);
        p2.add(studentenrollfield);
        studentenrollbutton.addActionListener(this);
    }
    public void getStudentByEnroll() throws SQLException {
        List<Student> b = repository.SearchStudentByEnroll(studentenrollfield.getText());

        String str [][] = new String[b.size()][4];

        for (int i=0;i<b.size();i++){
            Student h = b.get(i);
            String name = h.getName();
            String Author = h.getEnrolment();
            String serialNo = h.getBranch();
            int bookCount = h.getNumberOfBookIssue();
            str[i][0]=name;str[i][1]=Author;str[i][2]=serialNo;str[i][3]=String.valueOf(bookCount);
        }
        String c[] = {"Name","Enrolement","Branch","count"};
        jTable = new JTable(str,c);
        jTable.setLayout(null);
        jTable.setVisible(true);
        jTable.setDragEnabled(true);
        jTable.setForeground(Color.white);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setShowGrid(true);
        jTable.setGridColor(Color.BLACK);
        jTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        // p2.setLayout(new BorderLayout());
        jTable.setFillsViewportHeight(true);
        jTable.setPreferredScrollableViewportSize(new Dimension(300,500));
        p2.add(sp);
    }


    public void AddBookInteface() {
        addbooknameL = new JLabel("Book name");addbookname = new JTextField(10);
        addbookauthorL = new JLabel("Author name");addbookauthor = new JTextField(10);
        addbooknumberL = new JLabel("Serial No.");addbooknumber=new JTextField(10);
        addbookcountL = new JLabel("Book count");addbookcount= new JTextField(10);

        addbookbutton = new JButton("Submit");
        addbookbutton.addActionListener(this);
        addbooknameL.setForeground(Color.WHITE);addbookauthorL.setForeground(Color.WHITE);addbooknumberL.setForeground(Color.WHITE);addbookcountL.setForeground(Color.WHITE);
        p2.add(addbooknameL);p2.add(addbookname);p2.add(addbookauthorL);p2.add(addbookauthor);p2.add(addbooknumberL);p2.add(addbooknumber);p2.add(addbookcountL);p2.add(addbookcount);p2.add(addbookbutton);

    }
    public void AddBook() throws SQLException {
        if(addbookname.getText().equals("")||addbookauthor.getText().equals("")||addbooknumber.getText().equals("")||addbookcount.getText().equals("")||Character.isDigit(addbookcount.getText().charAt(0))==false||addbookcount.getText().equals("0")){
            JOptionPane.showMessageDialog(f,"Invalid");
            return;
        }
        String message = repository.addBooks(addbookname.getText(),addbookauthor.getText(),addbooknumber.getText(), Integer.parseInt(addbookcount.getText()));
        JOptionPane.showMessageDialog(f,message);
    }

    public void AddStudentInterface() {
        addstudentnameL = new JLabel("Student name");addstudentname = new JTextField(10);
        addstudentenrolL = new JLabel("Enrolment");addstudentenrol = new JTextField(10);
        addstudentbranchL = new JLabel("Branch");addstudentbranch=new JTextField(10);


        addstudentbutton = new JButton("Submit");
        addstudentbutton.addActionListener(this);
        addstudentnameL.setForeground(Color.WHITE);addstudentenrolL.setForeground(Color.WHITE);addstudentbranchL.setForeground(Color.WHITE);
        p2.add(addstudentnameL);p2.add(addstudentname);p2.add(addstudentenrolL);p2.add(addstudentenrol);
        p2.add(addstudentbranchL);p2.add(addstudentbranch);p2.add(addstudentbutton);

    }
    public void AddStudent() throws SQLException {
        if(addstudentname.getText().equals("")||addstudentenrol.getText().equals("")||addstudentbranch.getText().equals("")){
            JOptionPane.showMessageDialog(f,"Invalid");
            return;
        }
        String message = repository.addStudent(addstudentname.getText(),addstudentenrol.getText(),addstudentbranch.getText(),0);
        JOptionPane.showMessageDialog(f,message);
    }

    public void issuebooktostudentbynameInterface(){
        issuenamebook = new JLabel("Book name");
        issuenbookfield = new JTextField(10);
        issuenamestudent = new JLabel("Student name");
        issuestudentfield = new JTextField(10);
        issuebookbutton = new JButton("Submit");
        issuebookbutton.addActionListener(this);
        p2.add(issuenamebook);
        p2.add(issuenbookfield);
        p2.add(issuenamestudent);
        p2.add(issuestudentfield);
        p2.add(issuebookbutton);
    }

    @Override
    public void issuebooktostudentbyname() throws SQLException {
        String message = repository.issueBookToStudent(issuestudentfield.getText(),issuenbookfield.getText());
        JOptionPane.showMessageDialog(f,message);
    }

    public void issuebooktostudentbyserialInterface(){
        issuenamebook = new JLabel("Book no");
        issuenbookfield = new JTextField(10);
        issuenamestudent = new JLabel("Student name");
        issuestudentfield = new JTextField(10);
        issuebookbuttons = new JButton("Submit");
        issuebookbuttons.addActionListener(this);
        p2.add(issuenamebook);
        p2.add(issuenbookfield);
        p2.add(issuenamestudent);
        p2.add(issuestudentfield);
        p2.add(issuebookbuttons);
    }
    public void issuebooktostudentbyserial() throws SQLException {
        String message = repository.issueBookToStudentserial(issuestudentfield.getText(),issuenbookfield.getText());
        JOptionPane.showMessageDialog(f,message);
    }
    public void getAllStudent() throws SQLException {
        List<Student> f = repository.getAllStudentDetail();
        //System.out.println(f.get(0).getName());
        String str [][] = new String[f.size()][4];
        for (int i=0;i<f.size();i++){
            Student h = f.get(i);
            String name = h.getName();
            String Enrolment = h.getEnrolment();
            String Branch = h.getBranch();
            int bookCount = h.getNumberOfBookIssue();
            str[i][0]=name;str[i][1]=Enrolment;str[i][2]=Branch;str[i][3]=String.valueOf(bookCount);
        }
        String c[] = {"Name","Enrolment","Branch","Book issues"};
        jTable = new JTable(str,c);
        jTable.setLayout(null);
        jTable.setVisible(true);
        jTable.setDragEnabled(true);
        jTable.setForeground(Color.white);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setShowGrid(true);
        jTable.setGridColor(Color.BLACK);
        jTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        // p2.setLayout(new BorderLayout());
        jTable.setFillsViewportHeight(true);
        jTable.setPreferredScrollableViewportSize(new Dimension(300,500));
        p2.add(sp);
    }

    public void studentbookdb() throws SQLException {
       Map<String, List<Books>> map = repository.getStudentBookdb();
       String [] str =new String[map.size()];
       int k=0;
       for (String i: map.keySet()){
           str[k++]=i;
       }
        list= new JList(str);
        list.setBounds(0,100,100,490);
        list.setPreferredSize(new Dimension(50,470));
        list.setForeground(Color.WHITE);
        list.setBackground(Color.DARK_GRAY);
        list.addMouseListener(this);
        jScrollPane = new JScrollPane(list);
        jScrollPane.setBounds(0,100,100,490);
        jScrollPane.setPreferredSize(new Dimension(70,490));
        String s [] = {"Name","Author","Serial No."};
        jTable1 = new JTable(new String[][]{{"","",""}},s);
        jTable1.setLayout(null);
        jTable1.setVisible(true);
        jTable1.setDragEnabled(true);
        jTable1.setForeground(Color.white);
        jTable1.setBackground(Color.DARK_GRAY);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.BLACK);
        jTable1.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        sp = new JScrollPane(jTable1);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        // p2.setLayout(new BorderLayout());
        jTable1.setFillsViewportHeight(true);
        jTable1.setPreferredScrollableViewportSize(new Dimension(225,500));
        p2.add(jScrollPane);
        p2.add(sp);
    }
    public void studentbookdbtable(String s42) throws SQLException {
        repository.update();
        sp.remove(jTable1);
        List<Books> li676 = repository.getStudentIssueBooks(s42);
        System.out.println(s42);
        System.out.println(li676.size());
        String s [] = {"Name","Author","Serial No."};
        String [][]str = new String[li676.size()][3];
        for (int i=0;i<li676.size();i++){
            Books books1 = li676.get(i);
            str[i][0]=books1.getName();str[i][1]=books1.getAuthor();str[i][2]=books1.getSerialNo();
        }
        jTable1 = new JTable(str,s);
        jTable1.setLayout(null);
        jTable1.setVisible(true);
        jTable1.setDragEnabled(true);
        jTable1.setForeground(Color.white);
        jTable1.setBackground(Color.DARK_GRAY);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.BLACK);
        jTable1.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        sp = new JScrollPane(jTable1);
        sp.setBackground(Color.BLACK);
        sp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        // p2.setLayout(new BorderLayout());
        jTable1.setFillsViewportHeight(true);
        jTable1.setPreferredScrollableViewportSize(new Dimension(225,500));
        p2.add(sp);
        p2.revalidate();
        p2.repaint();
    }
    public void issuebooktostudentbyselectionInterface(){
        JLabel jLabel = new JLabel("Enter Student Name ");
        jLabel.setForeground(Color.WHITE);
        jTextField = new JTextField(10);
        jButton = new JButton("Enter");
        jButton.addActionListener(this);
        p2.add(jLabel);
        p2.add(jTextField);
        p2.add(jButton);
    }
    public void doubleList(String studentname) throws SQLException {
        this.sname = studentname;
        repository.update();
        if(!repository.studentdb.containsKey(sname)){
            JOptionPane.showMessageDialog(null,"Student not present in list "+sname);
            issuebooktostudentbyselectionInterface();
            return;
        }
       List<Books> books1 = repository.getAllBooks();
       String s[] = new String[books1.size()];
       int k=0;
       for (Books i: books1){
           s[k++] = i.getName();
       }
        list1 = new JList(s);
        list2 = new JList();
//        list1.setBounds(0,100,100,490);
//        list1.setPreferredSize(new Dimension(50,470));
        list1.setForeground(Color.WHITE);
        list1.setBackground(Color.DARK_GRAY);
        list2.setForeground(Color.WHITE);
        list2.setBackground(Color.DARK_GRAY);
        list1.addMouseListener(this);
        jScrollPane1 = new JScrollPane(list1);
        jScrollPane2 = new JScrollPane(list2);
        jScrollPane1.setPreferredSize(new Dimension(180,430));
        jScrollPane2.setPreferredSize(new Dimension(180,430));
        JButton jButton1 = new JButton("Select->>");
        jButton1.setForeground(Color.black);
        jButton1.setBackground(Color.BLUE);
        JButton jButton2 = new JButton("<<-Deselect");
        jButton2.setForeground(Color.black);
        jButton2.setBackground(Color.ORANGE);
        jButton3 = new JButton("Submit");
        jButton3.setForeground(Color.black);
        jButton3.setBackground(Color.red);

        p2.add(jScrollPane1);
        p2.add(jScrollPane2);
        p2.add(jButton3);
        JOptionPane.showMessageDialog(null,"Welcome to select and book Area"+"\n"+sname+"\n"+"-----Confirmation by 'Submit' Button-----");
    }
    public void DeleteBook() throws SQLException {
        List<Books> books1 = repository.getAllBooks();
        String str [] = new String[books1.size()];
        for (int i=0;i<books1.size();i++){
            str[i]=books1.get(i).getName();
        }
        list3 = new JList(str);
        list3.setForeground(Color.WHITE);
        list3.setBackground(Color.DARK_GRAY);
        list3.addMouseListener(this);
        jScrollPane3 = new JScrollPane(list3);
        jScrollPane3.setPreferredSize(new Dimension(180,430));
        jTextField1 = new JTextField(10);
        jButton1 = new JButton("Delete");
        jButton1.addActionListener(this);
        p2.add(jScrollPane3);
        p2.add(jTextField1);
        p2.add(jButton1);
    }
    public void retrunBookInterface() throws SQLException {
        JLabel jLabel = new JLabel("Enter Student Name");
        jLabel.setForeground(Color.WHITE);
        jTextField2 = new JTextField(10);
        jButton2 = new JButton("Search");
        jButton2.addActionListener(this);
        Map<String,List<Books>> map = repository.getStudentBookdb();
        String [] strings = new String[map.size()];
        int j=0;
        for(String i: map.keySet()){
            strings[j++]=i;
        }
        jList8 = new JList(strings);
        jList8.setForeground(Color.WHITE);
        jList8.setBackground(Color.DARK_GRAY);
        jList8.addMouseListener(this);
        jScrollPane4 = new JScrollPane(jList8);
        jScrollPane4.setPreferredSize(new Dimension(180,430));
        p2.add(jLabel);p2.add(jTextField2);p2.add(jButton2);p2.add(jScrollPane4);
    }
    public void  retrunBookfunction(String name) throws SQLException {

        repository.update();
        List<Books> books4 = repository.getStudentIssueBooks(name);
        if(books4==null){
            JOptionPane.showMessageDialog(null,name+" This student not having any book"+"\n"+"or"+"\n"+"Invalid Student name");
            retrunBookInterface();
            return;
        }
        String str [] = new String[books4.size()];
        for (int i=0;i<books4.size();i++){
            str[i]=books4.get(i).getName();
        }
        jlist1 = new JList(str);
        jlist1.setForeground(Color.WHITE);
        jlist1.setBackground(Color.DARK_GRAY);
        jlist1.addMouseListener(this);
        jScrollPane5 = new JScrollPane(jlist1);
        jScrollPane5.setPreferredSize(new Dimension(180,430));
        jTextField3 = new JTextField(10);
        jButton4 = new JButton("Return");
        jButton4.addActionListener(this);
        p2.add(jScrollPane5);
        p2.add(jTextField3);
        p2.add(jButton4);
    }
    public void returnBook2(String studentName,String bookName) throws SQLException {
        if(studentName.equals("")){
            System.out.println("something wrong in book issue");
        }
        repository.update();
        repository.returnBook(studentName,bookName);
    }
    public boolean checkDigit(String s1){
        for(int i=0;i<s1.length();i++){
            if(Character.isDigit(s1.charAt(i))){
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
   public void UpdateBook() throws SQLException {
       List<Books> books1 = repository.getAllBooks();
       String str [] = new String[books1.size()];
       for (int i=0;i<books1.size();i++){
           str[i]=books1.get(i).getName();
       }
       jList2 = new JList(str);
       jList2.setForeground(Color.WHITE);
       jList2.setBackground(Color.DARK_GRAY);
       jList2.addMouseListener(this);
       JScrollPane jScrollPane6 = new JScrollPane(jList2);
       jScrollPane6.setPreferredSize(new Dimension(180,430));

        p2.add(jScrollPane6);

    }
    public int count;
    public String name123;
    public void UpdateBook2() throws SQLException {
//        JTextField jTextField4 = new JTextField(books1.get(0).getName());
//        JTextField jTextField5 = new JTextField(books1.get(0).getAuthor());
//        JTextField jTextField6 = new JTextField(books1.get(0).getSerialNo());
        System.out.println(count);
        jTextField7 = new JTextField(10);
        jTextField7.setText(String.valueOf(count));
        button = new JButton("+1");
        button.addActionListener(this);
        button3 = new JButton("-1");
        button3.addActionListener(this);
        button1 = new JButton("Update");
        button1.addActionListener(this);
        p2.add(jTextField7);p2.add(button);p2.add(button3);p2.add(button1);
    }
    public void duallistfuntion2(String str,String order){
        if(check(str)==true&&order.equals("add")){
            JOptionPane.showMessageDialog(null,"Book Already in booking area");
        }
        else if(order.equals("add")){
            s.add(str);
        } else if (order.equals("remove")) {
            s.remove(str);
        }

        list2 = new JList(convert());
//        list1.setBounds(0,100,100,490);
//        list1.setPreferredSize(new Dimension(50,470));

        list2.setForeground(Color.WHITE);
        list2.setBackground(Color.DARK_GRAY);
        list2.addMouseListener(this);
        jScrollPane2 = new JScrollPane(list2);
        jScrollPane1.setPreferredSize(new Dimension(180,430));
        jScrollPane2.setPreferredSize(new Dimension(180,430));
        jButton3 = new JButton("Submit");
        jButton3.setForeground(Color.black);
        jButton3.setBackground(Color.red);
        jButton3.addActionListener(this);
        p2.add(jScrollPane2);
        p2.add(jButton3);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view){
            p2.removeAll();
            try {
                getAllBooks();
                System.out.println("dsfsfsfs");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
            System.out.println("dsfsfsfs");
        }
        else if (e.getSource() == author){
            p2.removeAll();
            getBookByAuthorInterface();
            p2.revalidate();
            p2.repaint();


        }
        else if (e.getSource() == name) {
            p2.removeAll();
            getBookByNameInterface();
            p2.revalidate();
            p2.repaint();

        }
        else if (e.getSource() == serial) {
            p2.removeAll();
            getBookBySerialNoInterface();
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == viewstudent) {
            p2.removeAll();
            try {
                getAllStudent();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == studentname) {
            p2.removeAll();
            getStudentByNameInterface();
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() ==studentenrollment){
            p2.removeAll();
            getStudentByEnrollInterface();
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == issuebyname) {
            p2.removeAll();
            issuebooktostudentbynameInterface();
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == issuebookbutton) {
            try {
                issuebooktostudentbyname();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == issuebookbuttons) {
            try {
                issuebooktostudentbyserial();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == issuebookbyserial) {
            p2.removeAll();
            issuebooktostudentbyserialInterface();
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == authorbutton) {
            try {
                getBookByAuthor();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == namebutton) {
            try {
                getBookByName();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == serialbutton) {
            try {
              getBookBySerialNo();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == studentnamebutton) {
            try {
                getStudentByName();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == studentenrollbutton) {
            try {
                getStudentByEnroll();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == AddBook) {
            p2.removeAll();
            AddBookInteface();
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == AddStudent) {
            p2.removeAll();
            AddStudentInterface();
            p2.revalidate();
            p2.repaint();

        }
        else if (e.getSource() == addbookbutton) {
            System.out.println("okkk");
            try {
                AddBook();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == addstudentbutton) {
            try {
                AddStudent();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == l1) {
            p2.removeAll();
            try {
                studentbookdb();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() ==issuebookBySelection) {
            p2.removeAll();
            issuebooktostudentbyselectionInterface();
            p2.revalidate();
            p2.repaint();
        }
        else if(e.getSource()==jButton){
            p2.removeAll();
            try {
                doubleList((String)jTextField.getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if(e.getSource()==l){
            System.exit(007);
        } else if (e.getSource() == jButton3) {
            p2.removeAll();
            try {
                issuebookBylist();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == l3) {
            //int result = JOptionPane.showConfirmDialog(null,"Its Only Allow to delete books which are in record not issues");
            //f(result==JOptionPane.YES_NO_OPTION){
                try {
                    p2.removeAll();
                    DeleteBook();
                    p2.revalidate();
                    p2.repaint();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            //}
        } else if (e.getSource()==jButton1) {
            String str = jTextField1.getText();
            String status1="";
            int result=JOptionPane.showConfirmDialog(null,"Confirm to delete "+str,"delete",JOptionPane.CANCEL_OPTION,JOptionPane.OK_OPTION);
            if(result==JOptionPane.OK_OPTION){
                try {
                    status1 = repository.removeBook(str);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(status1.equals("Not present")){
                JOptionPane.showMessageDialog(null,"Enter Valid Bookname");
            }

            p2.removeAll();
            try {
                DeleteBook();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == l4) {
            p2.removeAll();
            try {
                retrunBookInterface();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if(e.getSource()==jButton2){
            p2.removeAll();
            String name = jTextField2.getText();
            try {
                retrunBookfunction(name);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == l2) {
            p2.removeAll();
            try {
                UpdateBook();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == jButton4) {
            if(jTextField3.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter valid book name");
            }
            else{
                int result= JOptionPane.showConfirmDialog(null,"You want to return "+jTextField3.getText());
                if(result==JOptionPane.OK_OPTION){
                    try {
                        returnBook2(name12,jTextField3.getText());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    p2.revalidate();
                    p2.repaint();

                }
                p2.removeAll();
                try {
                    retrunBookfunction(name12);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                p2.revalidate();
                p2.repaint();
            }
        } else if (e.getSource() == button) {
            if(count==10){
                JOptionPane.showMessageDialog(null,"Not Allow");
                return;
            }
            count++;
            p2.removeAll();
            try {
                UpdateBook2();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource()==button3) {
            if(count>0){
                count--;
            }
          else {
              JOptionPane.showMessageDialog(null,"Not Allow");
            }
          p2.removeAll();
            try {
                UpdateBook2();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == button1) {
            String s1 = jTextField7.getText();
            if(checkDigit(s1)&&Integer.parseInt(s1)<=10&&Integer.parseInt(s1)>0){
                try {
                    repository.UpdateBook(name123,Integer.parseInt(s1));
                    p2.removeAll();
                    UpdateBook();
                    p2.revalidate();
                    p2.repaint();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Please Enter Valid Digits");
            }
        }
    }
public int pp=0;
    @Override
    public void mouseClicked(MouseEvent e) {
        //p2.removeAll();

        if(e.getSource()==list){

            p2.remove(sp);
            try {
                studentbookdbtable((String) list.getSelectedValue());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == list1) {
            p2.remove(jButton3);
            p2.remove(jScrollPane2);
            duallistfuntion2((String) list1.getSelectedValue(),"add");

            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == list2) {
            p2.remove(jButton3);
            p2.remove(jScrollPane2);
            duallistfuntion2((String) list2.getSelectedValue(),"remove");
            p2.revalidate();
            p2.repaint();
        }
        else if (e.getSource() == jList8) {
            p2.removeAll();
            name12 = (String)jList8.getSelectedValue();
            try {
                retrunBookfunction(name12);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == jlist1) {
            int result= JOptionPane.showConfirmDialog(null,"You want to return "+jlist1.getSelectedValue());
            if(result==JOptionPane.OK_OPTION){
                try {
                    returnBook2(name12,(String) jlist1.getSelectedValue());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                p2.revalidate();
                p2.repaint();

            }
            p2.removeAll();
            try {
                retrunBookfunction(name12);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        } else if (e.getSource() == jList2) {
            p2.removeAll();
            try {
                repository.update();
                List<Books> books1 = repository.getBookByName((String) jList2.getSelectedValue());
                count=books1.get(0).getBookCount();
                name123=(String) jList2.getSelectedValue();
                UpdateBook2();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            p2.revalidate();
            p2.repaint();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
