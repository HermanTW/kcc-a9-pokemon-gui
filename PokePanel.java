import java.util.*;
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
   
   private Pokemon poke = null;
   
   PriorityQueue<Pokemon> pQ = new PriorityQueue<>();
   Deque<Pokemon> pS = new ArrayDeque<>();
   PokeTree pokeDex = new PokeTree(); 
   
   private JLabel title = new JLabel("Safari Zone");
   //private JLabel safari = new JLabel("No Pokemon in sight");
   
   private JPanel topPanel = new JPanel();
   private JPanel topSubPanel = new JPanel();
   private JPanel midPanel = new JPanel();
   private JPanel midSubPanel = new JPanel();
   private JPanel botPanel = new JPanel();
   private JPanel botSubPanel = new JPanel();
   
   //private PokeListener listener = new PokeListener();
   
   private JTextArea taZone = new JTextArea("No Pokemon in sight. . .");
   private JTextArea taPack = new JTextArea(20, 10);
   private JTextArea taDex = new JTextArea(20, 10);
       
   Choice ch = new Choice( );   
       
   JTabbedPane menuPane = new JTabbedPane();
   
   private JScrollPane scrollDex = new JScrollPane(taDex, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
   private JScrollPane scrollPack = new JScrollPane(taPack, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
   
   private JButton bHunt = new JButton(" Hunt ", huntIcon);
   private JButton bCatch = new JButton(" Catch ", catchIcon);
   private JButton bDex = new JButton(" Pokedex ", dexIcon);
   private JButton bPack = new JButton(" Backpack ", packIcon);
   private PokeListener listener = new PokeListener();
   
 /**
   * PokePanel method.
   * Main panel of PokeGUI
   */  
   
   public PokePanel() {
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(300, 800));
    
      topPanel.setLayout(new BorderLayout());
      topPanel.setPreferredSize(new Dimension(400, 300));
      topSubPanel.setLayout(new BorderLayout());
      topSubPanel.setPreferredSize(new Dimension(100, 100));
      midPanel.setLayout(new BorderLayout());
      midPanel.setPreferredSize(new Dimension(10, 10));
      midSubPanel.setLayout(new BorderLayout());
      midSubPanel.setPreferredSize(new Dimension(5, 5));
      botPanel.setLayout(new BorderLayout());
      botPanel.setPreferredSize(new Dimension(400, 440));
      botSubPanel.setLayout(new BorderLayout());
      botSubPanel.setPreferredSize(new Dimension(100, 100));
      
      taZone.setEditable(false);
      taPack.setEditable(false);
      taDex.setEditable(false);
     
      topPanel.add(title, "North");
      topPanel.setBackground(Color.green);
     
      taZone.setText("No Pokemon in sight. . .");  
      topPanel.add(taZone, "Center");
      topSubPanel.add(bHunt, "West");
      topSubPanel.add(bCatch, "East");
      topPanel.add(topSubPanel, "South");
      
      midPanel.add(bDex, "West");
      midPanel.add(bPack, "East");
      midPanel.setBackground(Color.red);

      ch.add("Recent");
      ch.add("Number");
      botPanel.add(ch, "North");
      
      bHunt.addActionListener(new PokeListener());
      bCatch.addActionListener(new PokeListener());
      bPack.addActionListener(new PokeListener());
      bDex.addActionListener(new PokeListener());
                  
      menuPane.addTab("Pokedex", null, scrollDex, "Selects Pokedex");
      menuPane.addTab("Backpack", null, scrollPack, "Selects Backpack");
      botPanel.add(menuPane, "South");
      botPanel.setBackground(Color.blue);

      add(topPanel, "North");
      add(midPanel, "Center");
      add(botPanel, "South");
      

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
         poke = hunt();
         output = poke.getName() + " has appeared!\n\n"
            + poke.toString();
         taZone.setText(output);
      }
      if (event.getSource() == bCatch) {
         if (poke == null) {
            output = "No Pokemon around to catch!";
         } else {
            catcher = randGen.nextInt(10);
            if (catcher > 2) {
               output = poke.getName() + " has been captured!\n\n"
                  + poke.toString();
               pS.push(poke);
               pQ.add(poke);
               pokeDex.add(poke);
               poke = null;
            } else {
               output = poke.getName() + " has escaped!\n\n"
                  + poke.toString();
               poke = null;
            }
         }
         taZone.setText(output); 
      }
      if (event.getSource() == bDex) {
         taDex.setText(pokeDex.printPokeTree());
      }
      if (event.getSource() == bPack) {
         if (ch.getSelectedItem() == "Recent") {
            taPack.setText(stackString());
         } else {
            taPack.setText(queueString());
         }
      }     
                 
   }
 
 /**
   * Hunt method.
   * Returns random Pokemon
   *
   * @return poke randomly selected Pokemon
   */
   public Pokemon hunt() {
      Random randGen = new Random();
      int num = randGen.nextInt(9) + 1;
      switch(num) {
         case 1:
            poke = new Bulbasaur();
            break;
         case 2:
            poke = new Ivysaur();
            break;
         case 3:
            poke = new Venusaur();
            break;
         case 4:
            poke = new Charmander();
            break;
         case 5:
            poke = new Charmeleon();
            break;
         case 6:
            poke = new Charizard();
            break;
         case 7:
            poke = new Squirtle();
            break;
         case 8:
            poke = new Wartortle();
            break;
         case 9:
            poke = new Blastoise();
            break;
         default:
            poke = new Bulbasaur();
            break;
         }
         return poke;
      }
   }
   
 /**
   * Stack print method.
   * returns string of all data in stack
   *
   * @return stackOutput String of all data in stack
   */  
   public String stackString() {
      String stackOutput = "";
      Deque<Pokemon> mirror = new ArrayDeque<Pokemon>();
      while (pS.size() > 0) {
         poke = pS.pop();
         stackOutput += poke.toString() + "\n\n";
         mirror.push(poke);
      }
      while (mirror.size() > 0) {
         pS.push(mirror.pop());
      }
      return stackOutput;
   }
   
 /**  
   * Queue print method.
   * 
   * @return queueString String of all data in queue
   */
   public String queueString() {
      String queueOutput = "";
      PriorityQueue<Pokemon> temp = new PriorityQueue<>();

      while (pQ.size() > 0) {
         poke = pQ.poll();
         queueOutput += poke.toString() + "\n\n";
         temp.add(poke);
      }
      pQ = temp;
      return queueOutput;
   }

}
             