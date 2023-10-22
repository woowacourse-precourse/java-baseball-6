package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private static final int NUMBER_LENGTH = 3;
    private static final String STRING_BALL = "볼";
    private static final String STRING_STRIKE = "스트라이크";
    private static final String STRING_NOTHING = "낫싱";
    private static final String INPUT_RESTART = "1";
    private static final String INPUT_QUIT = "2";
    private static final String OUTPUT_START = "숫자 야구 게임을 시작합니다.";
    private static final String OUTPUT_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String OUTPUT_RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String EXCEPTION_MESSAGE = "Please answer 1 or 2.";

    private int strike;
    private int ball;
    private int randomNumber;
    private int userNumber;
    private List<String> randomDigits;
    private List<String> userDigits;
    private boolean quit = false;
    public String quitInput;
    private Computer computer = new Computer();;
    private User user = new User();

    public Game() {
    }
    public void play() {
        System.out.println(OUTPUT_START);
        initializeRandomNumber();

        while(!quit) {

            initializeUserNumber();
            initializeBallCount();

            separateNumberToDigits();
            calculateBallCount();
            printBallCount();

            if(strike == NUMBER_LENGTH) {
                System.out.println(OUTPUT_SUCCESS);
                System.out.println(OUTPUT_RESTART_OR_QUIT);
                setQuitInput();
                handleQuit();
                handleRestart();
            }
        }
    }

    private void initializeUserNumber() {
        user.setUserNumber();
        userNumber = user.getUserNumber();
    }

    private void initializeRandomNumber() {
        computer.setRandomNumber();
        randomNumber = computer.getRandomNumber();
    }

    private void calculateBallCount() {
        for(int i=0; i<NUMBER_LENGTH; i++) {
            calculateStrikeByIndex(i);
            calculateBallByIndex(i);
        }
    }

    private void calculateBallByIndex(int index) {
        for(int k=0; k<NUMBER_LENGTH; k++) {
            if(index != k && randomDigits.get(index).equals(userDigits.get(k))) {
                ball++;
            }
        }
    }

    private void calculateStrikeByIndex(int index) {
        if(randomDigits.get(index).equals(userDigits.get(index))) {
            strike++;
        }
    }

    private void handleRestart() {
        if(quitInput.equals(INPUT_RESTART)) {
            initializeRandomNumber();
        }
    }

    private void handleQuit() {
        if(quitInput.equals(INPUT_QUIT)) {
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
        if(!inputValidation) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private void printBallCount() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = STRING_NOTHING;
        }else if (ball == 0 && strike > 0) {
            result = strike + STRING_STRIKE;
        }else if (ball > 0 && strike == 0) {
            result = ball + STRING_BALL;
        }else if (ball > 0 && strike > 0) {
            result = ball + STRING_BALL + " " + strike + STRING_STRIKE;
        }
        System.out.println(result);
    }

    private void separateNumberToDigits() {
        randomDigits = getSplitList(randomNumber);
        userDigits = getSplitList(userNumber);
    }

    private List<String> getSplitList(int number) {
        return Arrays.asList(String.valueOf(number).split(""));
    }

    private void initializeBallCount() {
        strike = 0;
        ball = 0;
    }
}

