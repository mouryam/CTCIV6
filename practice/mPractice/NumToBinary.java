package practice.mPractice;
import java.util.*;



public class NumToBinary{

	public static void main(String[] args){
	    long num;
	    try{
	    	num = Long.parseLong(args[0]);
	    }catch(NumberFormatException e){
	      throw new NumberFormatException("Please input a type int/long!");
	    }catch(ArrayIndexOutOfBoundsException ae){
	      throw new ArrayIndexOutOfBoundsException("Please input number!");
	    }
        StringBuilder result = new StringBuilder();

        if(num ==0){
        	System.out.println("0");
        }
	    while(num>0){
	    	result.append(num%2);
	    	num/=2;
	    }
	    System.out.println(result.reverse());
	}
}