package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class BaseballGame {
	private String answer;
	private String userInput;
	private String newGameCommand;
	private int strike;
	private int ball;
	private boolean[] usedAnsNumChecker;
	private boolean[] usedInputNumChecker;
	private final String NEWGAME = "1";
	private final String EXITGAME = "2";
	
	BaseballGame() {
		initGame();
	}

	private void initGame() {
		answer = Integer.toString(100 * Randoms.pickNumberInRange(1, 10)
				 + 10 * Randoms.pickNumberInRange(1, 10) + Randoms.pickNumberInRange(1, 10));
		usedAnsNumChecker = new boolean[3];
		usedInputNumChecker = new boolean[3];
	}
	
	private void printStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
	
	private void initBallcount(){
		strike = 0;
		ball = 0;
	}
	
	private void getInput() throws IllegalArgumentException {
		System.out.print("숫자를 입력해주세요 : ");
		userInput = Console.readLine();
		if (userInput.length() != 3) throw new IllegalArgumentException();
	}
	
	private void initChecker() {
		usedAnsNumChecker[0] = usedAnsNumChecker[1] = usedAnsNumChecker[2] = false;
		usedInputNumChecker[0] = usedInputNumChecker[1] = usedInputNumChecker[2] = false;
	}
	
	private void countStrikes() {
		for (int i = 0; i < 3; i++) {
			if (userInput.charAt(i) == answer.charAt(i)) {
				strike++;
				usedAnsNumChecker[i] = usedInputNumChecker[i] = true;
			}
		}
	}
	
	private void countBalls() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j || usedAnsNumChecker[i] == true || usedInputNumChecker[j] == true)
					continue;
				if (userInput.charAt(j) == answer.charAt(i)) {
					ball++;
					usedAnsNumChecker[i] = usedInputNumChecker[j] = true;
				}
			}
		}
	}
	
	private void printResult() {
		if (ball > 0) System.out.print(ball + "볼 ");
		if (strike > 0) System.out.print(strike + "스트라이크");
		if (strike == 0 && ball == 0) System.out.print("낫싱");
		System.out.println();
	}
	
	private void printSuccess() {
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
	
	public void playGame() throws IllegalArgumentException {
		printStart();
		
		while(true) {
			initBallcount();
			getInput();
			
			if (userInput.equals(answer)) {
				printSuccess();
				
				newGameCommand = Console.readLine();
				if (newGameCommand.equals(NEWGAME)) initGame();
				else if (newGameCommand.equals(EXITGAME)) break;
				else throw new IllegalArgumentException();
			}
			else {
				initChecker();
				countStrikes();
				countBalls();
				printResult();
			}
		}	
	}
}

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.playGame();
    }
}