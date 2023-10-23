package baseball;

import baseball.utils.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final int LENGTH = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_NUMBER = "1";
    private static final String END_NUMBER = "2";
    private static final String START_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    private int ball;
    private int strike;
    private String checkInput;
    private boolean flag = false;
    private ComputerNumber computerNumber = new ComputerNumber();
    private List<Character> computer;

    public void playBaseballGame() {
        System.out.println(START_MESSAGE);
        initComputerNumber();
        while (!this.flag) {
            initializeCount();
            Player player = new Player();
            player.setPlayerNumbers();

            checkBallAndStrike(computer, player.getPlayerNumbers());
            printBallCount();
            if (strike == LENGTH) {
                System.out.println(SUCCESS_MESSAGE);
                System.out.println(START_OR_END);
                if (setFlag()) {
                    flag = true;
                }
            }
        }

    }

    private void initComputerNumber() {
        computerNumber.setComputerNumber();
        computer = computerNumber.getComputerNumbers();
    }

    private boolean setFlag() {
        checkInput = Console.readLine();
        validateQuitInput();

        if (checkInput.equals(START_NUMBER)) {
            initComputerNumber();
            return false;
        }

        if (checkInput.equals(END_NUMBER)) {
            return true;
        }
        return false;
    }

    private void initializeCount() {
        this.ball = 0;
        this.strike = 0;
    }

    private void checkBallAndStrike(List<Character> computer, List<Character> player) {
        for (int i = 0; i < LENGTH; i++) {
            checkStrike(computer, player, i);
            checkBall(computer, player, i);
        }
    }

    private void checkStrike(List<Character> computer, List<Character> player, int index) {
        if (computer.get(index).equals(player.get(index))) {
            strike++;
        }
    }

    private void checkBall(List<Character> computer, List<Character> player, int index) {
        for (int i = 0; i < LENGTH; i++) {
            if (index != i && computer.get(index).equals(player.get(i))) {
                ball++;
            }
        }
    }

    private void printBallCount() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = NOTHING;
        } else if (ball == 0 && strike > 0) {
            result = strike + STRIKE;
        } else if (ball > 0 && strike == 0) {
            result = ball + BALL;
        } else if (ball > 0 && strike > 0) {
            result = ball + BALL + " " + strike + STRIKE;
        }
        System.out.println(result);
    }

    private void validateQuitInput() {
        List<String> inputList = new ArrayList<>(Arrays.asList(new String[]{"1", "2"}));
        boolean inputValidation = inputList.contains(checkInput);
        if (!inputValidation) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE_ERROR.getMessage());
        }
    }

}
