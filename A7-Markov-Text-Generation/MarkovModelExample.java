/**
 * Demonstrates a fully fledged Markov model output.
 *
 * @author Evan Hodges (ejh0058@auburn.edu)
 * @version 11/26/2023
 */
public class MarkovModelExample {
   /**
    * Uses command line arguments.
    */
   public static void main(String[] args) {
      String[] arguments = new String[3];
      arguments[0] = "5"; // key length
      arguments[1] = "1000"; // output length
      arguments[2] = "input_files/dickens.excerpt.txt"; // source material
      TextGenerator.main(arguments);
   }
}