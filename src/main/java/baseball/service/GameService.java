package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.utils.Converter;
import baseball.view.InputMessage;
import baseball.view.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private Computer computer = new Computer();
    private User user = new User();
    private int strikeCount;
    private int ballCount;

    private Converter converter = new Converter();

    public void play() {
        while (true) {
            resetCount();
            getUserNumber();
            getResult(user.getInputNumber());

            if (strikeCount == 3) {
                OutputMessage.printWinMessage();
                break;
            }
        }
    }

    public void getResult(int[] guessNumbers) {
        for (int i = 0; i < 3; i++) {
            search(guessNumbers[i], i, computer.getNumbers());
        }
        OutputMessage.printResultMessage(strikeCount, ballCount);
    }


    private void search(int guessNumber, int index, int[] computerNumbers) {
        if (guessNumber == computerNumbers[index]) {
            strikeCount++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (guessNumber == computerNumbers[i]) {
                ballCount++;
            }
        }
    }

    public void startGame() {
        OutputMessage.printStartMessage();
    }

    public void setGame() {
        computer.generateNumber();
    }

    private void getUserNumber() {
        InputMessage.printUserInputMessage();
        String input = Console.readLine();
        user.setInputNumber(converter.convertUserChooseInputToInt(input));
    }

    public boolean getUserRetryRequest() {
        InputMessage.printRePlayInputMessage();
        String input = Console.readLine();
        int convertedInput = converter.convertUserInputToInt(input);

        if (convertedInput == 1) {
            return true;
        } else if (convertedInput == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void resetCount() {
        strikeCount = 0;
        ballCount = 0;
    }
}
