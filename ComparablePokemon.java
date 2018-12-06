import java.util.*;

/* Tom Herman
 * Assignment 6
 * 11/05/18
 */

/**
   ComparablePokemon class.
   Tests PriorityQueue and Stack
*/

public class ComparablePokemon {
   /**
     * Main method.
     * Develops stack and queue for Pokemon
     *
     * @param args not used
     */
   public static void main(String[] args) {
      PriorityQueue<Pokemon> pQ = new PriorityQueue<>();
      Deque<Pokemon> pS = new ArrayDeque<Pokemon>();
      Pokemon poke = new Bulbasaur();
      
      pQ.add(poke);
      pS.push(poke);
      poke = new Bulbasaur("Al");
      pQ.add(poke);
      pS.push(poke);
      poke = new Bulbasaur("Bob");
      pQ.add(poke);
      pS.push(poke);
      poke = new Bulbasaur("Charlie");
      pQ.add(poke);
      pS.push(poke);
      for (int i = 0; i < 10; i++) { //adds 10 of each pokemon to pQ and pS
         poke = new Bulbasaur();
         pQ.add(poke);
         pS.push(poke);
         poke = new Ivysaur();
         pQ.add(poke);
         pS.push(poke);
         poke = new Venusaur();
         pQ.add(poke);
         pS.push(poke);
         poke = new Charmander();
         pQ.add(poke);
         pS.push(poke);
         poke = new Charmeleon();
         pQ.add(poke);
         pS.push(poke);
         poke = new Charizard();
         pQ.add(poke);
         pS.push(poke);
         poke = new Squirtle();
         pQ.add(poke);
         pS.push(poke);
         poke = new Wartortle();
         pQ.add(poke);
         pS.push(poke);
         poke = new Blastoise();
         pQ.add(poke);
         pS.push(poke);
      }     
            
      System.out.println("\nHere is the Priority Queue printout:\n");

      while (pQ.size() > 0) {
         poke = pQ.poll();
         System.out.println(poke.toString() + "\n");
      }
      
      System.out.println("\nHere is the Stack printout:\n");

      while (pS.size() > 0) {
         poke = pS.pop();
         System.out.println(poke.toString() + "\n");
      }

      
   }
}
