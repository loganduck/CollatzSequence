import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class CollatzSequenceClient {
   static final int MIN = 1;
   static final int MAX = 1000000;
   static Random r = new Random();
   static long value;
   private static Scanner scan;

   public static void main(String[] args) {
	   scan = new Scanner(System.in);
	   CollatzSequence example = new CollatzSequence();
	   
	   //1
	   example = new CollatzSequence();
	   System.out.println("Sequenced: " + example.getCollatzSequence(example.asList(13)));
	   System.out.println("Size: " + example.size() + "\n");
	
	   //2
	   example = new CollatzSequence();
	   int randomNum = r.nextInt((MAX - MIN) + 1) + MIN;
	   System.out.println("The random number is " + randomNum
			   + "\n\nSequenced: " + example.getCollatzSequence(example.asList(randomNum))
			   + "\n\nSize: " + example.size() + "\n");
	   
	   //3
	   example = new CollatzSequence(value);
	   System.out.print("Please enter a number: ");
	   try {
		   value = scan.nextLong();
	   } catch (InputMismatchException e) {
		   System.out.println("Invalid Input. Please run again.");
	   }
	   System.out.println("Sequenced: " + example.getCollatzSequence(example.asList(value)));
	   System.out.println("Size: " + example.size() + "\n");
	   
	   //output time
	   long startTime = System.nanoTime();
	   long endTime = System.nanoTime();
	   System.out.println("Took "+(endTime - startTime) + " ns");
   }
}