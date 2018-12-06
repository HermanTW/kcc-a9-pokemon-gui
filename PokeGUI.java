import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
* PokeGUI class.
* @author Tom Herman
* @version 1.0
* @since 12/15/2018
*/
public class PokeGUI {
 /**
   * main method.
   * 
   * @param args not used
   */
   public static void main(String[] args) {
      JFrame frm = new JFrame("PokeApp");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frm.getContentPane().add(new PokePanel());
      
      frm.pack();
      frm.setVisible(true);   
   }
}