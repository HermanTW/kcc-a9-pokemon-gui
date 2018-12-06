import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
* PokeGUI class.
* @author Tom Herman
* @version 1.0
* @since 12/15/2018
*/
public class PokeGUI extends JFrame implements ActionListener {

   private JFrame frame = new JFrame(String title);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   private JPanel top = new JPanel();
   private JPanel bot = new JPanel();
   
   private JLabel fTitle = new JLabel("PokeApp");
   private JLabel topTitle = new JLabel("Safari Zone");
   private JLabel botTitle = new JLabel("PokeMenu");
   
   private JButton bHunt = new JButton(" Hunt ");
   private JButton bCatch = new JButton(" Catch ");
   
   private GUIListener listener = new GUIListener();
   
   private JTextField tfArea = new JTextField(10);
   
   JTabbedPane pane = new JTabbedPane();

   JComponent panel1 = makeTextPanel("Panel #1");
   pane.addTab("Pokedex", icon, tfArea,
                     "Displays Pokedex");
   pane.setMnemonicAt(0, KeyEvent.VK_1);
   
   JComponent panel2 = makeTextPanel("Panel #2");
   pane.addTab("Tab 2", icon, panel2,
                     "Does twice as much nothing");
   pane.setMnemonicAt(1, KeyEvent.VK_2);
   
   JComponent panel3 = makeTextPanel("Panel #3");
   pane.addTab("Tab 3", icon, panel3,
                     "Still does nothing");
   pane.setMnemonicAt(2, KeyEvent.VK_3);
   
   JComponent panel4 = makeTextPanel(
           "Panel #4 (has a preferred size of 410 x 50).");
   panel4.setPreferredSize(new Dimension(410, 50));
   pane.addTab("Tab 4", icon, panel4,
                         "Does nothing at all");
   pane.setMnemonicAt(3, KeyEvent.VK_4);
      
}