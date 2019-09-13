 /**
   * Binary search tree class for Pokemon.
   * 
   * @author Tom Herman
   *  (with influence of Lisa Miller and William McDaniel Albritton)
   */
public class PokeTree {
   /** Root node instance variable.*/
   private PokeNode root = null;
   
   /** No parameter constructor.*/
   public PokeTree() {
      /*root already initialized*/
   }
   
 /**
   * Adds Pokemon to tree.
   * Non-recursive wrapper method
   *
   * @param poke Pokemon to be added to tree
   */
   public void add(Pokemon poke) {
      // calls recursive, private method to access root
      root = add(root, poke);
   }

 /**
   * Recursively adds a Pokemon to the tree.
   *
   * @param node The root of the tree/subtree
   * @param poke The Pokemon to be added
   * @return The current node
   */
   private PokeNode add(PokeNode node, Pokemon poke) {
   // base case: empty tree/end of a leaf
      if (node == null) {
         return new PokeNode(poke, 1, null, null);
      }
      else if (poke.compareTo(node.getPokemon()) == 0) {
         node.increaseNumCaught();
         return node;
      }
   // recursive case: if item is less than current node,
   //    then move to left child node
      else if (poke.compareTo(node.getPokemon()) < 0) {
      // set node's left child to left subtree with Pokemon added
         node.setLChild(this.add(node.getLChild(), poke));
         return node;
      }
   // recursive case: if item is greater than current node,
   //    then move to right child node
      else {
      // set node's right child to the right subtree with Pokemon added
         node.setRChild(this.add(node.getRChild(), poke));
         return node;
      }
   }

 /**
   * Prints in order display of nodes with new line between each node.
   *
   * calls printout in order of the Tree from private method
   * @return String
   */
   public String printPokeTree() {
      if (root == null) {
         return("Pokedex is empty.  Find Professor Oak!"); 
      } else {
         return printPokeTree(root);
      }
   }
   
/**
   * Prints in order display of nodes with new line between each node.
   *
   * @param node from which to print out tree
   * @return
   */
   private String printPokeTree(PokeNode node) {
      String output = "";
      if (node != null) {
         output += printPokeTree(node.getLChild());
         output += node.toString() + "\n\n";
         output += printPokeTree(node.getLChild());
      }
      return output;
   }
   
 /**
   * Pre order traversal of tree.
	* 
   * Public wrapper method which calls private recursor method
	*/
   public void preorderPokeTree() {
	   this.preorderPokeTree(root);
	}

 /**
	* Recursive preOrder traversal printout of tree.
	* 
	* @param node The root of the tree/subtree
	*/
	private void preorderPokeTree(PokeNode node) {
      if (node != null) {
         System.out.print("  " + node.getPokemon().toString());
         System.out.println("\nCaught: " + node.getNumCaught());
         preorderPokeTree(node.getLChild());
         preorderPokeTree(root.getRChild());
      }
   }
   
 /**
   * Gets a Pokemon from the tree with the same search key.
   * 
   * @param searchKey1 An object containing the search key
   * @return the Pokemon in the tree with matching key.
   */
   public Pokemon get(Pokemon searchKey1) {
   // cannot get direct access to the root outside the class
      return this.get(root, searchKey1);
   }

 /**
   * Recursive method to get a Pokemon from the tree.
   * 
   * @param node The root of the tree/subtree
   * @param searchKey2 An object storing the key to get.
   * @return the Pokemon in tree with matching key.
   * @throws PokeTreeException if item not found
   */
   private Pokemon get(PokeNode node, Pokemon searchKey2) 
      throws PokeTreeException {
   // if not found, throw exception
      if (node == null) {
         throw new PokeTreeException("Pokemon not found!");
      } 
      else {
      // if the search key matches, return the item's address
         if (searchKey2.compareTo(node.getPokemon()) == 0) {
            return node.getPokemon();
         }
      // if the search key of the searchKey is less than the node,
      // then search the left subtree
         else if (searchKey2.compareTo(node.getPokemon()) < 0) {
            return this.get(node.getLChild(), searchKey2);
         }
      // if the search key of the searchKey is greater than the node,
      // then search the right subtree
         else {
            return this.get(node.getRChild(), searchKey2);
         }
      }
   }

  /**
   * Removes a Pokemon from the tree.
   * 
   * @param searchKey3 An object storing the key to remove.
   */
   public void remove(Pokemon searchKey3) {
      root = this.remove(root, searchKey3);
   }

 /**
   * Recursively removes a Pokemon from the tree.   
   * 
   * @param node The root of the tree/subtree
   * @param searchKey4 An object storing only the key to remove.
   * @return root of current subtree.
   * @throws PokeTreeException if Pokemon not found in tree.
   */
   private PokeNode remove(PokeNode node, Pokemon searchKey4) 
      throws PokeTreeException {
   // if Pokemon not found, throw exception
      if (node == null) {
         throw new PokeTreeException("Item not found!");
      }
   // if search key is less than node's search key,
   // continue to left subtree
      else if (searchKey4.compareTo(node.getPokemon()) < 0) {
         node.setLChild(this.remove(node.getLChild(), searchKey4));
         return node;
      }
   // if search key is greater than node's search key,
   // continue to right subtree
      else if (searchKey4.compareTo(node.getPokemon()) > 0) {
         node.setRChild(this.remove(node.getRChild(), searchKey4));
         return node;
      }
   // found node containing Pokemon with same search key,
   // so delete it
      else {
      // call private method remove
         if (node.getNumCaught() > 1) {
            node.decreaseNumCaught();
         } else {
            node = this.remove(node);
         }
         return node;
      }
   }

 /**
   * Helper method that takes a node out of tree.
   * 
   * @param node The node to remove
   * @return The node that replaces removed node or null.
   */
   private PokeNode remove(PokeNode node) {
   // if node is a leaf, return null
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
   // if node has a single right child node,
   // then return a reference to the right child node
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
   // if node has a single left child node,
   // then return a reference to the left child node
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
   // if the node has two child nodes
      else {
      // get next Smaller Pokemon, which is Largest Pokemon in Left Subtree
      // The next Smaller Pokemon is stored at the rightmost node in the left
      // subtree.
         PokeNode largestItemInLeftSubtree = 
             this.getNodeWithLargestSearchKey(node.getLChild());
      // replace the node's Pokemon with this item
         PokeNode lTemp = node.getLChild();
         PokeNode rTemp = node.getRChild();
         node = new PokeNode(largestItemInLeftSubtree.getPokemon(),
            largestItemInLeftSubtree.getNumCaught(), lTemp, rTemp);    
      // delete the rightmost node in the left subtree
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   }

  /**
   * Returns the Pokemon with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param node The root of the tree/subtree
   * @return The Pokemon with largest key
   */
   private PokeNode getNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest Pokemon
      if (node.getRChild() == null) {
         return node;
      }
   // if not, keep looking on the right
      else {
         return this.getNodeWithLargestSearchKey(node.getRChild());
      }
   }

  /**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by Pokemon with largest search key.
   * To be called after Pokemon is moved to new node location.
   * 
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest Pokemon
   // so replace it with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
   // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   }
} 