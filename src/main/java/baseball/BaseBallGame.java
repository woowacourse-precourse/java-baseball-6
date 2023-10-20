package baseball;

import baseball.constant.NumberConstant;
import baseball.domain.ChoiceNumber;
import baseball.domain.Result;
import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.UserService;
import baseball.validation.NumberValidation;
import java.util.List;

public class BaseBallGame {
    private final ComputerService computerService = new ComputerService();
    private final MessageService messageService = new MessageService();
    private final UserService userService = new UserService();
    private final NumberValidation validation = new NumberValidation();

    public void startGame() {
        ChoiceNumber choiceNumber = new ChoiceNumber();
        while (choiceNumber.getNumber() != NumberConstant.GAME_END_NUMBER) {
            List<Integer> computer = computerService.createNumber();
            messageService.printStartMessage();
            int ballCount = 0;
            int strikeCount = 0;
            while (strikeCount != NumberConstant.GAME_WIN_NUMBER) {
                messageService.printUserInputNumberMessage();
                String inputNumber = userService.inputUserNumber();
                List<Integer> user = validation.validateInputNumber(inputNumber);
                Result result = comparison(computer, user);

                ballCount = result.getBallCount();
                strikeCount = result.getStrikeCount();

                messageService.printComparisonResult(ballCount, strikeCount);
            }
            messageService.printWinMessage();
            messageService.printGameRestartOrGameEndMessage();
            choiceNumber = InputRestartOrEnd();
        }
    }

    public Result comparison(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < NumberConstant.INPUT_SIZE; i++) {
            int computerNumber = computer.get(i);
            int userNumber = user.get(i);

            if (computerNumber == userNumber) {
                strikeCount++;
                continue;
            }
            if (computer.contains(userNumber)) {
                ballCount++;
            }
        }
        return new Result(ballCount, strikeCount);
    }

    public ChoiceNumber InputRestartOrEnd() {
        int restartNumber = Integer.parseInt(userService.inputUserNumber());
        validation.validateInputChoice(restartNumber);
        return new ChoiceNumber(restartNumber);
    }
}
