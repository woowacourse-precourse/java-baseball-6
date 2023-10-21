package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int strike = 0;
    private int ball = 0;

    private Computer computer = new Computer();
    private List<Integer> user = new ArrayList<>();

    public Baseball() {
    }

    public void startGame() {
        int choiceNumber = 1;

        System.out.println(START_GAME_MESSAGE);

        do {
            play();
            System.out.println(CONTINUE_MESSAGE);
            choiceNumber = parseNumber(userNumberInput().charAt(0));
        } while (choiceNumber == 1);
    }

    public void play() {
        computer.generateComputerNumber(MIN_NUMBER, MAX_NUMBER);

        while (true) {
            System.out.print(NUMBER_INPUT_MESSAGE);

            strike = 0;
            ball = 0;
            String inputValue = userNumberInput();

            if (!validateNumberLength(inputValue)) {
                wrongNumberInput();
            }
            if (!validateNumberRange(inputValue)) {
                wrongNumberInput();
            }

            generateUserNumber(inputValue);
            checkSameNumber();
            showUserScore();

            if (strike == 3) {
                System.out.println(STRIKE_MESSAGE);
                break;
            }
        }
    }

    private void checkSameNumber() {
        for (int i = 0; i < user.size(); i++) {
            int computerNumber = computer.getComputerNumber(i);
            int userNumber = user.get(i);

            if (computerNumber == userNumber) {
                strike++;
            } else if (computer.isContainsNumber(userNumber)) {
                ball++;
            }
        }
    }

    private String userNumberInput() {
        return Console.readLine();
    }

    private void generateUserNumber(String inputValue) {
        if (!user.isEmpty()) {
            user.clear();
        }

        for (int i = 0; i < inputValue.length(); i++) {
            int userNumber = parseNumber(inputValue.charAt(i));

            if (user.contains(userNumber)) {
                wrongNumberInput();
            }

            user.add(userNumber);
        }
    }

    private int parseNumber(char character) {
        return character - '0';
    }

    private boolean validateNumberLength(String inputValue) {
        return inputValue.length() <= 3;
    }

    private boolean validateNumberRange(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            int userNumber = parseNumber(inputValue.charAt(i));

            if (!(MIN_NUMBER <= userNumber && userNumber <= MAX_NUMBER)) {
                return false;
            }
        }

        return true;
    }

    private void wrongNumberInput() {
        throw new IllegalArgumentException();
    }

    private void showUserScore() {
        String message;

        if (strike == 0 && ball == 0) {
            message = "낫싱";
        } else if (strike == 0) {
            message = ball + "볼";
        } else if (ball == 0) {
            message = strike + "스트라이크";
        } else {
            message = ball + "볼 " + strike + "스트라이크";
        }

        System.out.println(message);
    }
}
