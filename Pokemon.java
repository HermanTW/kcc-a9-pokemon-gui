import java.util.Random;
import java.text.*; //imports decimal format
/**
* Abstract parent class for Pokemon species.
* @author Tom Herman/Lisa Miller
* @since 8/18/18
*/
public abstract class Pokemon implements Comparable <Pokemon> {

   /*** instance variables. ***/
   /** The species name. */
   protected String species;
   /** The user-given name. */
   protected String name;
   /** The official Pokedex number. */
   protected int number;
   /** The color based on type. */
   protected String color;
   /** The height of the Pokemon. */
   protected double height;
   /** The weight of the Pokemon. */
   protected double weight;
   /** The main type, species-based. */
   protected String type1;
   /** The optional second type, species based. */
   protected String type2;
   
   //hidden from user, used to calc HP/CP
   /** The attack power used to calculate hit effectiveness. */
   protected int attackPower; 
   /** The defensive power, used to calculate hit defense. */
   protected int defensePower;
   /** The stamina, used to calculate power while battling. */
   protected int staminaPower;
   /** The level, used to calculate HP and CP maximums. */
   protected double level;
   
   //for battling
   /** The hit points, for calculating hit effectiveness. */
   protected int hP;
   /** The combat power, for calculating battle outcomes. */
   protected int cP;
   /** The name of the Fast Attack.*/
   protected String fastAttack;
   /** The power of the Fast Attack. */
   protected int fastAttackPower;
   /** The name of the Special Attack. */
   protected String specialAttack;
   /** The power of the Special Attack. */
   protected int specialAttackPower;
  
   //also hidden converts level to multiplier for CP
   /** Value used to calculate CP based on level. */
   private double[] cpMultiplier = 
   {   0.094,  0.16639787,  0.21573247,  0.25572005,  0.29024988,
       0.3210876,  0.34921268,  0.37523559,  0.39956728,  0.42250001,
       0.44310755,  0.46279839,  0.48168495,  0.49985844,  0.51739395,
       0.53435433,  0.55079269,  0.56675452,  0.58227891,  0.59740001,
       0.61215729,  0.62656713,  0.64065295,  0.65443563,  0.667934,
       0.68116492,  0.69414365,  0.70688421,  0.71939909,  0.7317,
       0.73776948,  0.74378943,  0.74976104,  0.75568551,  0.76156384,
       0.76739717,  0.7731865,  0.77893275,  0.78463697,  0.79030001};
  
   
   /**
   * constructor. 
   *@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param number The Pokedex number for this species.
   *@param color The type1-based color.
   *@param height The height of this Pokemon.
   *@param weight The weight of this Pokemon. 
   *@param type1 The main type of this species.
   *@param type2 The optional second type for species.
   *@param baseAttackPower The low limit of Attack Power for species.
   *@param baseDefensePower The low limit of Defense Power for species.
   *@param baseStaminaPower The low limit of Stamina Power for speices. 
   **/
   public Pokemon(String species, String name, 
       int number, String color, double height, double weight,
       String type1, String type2, int baseAttackPower, 
       int baseDefensePower, int baseStaminaPower) {
      
      //for initial level
      Random randGen = new Random();
      //for calc of CP
      double cpMult;
   
      //set simple instance variables
      this.species = species;
      if (name.equals("")) {
         throw new PokemonException("ERROR: Name cannot be blank!");
      } else {
         this.name = name;
      }
      this.number = number;
      this.color = color;
      this.height = height;
      this.weight = weight;
      this.type1 = type1;
      this.type2 = type2;
      
      //generate initial level
      this.level = (double) randGen.nextInt(40);
   
      //calculate multiplier for stats
      cpMult = cpMultiplier[(int) level];
      
      //calculate hidden stats attack. defense, stamina power
      attackPower = (int) ((baseAttackPower + randGen.nextInt(16)) * cpMult);
      defensePower = (int) ((baseDefensePower + randGen.nextInt(16)) * cpMult);
      staminaPower = (int) ((baseStaminaPower + randGen.nextInt(16)) * cpMult);
   
      //set Pokemon's HP and CP from attack, defense and stamina
      calculateHPAndCP(); 
      
      //attacks null here, have to be set separately in subclasses due to type
      fastAttack = null;
      fastAttackPower = 0;
      specialAttack = null;
      specialAttackPower = 0;
   }
   
   /**
   * Private method to calculate or update HP and CP.
   * uses formula from here: 
   * https://pokemongo.gamepress.gg/pokemon-stats-advanced
   */
   private void calculateHPAndCP() {
      //calculate multiplier for stats
      double cpMult = cpMultiplier[(int) level];
      int newCP;
      
      this.hP = staminaPower;
      newCP = (int) ((attackPower * Math.pow(defensePower, 0.5) 
         * Math.pow(staminaPower, 0.5) * Math.pow(cpMult, 2)) / 10.0);
      //only ever increase CP
      if (newCP > this.cP) {
         this.cP = newCP;
      }
      //CP must be at least 10
      if (this.cP < 10) {
         this.cP = 10;
      }
   }
   
