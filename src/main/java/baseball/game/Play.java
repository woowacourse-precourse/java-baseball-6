package baseball.game;

import baseball.player.Computer;
import baseball.player.User;
import baseball.utils.InputValidator;
import baseball.utils.PrintGuide;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Play {
    String userInput;

    PrintGuide printGuide = new PrintGuide();
    InputValidator inputValidator = new InputValidator();

    public void start() {
        printGuide.printIntro();
        do {
            play();
            printGuide.printRetryCommand();
            userInput = Console.readLine();
            inputValidator.checkRetryInput(userInput);
        } while (userInput.equals("1"));
        printGuide.printOutro();
    }

    void play() {
        Computer computer = new Computer();

        while (true) {
            printGuide.printInputCommand();
            userInput = Console.readLine();
            inputValidator.checkUserInput(userInput);

            List<Integer> userInputList = Arrays.stream(userInput.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            User user = new User(userInputList);
            Game game = new Game(computer, user);
            Boolean gameResult = printGuide.printGameResult(user);
            if (gameResult) {
                break;
            }
        }
    }
}
