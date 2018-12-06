/**
* interface for Grass type Pokemon.
* Fails checkstyle because no methods.
* @author Lisa Miller
* @since 9/17/2017
*/
public interface GrassType {
   /** constants **/
   /** Type name String. */
   String GRASS_TYPE = new String("Grass");
   /** Type color String. */
   String GRASS_COLOR = new String("Green");
   /** Array of type fast attack names. */
   String[] GRASS_FAST_ATTACKS = {"Razor Leaf", "Vine Whip"};
   /** Array of type special attack names. */
   String[] GRASS_SPECIAL_ATTACKS = {"Leaf Blade", "Petal Blizzard", 
      "Power Whip", "Seed Bomb", "Solar Beam"};
   /** Array of fast attack powers, coincides with name array. */
   int[] GRASS_FAST_ATK_POWER = {15, 7};
   /** Array of special attack powers, coincides with name array. */       
   int[] GRASS_SPECIAL_ATK_POWER = {55, 65, 70, 40, 120}; 
}