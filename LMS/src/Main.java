import Frame.frame;
import Server.Server;

import java.sql.SQLException;

public class Main extends Thread {
   public void run(){
       try {
           new Server();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }
    public static void main(String[] args)  throws SQLException {


        Main m = new Main();
        m.start();
        new frame();


    }
}