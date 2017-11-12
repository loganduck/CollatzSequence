import java.util.ArrayList;
import java.util.List;

/**
 * Rules: 
 * 1) n --> n/2 (when n is even)
 * 2) n --> 3n + 1 (when n is odd)
 * 
 * Using the rule above and starting with 13, for example, we
 * generate the following sequence:
 * 13 --> 40 --> 20 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1
 * 
 * It can be seen that sequence contains 10 terms. The objective is to
 * determine if all numbers you start with end at 1.
 * 
 * Question: Which starting number, under 1 million, produces the
 * longest chain?
 * Note: Once the chain starts the terms are allowed to go over
 * 1 million.
 * 
 * @author LoganDuck
 * @version 11/11/17
 */
public class CollatzSequence {
   static long value = 0;
   static final int MAX_VALUE = 1000000;
   static List<String> collatzList = new ArrayList<>();
   static String collatzSequence = "";
   static final List<String> EMPTY = new ArrayList<>();
	
   public CollatzSequence() {
      collatzList = new ArrayList<>();
   }

   public CollatzSequence(long valueIn) {
      value = valueIn;
      collatzList = new ArrayList<>();
   }
   
	/**
	 * Performs the rules and adds the current number on to
	 * a list.
	 * 
	 * Example List: [13, 40, 20, 10, 5, 16, 8, 4, 2, 1]
	 * 
	 * @param valueIn - beginning value being calculated
	 * @return - list generated (example list)
	 */
   public List<String> asList(long valueIn) {
      if (valueIn >= MAX_VALUE) {
         error();
      }
      collatzList.add(Long.toString(valueIn));
      while (valueIn > 1) {
          if (valueIn % 2 == 0) {
             valueIn = valueIn / 2;
             collatzList.add(Long.toString(valueIn));
          } else {
             valueIn = (3 * valueIn) + 1;
             collatzList.add(Long.toString(valueIn));
          }
      }
      return collatzList;
   }
	
   /**
    * @return - number of values inside the list. 
    */
   public int size() {
      return collatzList.size();
   }
	
   public void error() {
      System.out.println("Your value is too large, please try again");
      System.exit(1);
   }

   /**
    * Turns the list into a sequence.
    * 
    * Example Sequence: 13 --> 40 --> 20 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1
    * 
    * @param sequenceIn - starting sequence
    * @return - sequence being generated (example sequence)
    */
   public String getCollatzSequence(List<String> sequenceIn) {
      collatzSequence = "";
      for (int i = 0; i < sequenceIn.size() / 2; i++) {
         if (i == (sequenceIn.size() / 2) - 1) {
            collatzSequence += sequenceIn.get(i);
         } else {
            collatzSequence += sequenceIn.get(i) + " -> ";
         }
      }
      return collatzSequence;
   }
}