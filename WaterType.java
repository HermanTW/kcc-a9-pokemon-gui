/**
* interface for Water type Pokemon.
* Fails checkstyle because no methods.
* @author Lisa Miller
* @since 9/17/2017
*/
public interface WaterType {
   /** constants **/
   /** Type name String. */
   String WATER_TYPE = new String("Water");
   /** Type color String. */ 
   String WATER_COLOR = new String("Blue");
   /** Array of type fast attack names. */
   String[] WATER_FAST_ATTACKS = {"Bubble", "Splash", "Water Gun"};
   /** Array of type special attack names. */
   String[] WATER_SPECIAL_ATTACKS = {"Aqua Jet", "Aqua Tail", 
      "Brine", "Bubble Beam", "Hydro Pump", "Scald", "Water Pulse"};
   /** Array of fast attack powers, coincides with name array. */
   int[] WATER_FAST_ATK_POWER = {25, 0, 6};
   /** Array of special attack powers, coincides with name array. */  
   int[] WATER_SPECIAL_ATK_POWER = {25, 45, 25, 30, 90, 55, 35};

}