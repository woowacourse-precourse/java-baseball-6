package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class PrintMessage{
	public void printStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
	
	public void printResult(int ball, int strike) {
		if (ball > 0) System.out.print(ball + "볼 ");
		if (strike > 0) System.out.print(strike + "스트라이크");
		if (strike == 0 && ball == 0) System.out.print("낫싱");
		System.out.println();
	}
	
	public void printSuccess() {
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}

class Ballcount{
	private int strike;
	private int ball;
	private boolean[] usedAnsNumChecker;
	private boolean[] usedInputNumChecker;
	
	Ballcount(){
		initCount();
		usedAnsNumChecker = new boolean[3];
		usedInputNumChecker = new boolean[3];
	}
	
	public void initCount() {
		strike = 0;
		ball = 0;
	}
	
	public void initChecker() {
		usedAnsNumChecker[0] = false;
		usedAnsNumChecker[1] = false;
		usedAnsNumChecker[2] = false;
		usedInputNumChecker[0] = false;
		usedInputNumChecker[1] = false;
		usedInputNumChecker[2] = false;
	}
	
	private void calculateStrikes(int index, String answer, String userInput) {
		if (answer.charAt(index) == userInput.charAt(index)) {
			strike++;
			usedAnsNumChecker[index] = true;
			usedInputNumChecker[index] = true;
		}
	}
	
	public int countStrikes(String answer, String userInput) {
		for (int i = 0; i < 3; i++) {
			calculateStrikes(i, answer, userInput);
		}
		
		return strike;
	}
	
	private void calculateBalls(int index, String answer, String userInput) {
		for (int i = 0; i < 3; i++) {
			if (i == index || usedAnsNumChecker[index] == true || usedInputNumChecker[i] == true) {
				continue;
			}
			if (answer.charAt(index) == userInput.charAt(i)) {
				usedAnsNumChecker[index] = true;
				usedInputNumChecker[i] = true;
				ball++;
			}
		}
	}
	
	public int countBalls(String answer, String userInput) {
		for (int i = 0; i < 3; i++) {
			calculateBalls(i, answer, userInput);
		}
		
		return ball;
	}
}

class BaseballGame {
	private static final String NEWGAME = "1";
	private static final String EXITGAME = "2";
	private static final int START = 1;
	private static final int EXIT = 2;
	
	private String answer;
	private String userInput;
	
	BaseballGame() {
		initGame();
	}

	private void initGame() {
		answer = Integer.toString(100 * Randoms.pickNumberInRange(1, 9)
				 + 10 * Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9));
	}
	
	private void getInput() throws IllegalArgumentException {
		System.out.print("숫자를 입력해주세요 : ");
		userInput = Console.readLine();
		if (userInput.length() != 3 || userInput.contains("0")) {
			throw new IllegalArgumentException();
		}
	}
	
	private int success() throws IllegalArgumentException {
		if (userInput.equals(answer)) {
			PrintMessage printer = new PrintMessage();
			printer.printSuccess();
			
			String newGameCommand = Console.readLine();
			if (newGameCommand.equals(NEWGAME)) return 1;
			else if (newGameCommand.equals(EXITGAME)) return 2;
			throw new IllegalArgumentException();
		}
		
		return 0;
	}
	
	public void playGame() throws IllegalArgumentException {
		PrintMessage printer = new PrintMessage();
		Ballcount count = new Ballcount();
		
		printer.printStart();
		
		while(true) {
			count.initCount();
			getInput();
			
			int startNewGame = success();
			if (startNewGame == START) {
				initGame();
				continue;
			}
			else if (startNewGame == EXIT) {
				break;
			}
			
			count.initChecker();
			int strike = count.countStrikes(answer, userInput);
			int ball = count.countBalls(answer, userInput);
			printer.printResult(ball, strike);
		}	
	}
}

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.playGame();
    }
}