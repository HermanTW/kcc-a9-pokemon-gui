import java.util.Random;
/**
* Charizard Pokemon object class.
* Subclass of Charmeleon
* @author Tom Herman
* @version 1.0
* @since 9/18/2018
*/
public class Charizard extends Charmeleon implements FlyingType {

   /** The minimum attack power for species. */ 
   static final int BASE_ATTACK_POWER = 223;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 176;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 156;
      
   /**
   * Constructor with no name.
   * uses Pokemon superclass constructor
   * attacks must be set after contruction of Pokemon Object
   * because of dependence on type interface
   */
   public Charizard() {
      super("Charizard", "Charizard", 6, 1.7, 90.5, 
            BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      type2 = FLYING_TYPE;   
      //pick Attacks after construct
      chooseFastAttack();
      chooseSpecialAttack();
   }
   /**
   * Constructor with name.
   * uses Pokemon superclass constructor
   * attacks must be set after contruction of Pokemon Object
   * because of dependence on type interface
   * @param name The user-defined name.
   */
   public Charizard(String name) {
      super("Charizard", name, 6, 1.7, 90.5, BASE_ATTACK_POWER, 
            BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      type2 = FLYING_TYPE;
   }
      
   /**
   * Fire|Flying-type specific fast attack chooser.
   * Randomly picks whether attack type is fire or flying
   * Randomly picks an attack from flying attack arrays if flying type
   * Retains same fire attack if type of attack unchanged
   */
   protected void chooseFastAttack() {
      //randomly choose to get fire or flying attack
      Random randGen = new Random();
      int index;
      //set attack type boolean
      fastIsFire = randGen.nextBoolean();
      
      if (fastIsFire) { //chooses fire attack
         index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
         fastAttack = FIRE_FAST_ATTACKS[index];
         fastAttackPower = FIRE_FAST_ATK_POWER[index];
      } else { //chooses flying attack
         index = randGen.nextInt(FLYING_FAST_ATTACKS.length);
         fastAttack = FLYING_FAST_ATTACKS[index];
         fastAttackPower = FLYING_FAST_ATK_POWER[index];
      }  
   }
   
  /**
   * Fire|Flying-type specific special attack chooser.
   * Randomly picks whether attack type is fire or flying
   * If fire, retains old fire attack
   * If flying, randomly assings an attack from type interface attack arrays
   */
   protected void chooseSpecialAttack() {
      //randomly choose to get fire or flying attack
      Random randGen = new Random();
      int index;
      //set type choice boolean
      specialIsFire = randGen.nextBoolean();
      
      if (specialIsFire) { //chooses fire attack
         index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
         specialAttack = FIRE_SPECIAL_ATTACKS[index];
         specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
      } else { //chooses flying attack
         index = randGen.nextInt(FLYING_SPECIAL_ATTACKS.length);
         specialAttack = FLYING_SPECIAL_ATTACKS[index];
         specialAttackPower = FLYING_SPECIAL_ATK_POWER[index];
      }
   }
   
   /**
   * Game-play fast attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * Calls beAttacked method on attacked victim.
   *
   * @param victim the Pokemon being attacked
   * @return String explaining attack and effectiveness
   */
   public String performFastAttack(Pokemon victim) {
      
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
      
      //check effectiveness of attack
      if (fastIsFire) { //if attack is fire-type
         if (vType.equals("Grass") || vType.equals("Bug") 
             || vType.equals("Steel") || vType.equals("Ice")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Water") || vType.equals("Dragon") 
             || vType.equals("Fire") || vType.equals("Rock")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } else { //is flying attack
         if (vType.equals("Grass") || vType.equals("Fighting") 
             || vType.equals("Bug")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
            
         } else if (vType.equals("Electric") || vType.equals("Rock") 
             || vType.equals("Steel")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      }
      //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
   
  /**
   * Game-play special attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * uses Damage formula from here: 
   * http://bulbapedia.bulbagarden.net/wiki/Damage
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokemon being attacked.
   * @return String explaining attack and effectiveness.
   */
   public String performSpecialAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      
      //check effectiveness of attack
      if (specialIsFire) { //if attack is fire-type
         if (vType.equals("Bug") || vType.equals("Steel") 
             || vType.equals("Grass") || vType.equals("Ice")) {
             
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Water") || vType.equals("Dragon")
             || vType.equals("Fire") || vType.equals("Rock")) { 
            
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } else { //is flying attack
         if (vType.equals("Grass") || vType.equals("Fighting")
             || vType.equals("Bug")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
            
         } else if (vType.equals("Electric") || vType.equals("Rock") 
             || vType.equals("Steel")) {
             
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         } 
      }
   
      //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (specialAttackPower + 2) * modifier;
     
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
}