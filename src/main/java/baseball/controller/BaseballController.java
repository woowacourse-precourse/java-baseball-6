package baseball.controller;

import static baseball.constant.BaseballConstant.BASEBALL_THREE_STRIKES;

import baseball.domain.Computer;
import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.PlayerService;
import baseball.validator.BaseballValidator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    private final ComputerService computerService;
    private final PlayerService playerService;
    private final MessageService messageService;
    private final BaseballValidator baseballValidator;

    public BaseballController() {
        this.baseballValidator = new BaseballValidator();
        this.computerService = new ComputerService(baseballValidator);
        this.playerService = new PlayerService();
        this.messageService = new MessageService();
    }

    public void start() {
        do {
            playGame(initializeComputer());
        } while (askToContinue());
    }

    public boolean askToContinue() {
        String optionNumber = Console.readLine();
        return playerService.selectOption(optionNumber);
    }

    private void playGame(Computer computer) {
        int balls, strikes = 0;

        while (strikes != BASEBALL_THREE_STRIKES) {
            messageService.inputPlayerNumber();

            String baseballNumber = receiveBaseballNumber();
            balls = computer.countBalls(baseballNumber);
            strikes = computer.countStrikes(baseballNumber);

            messageService.printGameResult(balls, strikes);
        }

        messageService.announceThreeStrikes();
    }

    private String receiveBaseballNumber() {
        String baseballNumber = Console.readLine();
        baseballValidator.validate(baseballNumber);
        return baseballNumber;
    }

    private Computer initializeComputer() {
        messageService.announceStartGame();
        return computerService.create();
    }
}
