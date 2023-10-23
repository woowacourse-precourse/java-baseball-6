package baseball;

public class Baseball {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBERS_SIZE = 3;

    private int strike = 0;
    private int ball = 0;
    private Computer computer = new Computer();
    private User user = new User();

    public Baseball() {
    }

    public void startGame() {
        int choiceNumber = 1;

        System.out.println(InputOut.START_GAME_MESSAGE);

        do {
            play();
            System.out.println(InputOut.CONTINUE_MESSAGE);

            String inputValue = InputOut.userInput();
            user.validateRange(inputValue);

            choiceNumber = user.parseNumber(inputValue.charAt(0));
        } while (choiceNumber == 1);
    }

    public void play() {
        computer.generateComputerNumber();

        while (true) {
            System.out.print(InputOut.NUMBER_INPUT_MESSAGE);

            strike = 0;
            ball = 0;
            String inputValue = InputOut.userInput();

            user.validateLength(inputValue);
            user.validateRange(inputValue);
            user.generateUserNumber(inputValue);
            checkSameNumber();
            InputOut.showUserScore(strike, ball);

            if (strike == NUMBERS_SIZE) {
                System.out.println(InputOut.STRIKE_MESSAGE);
                break;
            }
        }
    }

    private void checkSameNumber() {
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            incrementStrikeOrBall(computer.getComputerNumber(i), user.getUserNumber(i));
        }
    }

    private void incrementStrikeOrBall(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            strike++;
        } else if (computer.isContainsNumber(userNumber)) {
            ball++;
        }
    }
}
