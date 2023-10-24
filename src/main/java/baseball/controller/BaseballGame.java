package baseball.controller;
import baseball.model.ComputerNumber;
import baseball.util.NumberCompare;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

//전체적인 게임 진행
public class BaseballGame {
    public static void startGame() {
        OutputView.printGameStart();
        String comNumber = ComputerNumber.makeComNum();
        continueGame(comNumber);
    }

    public static void continueGame(String comNumber){
        String userNumber = UserNumber.userNumber();
        int[] result = NumberCompare.resultBallStrike(userNumber, comNumber);

        if (result[1] != 3) {
            printBallStrikeResult(result[0], result[1]);
            printStrikeResult(result[0], result[1]);
            printBallResult(result[0], result[1]);
            printNothingResult(result[0], result[1]);
            continueGame(comNumber);
        } else {
            finishGame(result[1]);
        }
    }

    public static void printNothingResult(int ball, int strike) {
        if(ball == 0 && strike == 0){
                OutputView.printNothingMessage();
        }
    }

    public static void printStrikeResult(int ball, int strike) {
        if(ball == 0 && strike != 0){
            OutputView.printCount(strike);
            OutputView.printStrikeMessage();
        }
    }

    public static void printBallResult(int ball, int strike) {
        if(ball != 0 && strike == 0){
            OutputView.printCount(ball);
            OutputView.printBallMessage();
        }
    }

    public static void printBallStrikeResult(int ball, int strike) {
        if(ball != 0 && strike != 0){
                OutputView.printCount(ball);
                OutputView.printBallMessage();
                OutputView.printCount(strike);
                OutputView.printStrikeMessage();
        }
    }

    public static void finishGame(int strike) throws IllegalArgumentException {
        OutputView.printCount(strike);
        OutputView.printStrikeMessage();
        OutputView.printGameEnd();
        String ask = InputView.askForRestart();
        if (!ask.equals("1") && !ask.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        if (ask.equals("1")) {
            startGame();
        }
    }

}
