package baseball.controller;

import static baseball.constant.BaseballConstant.BASEBALL_THREE_STRIKES;
import static baseball.constant.BaseballConstant.RESTART_OPTION;
import static baseball.constant.BaseballConstant.TURN_OFF_OPTION;

import baseball.domain.Computer;
import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.PlayerService;
import baseball.validator.BaseballValidator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    private static final String WRONG_CHOICE_MESSAGE = "잘못된 선택입니다.";

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
        } while (askToContinue());
    }

    private boolean askToContinue() {
        String number = Console.readLine();
        return selectOption(number);
    }

    private boolean selectOption(String number) {
        switch (Integer.parseInt(number)) {
            case RESTART_OPTION -> {
                return true;
            }
            case TURN_OFF_OPTION -> {
                return false;
            }
            default -> throw new IllegalArgumentException(WRONG_CHOICE_MESSAGE);
        }
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
