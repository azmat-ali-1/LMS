

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class framehelper {
    String sname;

    Books books = new Books();
    Repository repository = new Repository();
    JMenu menu, book, student, issue, logout;
    JMenuItem view,author,serial,name,studentname,studentenrollment,viewstudent, issuebyname, issuebookbyserial,issuebookBySelection;
    JPanel p2;
    JTextField authortextField,serialtextField,nametextField,studentnamefield,studentenrollfield,issuenbookfield,issuestudentfield;
    JTextField addbookname,addbookauthor,addbooknumber,addbookcount,addstudentname,addstudentenrol,addstudentbranch;
    JTextField jTextField,jTextField1,jTextField2,jTextField3;
    JLabel authorlabel,seriallabel,namelabel,studentnamelabel,studentenrolllabel,issuenamestudent,issuenamebook,addbooknameL,addbookauthorL,addbooknumberL,addbookcountL;
    JLabel addstudentnameL,addstudentenrolL,addstudentbranchL;
    public JTable jTable,jTable1;
    JMenuItem AddBook, AddStudent,i3, i4, i5,l;
    JFrame f;
    JButton authorbutton,serialbutton,namebutton,studentnamebutton,studentenrollbutton,issuebookbutton,addbookbutton,addstudentbutton,issuebookbuttons;
    JButton l1,l2,l3,l4,jButton2;
    JButton jButton,jButton1,jButton3,jButton4;
    JList list,list1,list2,list3,jList,jList1,jList8,jlist1;
    JScrollPane jScrollPane,jScrollPane1,jScrollPane2,sp,jScrollPane3,jScrollPane4,jScrollPane5;
    String name12="";
    public framehelper() throws SQLException {

    }
    public boolean check(String str){
        if(s.size()!=0){
            for (int i=0;i<s.size();i++){
                if(str.equals(s.get(i))){
                    return true;
                }
            }
        }
        return false;
    }
    List<String> s = new ArrayList<>();
    public String [] convert(){
        String [] newString = new String[s.size()];
        for (int i=0;i<s.size();i++){
            newString[i]=s.get(i);
        }
        return newString;
    }
    public void issuebookBylist() throws SQLException {
        if(s.size()==0){
            JOptionPane.showMessageDialog(null,"Please select book first");
        }
        for (int i=0;i<s.size();i++){
            String str = repository.issueBookToStudent(sname,s.get(i));
            if(str.equals("Student not present in list "+sname)){
                JOptionPane.showMessageDialog(null,str);
                return;
            }
        }
        String joption="";
        for(int i=0;i<s.size();i++){
            joption=joption+"\n"+s.get(i);
        }
        joption="Hi...   "+sname+" Your Books given below"+"\n"+joption;
        JOptionPane.showMessageDialog(null,joption);
    }


}
