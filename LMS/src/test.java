package Lms.Interfaces;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class test implements MouseListener{
    static JFrame f;

    //lists
    static JList b;
    test(){

        //create a new frame
        f = new JFrame("frame");

        //create a object

        //create a panel
        JPanel p =new JPanel();

        //create a new label
        JLabel l= new JLabel("select the day of the week");

        //String array to store weekdays
        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday"};

        //create list
        Arrays.sort(week);
        b= new JList(week);
        b.addMouseListener(this);
        //set a selected index
        b.setSelectedIndex(2);
      JScrollPane jScrollPane = new JScrollPane(b);
        //add list to panel
        p.add(jScrollPane);

        f.add(p);

        //set the size of frame
        f.setSize(400,400);

        f.show();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(b.getSelectedValue());
        JOptionPane.showMessageDialog(null,b.getSelectedValue());
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

    public static void main(String[] args) {
        new test();
    }



}
