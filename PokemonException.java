/**
 * An Exception for use with the Pokemon class.
 * Error message for when entered name is blank
 * @author Tom Herman
 * @since 11/05/18
 */
 
public class PokemonException extends RuntimeException {
   /**
    * Constructor.
    * 
    * @param message Describes the cause of the error
    */
   public PokemonException(String message) {
      super(message);
   }
}