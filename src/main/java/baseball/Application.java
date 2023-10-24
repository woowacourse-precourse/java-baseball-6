package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
    	

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        
        System.out.println(computer);   
        
        
        int strike = 0;
        int ball = 0;
        
        int firstNumber = computer.get(0);
        int secondNumber = computer.get(1);
        int thirdNumber = computer.get(2);
        
        char first = Integer.toString(firstNumber).charAt(0);
        char second = Integer.toString(secondNumber).charAt(0);
        char third = Integer.toString(thirdNumber).charAt(0);     
        
        
        while(strike != 3) {
        	String myNumber = Console.readLine();        	
        	
        	if (first == myNumber.charAt(0)) {
        		strike++;
        	}    
        	
        	if (second == myNumber.charAt(1)) {
        		strike++;
        	}  
        	
        	if (third == myNumber.charAt(2)) {
        		strike++;
        	}  
        	
        	if (first == myNumber.charAt(1)) {
        		ball++;
        	}    
        	
        	if (first == myNumber.charAt(2)) {
        		ball++;
        	}    
        	
        	if (second == myNumber.charAt(0)) {
        		ball++;
        	}    
        	
        	if (second == myNumber.charAt(2)) {
        		ball++;
        	}    
        	
        	if (third == myNumber.charAt(0)) {
        		ball++;
        	}    
        	
        	if (third == myNumber.charAt(1)) {
        		ball++;
        	}    
        	
        	System.out.println(strike);
        	System.out.println(ball);
        	
        }    
        
    }
}
