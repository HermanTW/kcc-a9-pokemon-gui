import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

import java.util.Random;
/**
* PokePanel class.
* @author Tom Herman
* @version 1.0
* @since 12/15/2018
*/
public class PokePanel extends JPanel {
   ImageIcon huntIcon = new ImageIcon("binoc.png");
   ImageIcon catchIcon = new ImageIcon("Pokeball.jpg");
   ImageIcon dexIcon = new ImageIcon("Pokedex.png");
   ImageIcon packIcon = new ImageIcon("backpack.png");
   ImageIcon pixelIcon = new ImageIcon("pixel.png");
      
   
   private JLabel title = new JLabel("Safari Zone");
   private JLabel safari = new JLabel("No Pokemon in sight");
   
   private JPanel topPanel = new JPanel();
   private JPanel topSubPanel = new JPanel();
   private JPanel midPanel = new JPanel();
   private JPanel botPanel = new JPanel();
   
   //private PokeListener listener = new PokeListener();
   
   private JTextField tfZone = new JTextField(10);
   private JTextField tfBox = new JTextField(10);
   private JTextField tfDex = new JTextField(10);
    
   JTabbedPane menuPane = new JTabbedPane();
   
   private JScrollPane scrollDex = new JScrollPane(tfDex, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
   private JScrollPane scrollBox = new JScrollPane(tfBox, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
   
   private JButton bHunt = new JButton(" Hunt ", huntIcon);
   private JButton bCatch = new JButton(" Catch ", catchIcon);
   private JButton bDex = new JButton(" Pokedex ", dexIcon);
   private JButton bPack = new JButton(" Backpack ", packIcon);
   private PokeListener listener = new PokeListener();
   //bHunt.addActonListener(new PokeListener());
   //bCatch.addActionListener(new PokeListener());
   
   
   public PokePanel() {
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(800, 1000));

      topPanel.add(title);
      topPanel.setBackground(Color.green);
     
      topSubPanel.add(safari);
      topPanel.add(topSubPanel);
      midPanel.add(bHunt);
      midPanel.add(bCatch);
      midPanel.add(bDex);
      midPanel.add(bPack);
      
      menuPane.addTab("Pokedex", pixelIcon, scrollDex, "Selects Pokedex");
      menuPane.addTab("Backpack", pixelIcon, scrollBox, "Selects Backpack");
      botPanel.add(menuPane);
      
      add("North", topPanel);
      add("Center", midPanel);
      add("South", menuPane);
      

   }


 /**
   * Private PokeListener class.
   */
   private class PokeListener implements ActionListener {
   
 /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
   public void actionPerformed(ActionEvent event) {
      
      Random randGen = new Random();
      int catcher = 0;
      String output = "";
      if (event.getSource() == bHunt) { 
         Pokemon poke = hunt();
         output = "A wild Pokemon has appeared!\n\n"
            + poke.toString();
         tfZone.setText(output);
      }
      if (event.getSource() == bCatch) {
         
      }     
                 
   }
 
 /**
   * Hunt method.
   * Returns random Pokemon
   *
   * @return wild randomly selected Pokemon
   */
   public Pokemon hunt() {
      Random randGen = new Random();
      int num = randGen.nextInt(9) + 1;
      Pokemon wild = new Bulbasaur();
      switch(num) {
         case 1:
            wild = new Bulbasaur();
            break;
         case 2:
            wild = new Ivysaur();
            break;
         case 3:
            wild = new Venusaur();
            break;
         case 4:
            wild = new Charmander();
            break;
         case 5:
            wild = new Charmeleon();
            break;
         case 6:
            wild = new Charizard();
            break;
         case 7:
            wild = new Squirtle();
            break;
         case 8:
            wild = new Wartortle();
            break;
         case 9:
            wild = new Blastoise();
            break;
         default:
            wild = new Bulbasaur();
            break;
         }
         return wild;
      }
   }
}
             