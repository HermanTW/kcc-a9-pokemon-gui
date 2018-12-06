/**
* interface for Fire type Pokemon.
* Fails checkstyle because no methods.
* @author Lisa Miller
* @since 9/17/2017
*/
public interface PoisonType {
   /** constants **/
   /** Type name String. */
   String POISON_TYPE = new String("Poison");
   /** Type color String. */   
   String POISON_COLOR = new String("Purple");
   /** Array of type fast attack names. */
   String[] POISON_FAST_ATTACKS = {"Acid", "Poison Jab", "Poison Sting"};
   /** Array of type special attack names. */
   String[] POISON_SPECIAL_ATTACKS = {"Cross Poison", "Gunk Shot", 
      "Poison Fang", "Sludge", "Sludge Bomb", "Sludge Wave"};
   /** Array of fast attack powers, coincides with name array. */
   int[] POISON_FAST_ATK_POWER = {10, 12, 6}; 
   /** Array of special attack powers, coincides with name array. */      
   int[] POISON_SPECIAL_ATK_POWER = {25, 65, 25, 30, 55, 70};
}