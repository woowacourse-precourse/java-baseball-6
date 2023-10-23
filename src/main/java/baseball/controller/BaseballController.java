package baseball.controller;

import baseball.domain.Computer;
import baseball.service.MessageService;
import baseball.validator.PlayerNumberValidator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    private static final int RESTART_OPTION = 1;
    private static final int TURN_OFF_OPTION = 2;
    public static final int BASEBALL_NUMBERS_SIZE = 3;
    public static final int BASEBALL_MIN_NUMBER = 1;
    public static final int BASEBALL_MAX_NUMBER = 9;

    private final MessageService messageService;
    private final PlayerNumberValidator playerNumberValidator;

    public BaseballController() {
        this.messageService = new MessageService();
        this.playerNumberValidator = new PlayerNumberValidator();
    }

    public void startGame() {
        do {
            initGame();
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
            default -> throw new IllegalArgumentException("잘못된 선택입니다.");
        }
    }

    private void playGame() {
        Computer computer = new Computer();

        int balls, strikes = 0;

        while (strikes != BASEBALL_NUMBERS_SIZE) {
            String player = receivePlayerNumber();

            balls = computer.countBalls(player);
            strikes = computer.countStrikes(player);

            messageService.printGameResult(balls, strikes);
        }

        messageService.announceThreeStrikes();
    }

    private String receivePlayerNumber() {
        messageService.inputPlayerNumber();
        String number = Console.readLine();

        playerNumberValidator.validate(number);

        return number;
    }

    private void initGame() {
        messageService.startGame();
    }
}
