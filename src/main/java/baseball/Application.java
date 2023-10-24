package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {	
    public static void main(String[] args) {
        
    	System.out.println("숫자 야구 게임을 시작합니다.");

    	try {
    		while(true) {
	    		// 랜덤 숫자 추출
	    		ComputerNum computerNum = new ComputerNum();
	    		computerNum.setNumber();
	    		List<Integer> answerList = computerNum.getNumber();
	    		
	    		while(true) {
	    			// 사용자 입력
	        		UserAnswer userAnswer = new UserAnswer();
	        		userAnswer.setUserAnswer();
	        		List<Integer> userList = userAnswer.getUserAnswer();
	        		
	        		// 게임 결과	        		
	        		BaseballGame baseballGame = new BaseballGame(userList, answerList);
	        		int strike = baseballGame.getStrike();
	        		int ball = baseballGame.getBall();
	        		
	        		// 게임 결과 출력
	        		if(printResult(ball, strike) == 0) break;
	        		
	    		}    		
	    		// 종료/재시작
	    		if(isExit() == 0) break;
    		}
    	}
    	catch(IllegalArgumentException e) {
    		// 오류
    		throw new IllegalArgumentException();
    	}
    }
    
    // 게임 결과 출력
 	public static int printResult(int ball, int strike) {
 		
 		if(strike == 3) {
 			System.out.println("3스트라이크");
 			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
 			return 0;
 		}
 	
 		if(ball != 0) {
 			System.out.print(ball + "볼 ");
 		}
 		
 		if(strike != 0) {
 			System.out.print(strike + "스트라이크");
 		}
 		
 		else if((ball + strike) == 0) {
 			System.out.print("낫싱");
 		}
 		
 		System.out.println();
 		return 1;
 	}
 	
 	// 게임 종료/재시작
 	public static int isExit() {
 		System.out.println("게임을 새로 시작하려면 1, 종료하면 2를 입력하세요.");
		String next = Console.readLine();
		
		if(next.equals("2")){
			return 0;
		}
		
		else if(!next.equals("1")) {
			throw new IllegalArgumentException();
		}
		
		return 1;
 	}
}
