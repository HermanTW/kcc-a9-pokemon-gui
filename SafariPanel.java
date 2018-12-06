import java.awt.*;
import javax.swing.*;
/**
* SafariPanel class.
* @author Tom Herman
* @version 1.0
* @since 12/15/2018
*/
public class SafariPanel extends JPanel {
   
   public SafariPanel() {
      setBackgroundColor(Color.gray);
      setPreferredSize(new Dimension(300, 300));

      add(new JLabel("SAFARI ZONE"));

   }
}