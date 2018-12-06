import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
* PokeGUI class.
* @author Tom Herman
* @version 1.0
* @since 12/15/2018
*/
public class PokeGUI extends JPanel {
   
   private JPanel topPanel = new JPanel();
   private JPanel botPanel = new JPanel();
   
   private JButton bHunt = new JButton(" Hunt ");
   private JButton bCatch = new JButton(" Catch ");
   
   private JTextArea pArea = new JTextArea();
   private JScrollPane pDex = new JScrollPane(pArea,
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
      JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
   
   
 /**
   * main method.
   * 
   * @param args not used
   */
   public static void main(String[] args) {
      JFrame frm = new JFrame("ICS111 sample");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);







      frm.pack( );
      frm.setVisible(true);   
   }
}