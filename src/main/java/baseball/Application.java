package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	List<Integer> computer = computerNum();

    	while (true) {
    		List<Character> user = userAnswer();
    		invalidValue(user);
    		int[] result = checkNum(computer, user);
    		int strike = result[0], ball = result[1];
    		printResult(strike, ball, computer, user);
    		if (strike == user.size()) {
    			break;
    		}
    	}
    } // end of main
    
    static List<Integer> computerNum(){
    	List<Integer> computer = new ArrayList<>();
    	
    	while(computer.size() < 3) {
    		int randomNumber = Randoms.pickNumberInRange(1, 9);
    		
    		if(!computer.contains(randomNumber)) {
    			computer.add(randomNumber);
    		}
    	}
		return computer;
    } // end of computerNum()
    
    static List<Character> userAnswer(){
    	System.out.print("숫자를 입력해주세요 : ");
    	List<Character> user = new ArrayList<>();
    	
    	while(user.size() < 3) {
    		String userAnswer = Console.readLine();
    		user = addAnswerList(user, userAnswer);
    	} // end of while
		return user;
    } // end of userAnswer()
    
    static List<Character> addAnswerList(List<Character> user, String userAnswer){
    	for (int i=0; i<userAnswer.length(); i++) {
			if(!user.contains(userAnswer.charAt(i))) {
				char userNumChar = userAnswer.charAt(i);
				user.add(userNumChar);
			} // end of if
		} // end of for
		return user;
    } // end of addAnswerList()
    
    static int[] checkNum(List<Integer> computer, List<Character> user) {
    	int strike = 0, ball = 0;
    	
    	for (int i = 0; i < user.size(); i++) {
    		for (int j = 0; j < computer.size(); j++) {
    			if ((Character.getNumericValue(user.get(i))) == computer.get(j)) {
    				if (i == j) {strike++;}
    				if (!(i==j)) {ball++;}
    			}
			} // end of for j
    	} // end of for i
    	int[] result = {strike, ball};
		return result;
    } // end of checkNum()
  
    static void printResult(int strike, int ball, List<Integer> computer, List<Character> user) {
    	if (strike == user.size()) {
    		System.out.println(strike+"스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    		restart();
    		return;
    	} // end of if 게임 종료
    		if (strike>0 && ball >0) {
    			System.out.println(ball+"볼 "+strike+"스트라이크");
    		}
    		if (strike>0 && ball==0) {
    			System.out.println(strike+"스트라이크");
    		}
    		if (strike==0 && ball >0) {
    			System.out.println(ball+"볼");
    		}
    		if (!(strike>0 || ball>0)) {
    			System.out.println("낫싱");
    		}
    } // end of printResult()
    
    static void restart() {
    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    	String restart = Console.readLine();
    	
    	if (restart.equals("1")) {
    			main(null);
    	}
    	if (restart.equals("2")) {
    		return;
    	}
    } //end of restart()
    
    static void invalidValue(List<Character> user) throws IllegalArgumentException{
    	if(user.size() > 3) {
    		throw new IllegalArgumentException();
    	} // end of if
    } // end of invalidValue()
} // end of class