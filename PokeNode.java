 /**
   * PokeNode class.
   *
   * @author Tom Herman
   */
public class PokeNode {
   /** Nodes hold Pokemon Datatype.*/
   private Pokemon data;
   /** Number of Pokemon held.*/
   private int numCaught = 1;
   /** Left child of node.*/
   private PokeNode lChild;
   /** Right child of node.*/
   private PokeNode rChild;
   
 /**
   * Node constructor.
   *
   * @param poke Pokemon stored by node
   * @param num how many Pokemon held
   * @param l Address of left child
   * @param r Address of right child
   */
   public PokeNode(Pokemon poke, int num, PokeNode l, 
       PokeNode r) {
      data = poke;
      numCaught = num; 
      lChild = l;
      rChild = r;
   }
   
 /**
   * Method for outputting Node data.
   *
   * @return String containing Node data
   */
   public String toString() {
      String output = data.toString();
      return output;
   }
   
 /**
   * Get method.
   *
   * @return data within node
   */
   public Pokemon getPokemon() {
      return data;
   }

/**
   * Set method.
   *
   * @param p Pokemon to override current node data
   */
   private void setPokemon(Pokemon p) {
      this.data = p;      
   }
   
 /**
   * Get method.
   *
   * @return Pokemon number
   */
   public int getKey() {
      Pokemon temp = this.getPokemon();
      int key = temp.getNumber();
      return key;
   }
 /**
   * Get method.
   *
   * @return number of Pokemon caught
   */
   public int getNumCaught() {
      return numCaught;
   }
   
 /**
   * Modifier method.
   *
   * Adds one to numCaught
   */
   public void increaseNumCaught() {
      numCaught++;
   }

 /**
   * Modifier method.
   * Subtracts one from numCaught
   *
   * @throws PokemonException Error if trying to make numCaught < 0
   */
   public void decreaseNumCaught() throws PokemonException {
      if (numCaught < 1) {
         throw new PokemonException("Not enough of this Pokemon to trade!");
      } else {
         numCaught--;
      }
   }

 /**
   * Accessor method.
   * 
   * @return address of left child
   */
   public PokeNode getLChild() {
      return lChild;
   }
   
 /**
   * Mutator method.
   *
   * @param l address of left child
   */
   public void setLChild(PokeNode l) {
      lChild = l;
   }
 
 /**
   * Accessor method.
   * 
   * @return address of right child
   */
   public PokeNode getRChild() {
      return rChild;
   }
   
 /**
   * Mutator method.
   *
   * @param r address of right child
   */
   public void setRChild(PokeNode r) {
      rChild = r;
   }
}