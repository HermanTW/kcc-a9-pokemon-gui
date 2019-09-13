/**
* Ivysaur Pokemon object class.
* Subclass of Bulbasaur
* @author Lisa Miller
* @version 1.0
* @since 9/24/2016
*/
public class Ivysaur extends Bulbasaur {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 156;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 158;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 120;
   
   /** Constructor with no name. */
   public Ivysaur() {
      super("Ivysaur", "Ivysaur", 2, 1.0, 13.0, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Ivysaur(String name) {
      super("Ivysaur", name, 2, 1.0, 13.0, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /** 
   * Constructor with species and name for subclasses.
   *@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon. 
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices. 
   */
   protected Ivysaur(String species, String name, int num, double ht, 
       double wt, int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr) {
      
      super(species, name, num, ht, wt, baseAttackPwr, 
          baseDefensePwr, baseStaminaPwr);
   }
   

}
   
