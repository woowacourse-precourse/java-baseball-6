package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import baseball.utils.ValidationUtils;

import baseball.utils.NumberGenerator;

import baseball.utils.ScoreCounter;

import baseball.utils.Printer;

import baseball.utils.InputReader;

public class Application {

    public static void main(String[] args) {
        boolean isGameActive = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isGameActive) {
            newGame();
            isGameActive = askRestartOrExit();
        }
        System.out.println("게임이 종료됩니다.");
    }

    private static boolean askRestartOrExit() {
        return InputReader.getUserGameAction()==1;
    }

    private static void newGame() {
        List<Integer> computer = NumberGenerator.generateUnique3DigitNum();
        playGame(computer);
    }

    private static void playGame(List<Integer> computer) {
        int ball;
        int strike = 0;
        while (strike != 3) {
            List<Integer> user = InputReader.getUserNumber();
            ball = ScoreCounter.countBall(computer, user);
            strike = ScoreCounter.countStrike(computer, user);
            Printer.printGameResult(ball, strike);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }



}
