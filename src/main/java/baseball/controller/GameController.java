package baseball.controller;

import baseball.domain.GameService;
import baseball.util.Parser;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    GameService service = new GameService();
    Parser parser = new Parser();
    Validator validator = new Validator();
    List<Integer> computerNumbers = new ArrayList<>();

    public static boolean playing = true;

    public void init() {
        computerNumbers.clear();
    }

    public void play() {
        InputView.printStart();
        while (playing) {
            if (computerNumbers.isEmpty()) computerNumbers = service.generateNumbers();
            System.out.println("치트: " + computerNumbers.get(0) + computerNumbers.get(1) + computerNumbers.get(2));
            InputView.printRequestingInput();
            final List<Integer> userNumbers = getUserNumbers();
            int[] result = service.compare(computerNumbers, userNumbers);
            OutputView.printResult(result);
            if(service.isThreeStrikes(result)){
                InputView.printGameOver();
                restartOrNot(InputView.getUserInput());
            }
        }
    }

    private List<Integer> getUserNumbers() {
        final List<Integer> userNumbers = parser.parseInputToList(InputView.getUserInput());
        if(validator.isInvalid(userNumbers)) throw new IllegalArgumentException(InputView.MSG_EXCEPTION_INVALID_INPUT);
        return userNumbers;
    }

    private void restartOrNot(String input) {
        if (validator.isInvalid(input)) throw new IllegalArgumentException(InputView.MSG_EXCEPTION_INVALID_INPUT);
        init();
        if(input.equals(InputView.EXIT)) playing = false;
    }
}
