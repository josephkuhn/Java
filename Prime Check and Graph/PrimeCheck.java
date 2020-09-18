import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class PrimeCheck extends Application {
    @Override
    public void start(Stage stage) 
    {
    		System.out.println("This program will show the user all of the prime factors that make up the numbers from 2 up until (and including) the number entered.");
    		System.out.println("For example, entering the number 5 will give the primes that make up 2, 3, 4, and 5.");
    		System.out.println("Please enter a positive integer between 2 and 30, inclusive.");
    		Scanner input = new Scanner(System.in);
    		int n = input.nextInt();
    		List primes = primeFactors(n);
    		Hashtable numPrimes = findPrimes(primes);
    		int distinctPrimes = findDistinct(numPrimes);
    		int primeArray[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    		Set<Integer> distinct = new HashSet<Integer>();
    		for (int i = 0; i < numPrimes.size(); i++)
    		{
    			if ((Integer)(numPrimes.get(primeArray[i])) > 0)
    			{
    				distinct.add(primeArray[i]);
    			}
    		}
    		    		
    		double width = 120 * distinctPrimes;
	    	double height = 300;
	   
	    Color[] colors = new Color[5];
	    Color colorOne = Color.RED;
	    Color colorTwo = Color.BLUE;
	    Color colorThree = Color.GREEN;
	    Color colorFour = Color.ORANGE;
	    Color colorFive = Color.PURPLE;
	    
	    colors[0] = colorOne;
	    colors[1] = colorTwo;
	    colors[2] = colorThree;
	    colors[3] = colorFour;
	    colors[4] = colorFive;
	    
	    String[] possPrimes = new String[10];
		possPrimes[0] = "Instances of 2: ";
		possPrimes[1] = "Instances of 3: ";
		possPrimes[2] = "Instances of 5: ";
		possPrimes[3] = "Instances of 7: ";
		possPrimes[4] = "Instances of 11: ";
		possPrimes[5] = "Instances of 13: ";
		possPrimes[6] = "Instances of 17: ";
		possPrimes[7] = "Instances of 19: ";
		possPrimes[8] = "Instances of 23: ";
		possPrimes[9] = "Instances of 29: ";
	    
	    Pane pane = new Pane();
	    pane.setPadding(new Insets(5, 10, 0, 10));
	    Rectangle[] barGraph = new Rectangle[distinctPrimes];
	    	    
	    for (int i = 0; i < distinctPrimes; i++)
	    {
	    		int amount = primeArray[i];
	    		barGraph[i] = new Rectangle(5 + (i * 115), height - (Integer) numPrimes.get(amount) * 10 - 5, 100, (Integer) numPrimes.get(amount) * 10);
	    		if (i > 4)
	    		{
	    			barGraph[i].setFill(colors[i-5]);
	    		}
	    		else{
	    			barGraph[i].setFill(colors[i]);
	    		}
	    		possPrimes[i] += (Integer) numPrimes.get(amount);
	    		Text text = new Text(5 + (i * 115), height - (Integer) numPrimes.get(amount) * 10 - 10, possPrimes[i]);
	    		pane.getChildren().addAll(text, barGraph[i]);
	    }

	    stage.setScene(new Scene(pane, width + 20, height));
	    stage.setTitle("Bar Chart of Prime Numbers");
	    stage.show();
    }
    
   public static List primeFactors(int n){
      List primes = new ArrayList();
      for (int x = 2; x <= n; x++)
      {
    	  	int y = x;
	    for (int i = 2; i <= y; i++) 
	    {
	    		while(y % i == 0 && y >= 2) 
	    		{
	    			primes.add(i);
	    	  		y = y / i;
	        }
	    }
      }
      return primes;
   }
    
    public static Hashtable findPrimes(List primes) {
    		Hashtable<Integer, Integer> numPrimes = new Hashtable<Integer, Integer>();
    		numPrimes.put(2, 0);
    		numPrimes.put(3, 0);
    		numPrimes.put(5, 0);
    		numPrimes.put(7, 0);
    		numPrimes.put(11, 0);
    		numPrimes.put(13, 0);
    		numPrimes.put(17, 0);
    		numPrimes.put(19, 0);
    		numPrimes.put(23, 0);
    		numPrimes.put(29, 0);
    		    		
    		for (int i = 0; i < primes.size(); i++)
    		{
    			if ((Integer)(primes.get(i)) == 2)
    			{
    				numPrimes.put(2, (Integer)(numPrimes.get(2)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 3)
    			{
    				numPrimes.put(3, (Integer)(numPrimes.get(3)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 5)
    			{
    				numPrimes.put(5, (Integer)(numPrimes.get(5)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 7)
    			{
    				numPrimes.put(7, (Integer)(numPrimes.get(7)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 11)
    			{
    				numPrimes.put(11, (Integer)(numPrimes.get(11)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 13)
    			{
    				numPrimes.put(13, (Integer)(numPrimes.get(13)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 17)
    			{
    				numPrimes.put(17, (Integer)(numPrimes.get(17)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 19)
    			{
    				numPrimes.put(19, (Integer)(numPrimes.get(19)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 23)
    			{
    				numPrimes.put(23, (Integer)(numPrimes.get(23)) + 1);
    			}
    			else if ((Integer)(primes.get(i)) == 29)
    			{
    				numPrimes.put(29, (Integer)(numPrimes.get(29)) + 1);
    			}
    		}
    		return numPrimes;
    }
    
    public static int findDistinct(Hashtable numPrimes)
    {
    		int distinctPrimes = 0;
    		int primeArray[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    		
    		for (int i = 0; i < numPrimes.size(); i++)
    		{
    			if ((Integer)(numPrimes.get(primeArray[i])) > 0)
    			{
    				distinctPrimes++;
    			}
    		}
    		return distinctPrimes;
    }

    public static void main(String[] args) {
    		Application.launch(args);
    }
}
