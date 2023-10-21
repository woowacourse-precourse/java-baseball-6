package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBERS_SIZE = 3;

    private final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int strike = 0;
    private int ball = 0;

    private Computer computer = new Computer();
    private User user = new User();

    public Baseball() {
    }

    public void startGame() {
        int choiceNumber = 1;

        System.out.println(START_GAME_MESSAGE);

        do {
            play();
            System.out.println(CONTINUE_MESSAGE);

            String inputValue = userNumberInput();
            user.validateRange(inputValue);

            choiceNumber = user.parseNumber(inputValue.charAt(0));
        } while (choiceNumber == 1);
    }

    public void play() {
        computer.generateComputerNumber();

        while (true) {
            System.out.print(NUMBER_INPUT_MESSAGE);

            strike = 0;
            ball = 0;

            String inputValue = userNumberInput();
            user.validateLength(inputValue);
            user.validateRange(inputValue);

            user.generateUserNumber(inputValue);
            checkSameNumber();
            showUserScore();

            if (strike == 3) {
                System.out.println(STRIKE_MESSAGE);
                break;
            }
        }
    }

    private void checkSameNumber() {
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            int computerNumber = computer.getComputerNumber(i);
            int userNumber = user.getUserNumber(i);

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
