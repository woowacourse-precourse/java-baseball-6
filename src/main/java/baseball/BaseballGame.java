package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAMEOVER_MESSAGE = "게임 종료";
    private static final int EXIT_CODE = 2;
    private static final int ALL_STRIKE = 3;
    private static BaseballGame baseballGame = new BaseballGame();

    public static BaseballGame getInstance() {
        return baseballGame;
    }


    private GameNumber computerNumber;
    private GameNumber userInput;

    private int strike;
    private int ball;


    public int getStrike() {
        return strike;
    }

    public void randomizeComputerNumber(){
        computerNumber = null;
        computerNumber = new GameNumber();
    }

    private BaseballGame() {
        this.computerNumber = new GameNumber();
    }

    public void inputNumbers() {
        System.out.print(INPUT_MESSAGE);
        this.userInput = new GameNumber(Console.readLine());
    }

    public void printGameScore() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public void calculateScore() {
        strike = 0;
        ball = 0;
        List<Integer> computerBoard = computerNumber.getBoard();
        List<Integer> userBoard = userInput.getBoard();
        for (int i = 0; i < computerBoard.size(); i++) {
            if (computerBoard.equals(userBoard)) {
                strike = 3;
                break;
            }
            if (computerBoard.get(i).equals(userBoard.get(i))) {
                strike++;
            } else if (computerBoard.contains(userBoard.get(i))) {
                ball++;
            }
        }
    }

//    enum GameResult {
//        END, ALL_STRIKE, WRONG
//    }
//
//

//    public GameResult runGame(){
//        boolean isGameEnd = false;
//        while (!isGameEnd){
//            inputNumbers();
//            calculateScore();
//            printGameScore();
//            if (strike == ALL_STRIKE) {
//                System.out.println(GAMEOVER_MESSAGE);
//                return GameResult.ALL_STRIKE;
//            }
//
//            return GameResult.WRONG;
//        }
//    }

}
