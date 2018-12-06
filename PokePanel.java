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
   private JPanel botPanel = new JPanel();
   
   //private PokeListener listener = new PokeListener();
   
   private JTextArea taZone = new JTextArea();
   private JTextArea taPack = new JTextArea();
   private JTextArea taDex = new JTextArea();
       
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
   
   
   
   public PokePanel() {
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(600, 800));

      taZone.setEditable(false);
      taPack.setEditable(false);
      taDex.setEditable(false);
     
      topPanel.add(title);
      topPanel.setBackground(Color.green);
     
      taZone.setText("No Pokemon in sight. . .");  
      topSubPanel.add(taZone);
      topPanel.add(topSubPanel);
      midPanel.add(bHunt);
      midPanel.add(bCatch);
      botPanel.add(bDex);
      botPanel.add(bPack);
      bHunt.addActionListener(new PokeListener());
      bCatch.addActionListener(new PokeListener());
      bPack.addActionListener(new PokeListener());
      bDex.addActionListener(new PokeListener());
      
      menuPane.addTab("Pokedex", null, scrollDex, "Selects Pokedex");
      menuPane.addTab("Backpack", null, scrollPack, "Selects Backpack");
      botPanel.add(menuPane);
      
      add("North", topPanel);
      add("Center", midPanel);
      add("South", botPanel);
      

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
         catcher = randGen.nextInt(10);
         if (catcher >= 5) {
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
         taZone.setText(output); 
      }
      if (event.getSource() == bDex) {
         taDex.setText(pokeDex.printPokeTree());
      }
      if (event.getSource() == bPack) {
         taPack.setText(stackString());
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
   
   public String queueString() {
      String queueOutput = "";
      
      for (int j = 0; j < pQ.size(); j++) {
         poke = pQ.poll();
         queueOutput += poke.toString() + "\n\n";
         pQ.add(poke);
      }
      return queueOutput;
   }

}
             