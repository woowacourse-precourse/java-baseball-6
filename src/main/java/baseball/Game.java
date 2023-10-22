package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private static final int NUMBER_LENGTH = 3;
    private static final String INPUT_RESTART = "1";
    private static final String INPUT_QUIT = "2";
    private static final String EXCEPTION_MESSAGE = "게임을 다시 시작하려면 1을 완전히 종료하려면 2를 입력해주세요. "
            + "다른 입력은 불가능합니다";

    private int strike;
    private int ball;
    private int randomNumber;
    private int userNumber;
    private List<String> randomDigits;
    private List<String> userDigits;
    private boolean quit = false;
    public String quitInput;
    private Computer computer = new Computer();
    private User user = new User();


    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.setRandomNumber();
        randomNumber = computer.getRandomNumber();

        while (!quit) {

            user.setUserNumber();
            userNumber = user.getUserNumber();

            strike = 0;
            ball = 0;

            randomDigits = getSplitList(randomNumber);
            userDigits = getSplitList(userNumber);

            countStrikeAndBall();
            printHints();

            if (strike == NUMBER_LENGTH) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                setQuitInput();
                handleQuit();
                handleRestart();
            }
        }
    }


    private void countStrikeAndBall() {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            countStrike(i);  //
            countBall(i);
        }
    }


    private void countBall(int index) {
        for (int k = 0; k < NUMBER_LENGTH; k++) {
            if (index != k && randomDigits.get(index).equals(userDigits.get(k))) {
                ball++;
            }
        }
    }

    private void countStrike(int index) {
        if (randomDigits.get(index).equals(userDigits.get(index))) {
            strike++;
        }
    }


    private List<String> getSplitList(int number) {
        return Arrays.asList(String.valueOf(number).split(""));
    }


    private void handleRestart() {
        if (quitInput.equals(INPUT_RESTART)) {
            computer.setRandomNumber();
            randomNumber = computer.getRandomNumber();
        }
    }

    private void handleQuit() {
        if (quitInput.equals(INPUT_QUIT)) {
            quit = true;
        }
    }

    private void setQuitInput() {
        quitInput = Console.readLine();
        validateQuitInput();
    }

    private void validateQuitInput() {
        List<String> inputList = new ArrayList<>(Arrays.asList(new String[]{"1", "2"}));
        boolean inputValidation = inputList.contains(quitInput);
        if (!inputValidation) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
    // inputlist = [1, 2] 생성말고 조건문으로 처리하기

    private void printHints() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        } else if (ball == 0 && strike > 0) {
            result = strike + "스트라이크";
        } else if (ball > 0 && strike == 0) {
            result = ball + "볼";
        } else if (ball > 0 && strike > 0) {
            result = ball + "볼" + " " + strike + "스트라이크";
        }
        System.out.println(result);
    }


}

