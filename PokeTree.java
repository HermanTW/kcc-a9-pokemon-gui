/**
  * PokeTree class implementing binary search tree for Pokemon class.
  *
  * @author Tom Herman.
  * @param <Pokemon> Datatype used in tree.
  */
public class PokeTree<Pokemon extends java.lang.Comparable<Pokemon>> {
   
   private PokeNode<Pokemon> root = null;   