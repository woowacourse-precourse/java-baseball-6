package baseballgame;

import java.util.*;

import Validation.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameFlowManager {
	
	private BaseballNumberSet generator;
    private BaseballResultCalculator calculator;
    private UserInputValidator validator;
    private boolean continuePlaying=true;  //게임의  종료 / 시작 제어기

    public GameFlowManager() {
        this.generator = new BaseballNumberSet();
        this.calculator = new BaseballResultCalculator();
        this.validator = new UserInputValidator();
        this.continuePlaying = true;
        
    }
    
   
    // 사용자의 숫자 입력을 받는 메소드
    private List<Integer> getInputFromUser(){
    	System.out.print("숫자를 입력해주세요 : ");
		String input=Console.readLine();
		
		List<Integer> guesses=new ArrayList<>();
		
		validator.validate(input);
		

		for(char c:input.toCharArray()){
			guesses.add(Character.getNumericValue(c));
		}
		
		return guesses; //사용자의 숫자 입력을 반환
		
    }
    
    private void printResult() { // 3스트라이크 후 내용을 출력 메소드
    	if(calculator.getStrike() == 3) {
    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    	}
    }
    	// 게임 재시작 여부와 게임 재시작 활동에 대한 이벤트 처리
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
    
    
    // 실직적으로 게임을 시작하는 메소드
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
