package baseball.Service;

import baseball.Computer;
import baseball.User;
import baseball.Utils.Converter;
import baseball.view.InputMessage;
import baseball.view.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private Computer computer = new Computer();
    private User user = new User();

    int strikeCount = 0;
    int ballCount = 0;

    private Converter converter = new Converter();


    public void play() {
        while (true) {
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

    public void setGame() {
        computer.generateNumber();
        OutputMessage.printStartMessage();
    }

    private void getUserNumber() {
        InputMessage.printUserInputMessage();
        String input = Console.readLine();
        user.setInputNumber(converter.convertUserInputToInt(input));
    }
}