   /*** public class methods ***/
   /**
   * Increases Pokemon's level by 1.
   * Adjusts HP and CP accordingly.
   */
   public void levelUp() {
      //cpMultiplier array has 0-39 indices
      if (level < 39) {
         level++;
      }
      calculateHPAndCP();
   }
   
   /**
   * Returns Pokemon information as a formatted String.
   * @return String representing Pokemon object data.
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("000");
      String s = "";
      
      s = "Species: " + species + "\n";
      if (species.compareTo(name) != 0) {
         s = s + "Name: " + name + "\n";
      }
      s = s + "Number: " +  df.format(number) + "\n";
      s = s + "Height: " + height + "\n";
      s = s + "Weight: " + weight + "\n";
      s = s + "Type: " + type1;
      if (this.type2.length() > 0) {
         s = s + " | " + this.type2;
      }
      s = s + "\n";
      s = s + "HP: " + hP + "\n";
      s = s + "CP: " + cP;
      
      return s;
   }
   
  /**
  * Sets Pokemon's user-defined name.
  * @param newName The new name.
  * @throws PokemonException if name is blank.
  */
   public void setName(String newName) throws PokemonException {
      if (newName.equals("")) {
         throw new PokemonException("Name cannot be blank!");
      } else {
         this.name = newName;     
      }
   }
   
  /*** abstract methods required for sub-classes ***/
   /**
   * Retrieves victim Pokemon's type.
   * Determines if the attack is super effective or not effective
   * Performs beAttacked on victim
   * @param victim The Pokemon object being attacked.
   * @return String "<species> performed <fastAttack> 
   * + <it <was super, wasn't very, was not> effective>" depending on type
   */
   public abstract String performFastAttack(Pokemon victim);
   
   /**
   * Retrieves victim Pokemon's type.
   * Determines if the attack is super effective or not effective
   * Calculates amount of HP to knock off victim
   * Performs beAttacked on victim
   * @param victim The Pokemon object being attacked.
   * @return String "<species> performed <specialAttack> 
   * + <it <was super, wasn't very, was not> effective>" depending on type
   */
   public abstract String performSpecialAttack(Pokemon victim);
   
      
   /*** protected abstract methods, for use only within subclasses ***/
   /**
    * Reduces Pokemon's HP due to attack.
    * @param hit Points to reduce HP
    */
   protected abstract void beAttacked(int hit);
  
   /**
   * Use type interface list to set Fast Attack.
   */
   protected abstract void chooseFastAttack();
   /**
   * Use type interface list to set Special Attack.
   */
   protected abstract void chooseSpecialAttack();
  
   
   /** Get Methods **/
   
   /** 
   * Gets the species.
   * @return species The species string.
   */
   public String getSpecies() {
      return species;
   }
   
   /**
   * Gets the user defined name.
   * @return name The user-defined name, if set.
   */
   public String getName() {
      return name;
   }
   /**
   * Gets the type-dependent color.
   * @return color The Pokemon's color.
   */
   public String getColor() {
      return color;
   }
   /** 
   * Gets the height.
   * @return height The Pokemon's height.
   */   
   public double getHeight() {
      return height;
   }
   /**
   * Gets the weight.
   * @return weight The Pokemon's weight.
   */ 
   public double getWeight() {
      return weight;
   }
   /**
   * Gets the number from Pokedex.
   * @return number This species' Pokedex number.
   */   
   public int getNumber() {
      return number;
   }
   /**
   * Gets the primary type.
   * @return String representing this species' primary type.
   */   
   public String getType1() {
      return type1;
   }
   /** 
   * Gets the secondary type.
   * @return String representing this  species' secondary type.
   * empty String if no secondary type
   */   
   public String getType2() {
      return type2;
   }
   /**
   * Gets the Hit Power.
   * @return int This Pokemon's Hit Power.
   */   
   public int getHP() {
      return hP;
   }
   /**
   * Gets the Combat Power.
   * @return int This Pokemon's Combat Power
   */   
   public int getCP() {
      return cP;        
   }
   /**
   * Gets the fast/simple attack name.
   * @return String The name of the Fast Attack.
   */   
   public String getFastAttack() {
      return fastAttack;
   }   
   /**
   * Gets the Special attack name.
   * @return String The name of the Special Attack.
   */  
   public String getSpecialAttack() {
      return specialAttack;
   }
      
   /**
   * Checks if Pokemon are equivalent.
   * @param that Pokemon to compare.
   * @return boolean true if equal.
   */  
   
   public boolean equals(Pokemon that) {
      return (this.number == that.number);
   }
   
   /**
   * Compares Pokemon.
   * @param that Pokemon to compare.
   * @return int 0 if equal, 1 if greater, -1 if lesser.
   */
   
   public int compareTo(Pokemon that) {
      if (this.equals(that)) {
         return 0;
      } else if (this.number > that.getNumber()) {
         return 1;
      } else {
         return -1;
      } 
   }
}
