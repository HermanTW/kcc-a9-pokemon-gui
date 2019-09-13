/**
  * An exception class for use with class PokeTree.
  *
  * @author Tom Herman
  */
  
public class PokeTreeException extends RuntimeException {
   /** 
     * @param message details cause of error
     */
   public PokeTreeException(String message) {
      super(message);
   }
}   