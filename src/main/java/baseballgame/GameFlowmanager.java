package baseballgame;

import java.util.*;

import Validation.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameFlowmanager {
	
	private BaseballNumberset generator;
    private BaseballResultCalculator calculator;
    private UserInputValidator validator;
    boolean continuePlaying=true;

    public GameFlowmanager() {
        this.generator = new BaseballNumberset();
        this.calculator = new BaseballResultCalculator();
        this.validator = new UserInputValidator();
        this.continuePlaying = true;
        
    }
    
   
    
    private List<Integer> getInputFromUser(){
    	System.out.print("숫자를 입력해주세요 : ");
		String input=Console.readLine();
		
		List<Integer> guesses=new ArrayList<>();
		
		validator.validateUserInput(input);
		

		for(char c:input.toCharArray()){
			guesses.add(Character.getNumericValue(c));
		}
		
		return guesses;
		
    }
    
    private void printResult() {
    	if(calculator.getStrike() == 3) {
    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    	}
    }
    
    private void printResultAndCheckContinue() {
    	if(calculator.getStrike() == 3){
			System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			
			int choice=Integer.parseInt(Console.readLine());
			validator.validateGameChoice(choice);
			if(choice==1){
				generator.generateComputerNumbers();
				continuePlaying=true;
			}else{
				
				continuePlaying=false;
				System.out.println("게임 종료");
			}
			
		}
    }
    
    
    
    public void run() {
    	
		
		System.out.println("숫자 야구 게임을 시작합니다.");
		
		while(continuePlaying) {
			List<Integer> guesses =  getInputFromUser();
			
			String result = calculator.calculateBallAndStrike(guesses, generator.getNumbers());
			System.out.println(result);
			printResult();
			printResultAndCheckContinue();
			
			
    }
    

   


    
}
}
