package tree;

import java.util.Arrays;
import java.util.Scanner;

public class prime {
	 static int sumOfPrimes(int num2) 
	    { 
	        boolean prime[]=new boolean[num2 + 1]; 
	        Arrays.fill(prime, true); 
	        for (int p = 2; p * p <= num2; p++) { 
	            if (prime[p] == true) { 
	                for (int i = p * 2; i <= num2; i += p) 
	                    prime[i] = false; 
	            } 
	        } 
	        int sum = 0; 
	        for (int i = 2; i <= num2; i++) 
	            if (prime[i]) 
	                sum += i; 
	        return sum; 
	    } 
	   
	   // Driver code 
	    public static void main(String args[]) {
	    { 
	    	Scanner o=new Scanner(System.in);
	    int testcase=o.nextInt();
	        int num2=o.nextInt();
	        int ans=sumOfPrimes(num2); 
	        System.out.println(ans);
	    } 
	} 
}
