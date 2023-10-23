package baseball.controller;

import static baseball.constant.BaseballConstant.BASEBALL_THREE_STRIKES;

import baseball.domain.Computer;
import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.PlayerService;
import baseball.validator.BaseballValidator;

public class BaseballController {

    private final ComputerService computerService;
    private final PlayerService playerService;
    private final MessageService messageService;

    public BaseballController() {
        BaseballValidator baseballValidator = new BaseballValidator();
        this.messageService = new MessageService();
        this.computerService = new ComputerService(baseballValidator);
        this.playerService = new PlayerService(baseballValidator);
    }

    public void start() {
        do {
            playGame();
        } while (playerService.askToContinue());
    }

    private void playGame() {
        Computer computer = initializeComputer();

        int balls, strikes = 0;

        while (strikes != BASEBALL_THREE_STRIKES) {
            messageService.inputPlayerNumber();

            String playerBaseballNumber = playerService.receiveBaseballNumber();
            balls = computer.countBalls(playerBaseballNumber);
            strikes = computer.countStrikes(playerBaseballNumber);

            messageService.printGameResult(balls, strikes);
        }

        messageService.announceThreeStrikes();
    }

    private Computer initializeComputer() {
        messageService.startGame();
        return computerService.create();
    }
}
