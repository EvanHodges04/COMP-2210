
/**
 * Provides a factory method for creating word search games. 
 *
 * @author Evan Hodges (ejh0058@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 10/29/2023
 */
public class WordSearchGameFactory {

   /**
    * Returns an instance of a class that implements the WordSearchGame
    * interface.
    */
   public static WordSearchGame createGame() {
      return new HodgesWordSearchTrie();
   }

}
