package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class IllegalArgumentException extends Exception {
	public IllegalArgumentException() {
		super();
	}
}
public class Application {
	private int ans [] = new int [3];
	private int userNumber[] = new int[3];
	private boolean isValid = true;
	private boolean result = false;
	
	public void gameStart() {
		makeAns();

	}
	
	public void makeAns() {
		int num[] = new int[3];
		while (true) {
			for (int i=0; i<3; i++) 
				num[i] = Randoms.pickNumberInRange(1, 9);
			if (num[0] != num[1] && num[1] != num[2] && num[0] != num[2]) {
				for (int i=0; i<3; i++) ans[i] = num[i]; 
				break;
			}
		}
	}
	
	public void validInput(String len) throws IllegalArgumentException{
		int num[] = new int [3];
		
		if (len.length() != 3) isValid = false;
		for (int i=0; i<len.length(); i++) {
			num[i] = len.charAt(i) - '0';
			if (num[i] <= 0 || num[i] > 9)isValid = false;
		}
		if (num[0] == num[1] || num[0] == num[2] || num[1] == num[2])
			isValid = false;
		if (isValid == false) throw new IllegalArgumentException();
		else 
			for (int i=0; i<3; i++)userNumber[i] = num[i];
	}
	
	public int countBall() {
		int ballNumber = 0;
		for (int i=0; i<3; i++) {
			for (int j=0;j<3; j++) {
				if (i == j) continue;
				if (ans[i] == userNumber[j])
					ballNumber++;
			}
		}
		return ballNumber;
	}
	
	public int countStrike() {
		int strikeNumber =0;
		for (int i=0; i<3; i++)
			if (ans[i] == userNumber[i]) strikeNumber++;
		return strikeNumber;
	}
	
	public void checkResult() {
		int ball = countBall();
		int strike = countStrike();
		printResult(ball, strike);
		
	}
	
	public void printResult(int ball, int strike) {
		if (ball == 0 && strike == 0){
			System.out.println("낫싱");
			return;
		}
		else if (strike == 3)
		{
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			result = true;
			return;
		}
		if (ball != 0) System.out.print(ball + "볼 ");
		if (strike != 0 ) System.out.print(strike + "스트라이크");
		System.out.println();
	}
	
	public void userGuess() throws IllegalArgumentException {
		while (!result) {
			System.out.print("숫자를 입력해주세요 : ");
			String len = Console.readLine();
			
			int num[] = new int [3];
			
			if (len.length() != 3) isValid = false;
			for (int i=0; i<len.length(); i++) {
				num[i] = len.charAt(i) - '0';
				if (num[i] <= 0 || num[i] > 9)isValid = false;
			}
			if (num[0] == num[1] || num[0] == num[2] || num[1] == num[2])
				isValid = false;
			if (isValid == false) throw new IllegalArgumentException();
			else 
				for (int i=0; i<3; i++)userNumber[i] = num[i];
			
			checkResult();
		}
	}
	
	public boolean isRestart() throws IllegalArgumentException{
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String userInput = Console.readLine();
		
		if (userInput.equals("1")) 
			return true;
		if (userInput.equals("2")) 
			return false;
		else 
			throw new IllegalArgumentException();
	}
	
    public static void main(String[] args) {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	while (true) {
    		try {
        		Application game = new Application();
        		game.gameStart();
        		while (!game.result) game.userGuess();
        		if (!game.isRestart()) break;
        	} catch(IllegalArgumentException e) {
        		break;
        	}
    	}
    }
}
