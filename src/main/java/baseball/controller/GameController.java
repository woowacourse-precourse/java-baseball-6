package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.ComputerService;
import baseball.util.ConvertObjectType;
import baseball.util.ValidatorPlayerInput;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.view.PrintMessage.*;

public class GameController {
    private Computer computer;
    private Player player;

    private ComputerService computerService;

    public GameController(ComputerService computerService) {
        this.computerService = computerService;
    }

    public void startGame() {
        System.out.println(GAME_START.getMessage());
        this.player = new Player();
        this.computer = new Computer();
        BaseballNumber computerWithRandomNumber = computerService.createComputerWithRandomNumber();
        computer.updateBaseballNumber(computerWithRandomNumber);
        doGame();
    }

    public void doGame() {
        do {
            setPlayerBaseballNumber();
        } while (!checkGuessNumber());
        System.out.println(GAME_END.getMessage());

        if (wantsToKeepPlaying()) {
            BaseballNumber computerWithRandomNumber = computerService.createComputerWithRandomNumber();
            computer.updateBaseballNumber(computerWithRandomNumber);
            doGame();
        }
    }

    public void setPlayerBaseballNumber() {
        System.out.print(REQUEST_INPUT_NUMBER.getMessage());
        String input = Console.readLine();
        List<Integer> inputToList = ConvertObjectType.convertStringToList(input);
        ValidatorPlayerInput.validateNumberSizeAndDuplicate(inputToList);
        BaseballNumber playerInputNumber = new BaseballNumber(inputToList);
        player.updateBaseballNumber(playerInputNumber);
    }

    public boolean wantsToKeepPlaying() {
        System.out.println(ASK_KEEP_GOING_GAME.getMessage());
        String input = Console.readLine();
        ValidatorPlayerInput.checkResumeInput(input);
        return input.equals("1");
    }

    public boolean checkGuessNumber() {
        List<Integer> computerList = computer.getBaseballNumber();
        List<Integer> playList = player.getBaseballNumber();

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (playList.get(i).equals(computerList.get(i))) {
                strikes++;
            } else if (computerList.contains(playList.get(i))) {
                balls++;
            }
        }

        if (strikes == 3) {
            System.out.println(strikes + STRIKE.getMessage());
            return true;
        }
        if (balls > 0 || strikes > 0) {
            StringBuilder result = new StringBuilder();
            if (balls > 0) {
                result.append(balls).append(BALL.getMessage() + " ");
            }
            if (strikes > 0) {
                result.append(strikes).append(STRIKE.getMessage());
            }
            System.out.println(result);
            return false;
        }
        System.out.println(NOTHING.getMessage());
        return false;
    }

}
