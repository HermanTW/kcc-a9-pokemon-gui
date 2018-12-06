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
      Deque<Pokemon> pS = new ArrayDeque<>();
      Pokemon poke = new Bulbasaur();
                  
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
   
   public String stackString() {
      Deque<Pokemon> mirror = new ArrayDeque<Pokemon>();
      while (pS.size() > 0) {
         poke = pS.pop();
         System.out.println(poke.toString() + "\n");
         mirror.push(poke);
      }
      while (pS.size() > 0) {
         pS.push(mirror.pop());
      }
   
   public String queueString() {
      PriorityQueue<Pokemon> temp = new PriorityQueue<>();
      
      while (pQ.size() > 0) {
         poke = pQ.poll();
         System.out.println(poke.toString() + "\n");
         temp.add(poke);
      }
      pQ = temp;
   }
   
   
   
}
