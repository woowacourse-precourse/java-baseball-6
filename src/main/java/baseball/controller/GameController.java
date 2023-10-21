package baseball.controller;

import baseball.domain.GameService;
import baseball.util.Parser;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    GameService service = new GameService();
    Parser parser = new Parser();
    Validator validator = new Validator();
    List<Integer> computerNumbers = new ArrayList<>();

    private static final String EXIT = "2";
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
            List<Integer> userNumbers = receiveInput();
            int[] result = service.compare(computerNumbers, userNumbers);
            OutputView.printResult(result);
            if(service.isThreeStrikes(result)){
                InputView.printGameOver();
                String restartInput = Console.readLine();
                determineRestart(restartInput);
            }
        }
    }

    private List<Integer> receiveInput(){
        String input = Console.readLine();
        List<Integer> userNumbers = parser.parseInputToList(input);
        if (validator.isInvalid(userNumbers)) throw new IllegalArgumentException(InputView.MSG_EXCEPTION_INVALID_INPUT);
        return userNumbers;
    }

    private void determineRestart(String restartInput) {
        if (validator.isInvalid(restartInput)) throw new IllegalArgumentException(InputView.MSG_EXCEPTION_INVALID_INPUT);
        init();
        if(restartInput.equals(EXIT)) playing = false;
    }
}
