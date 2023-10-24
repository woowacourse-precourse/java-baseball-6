package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.ComputerService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.view.OutputMessage.*;

public class GameController {
    private Computer computer;
    private Player player;

    public void startGame() {
        System.out.println(GAME_START.getMessage());
        this.computer = new Computer();
        ComputerService.createComputerWithRandomNumber(this.computer);
        this.player = new Player();
        doGame();
    }

    public void doGame() {
        do {
            System.out.print(REQUEST_INPUT_NUMBER.getMessage());
            String input = Console.readLine();
            System.out.println("===========input" + input);
            BaseballNumber playerInputNumber = new BaseballNumber(convertStringToList(input));
            player.updateBaseballNumber(playerInputNumber);
        } while (!checkGuessNumber());

        if (wantsToKeepPlaying()) {
            ComputerService.createComputerWithRandomNumber(this.computer);
            doGame();
        }
    }

    public boolean wantsToKeepPlaying() {
        System.out.println(ASK_KEEP_GOING_GAME.getMessage());
        String input = Console.readLine();
        checkResumeInput(input);
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
            System.out.println(GAME_END.getMessage());
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

    private void checkResumeInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("시작이나 종료의 입력값이 아닙니다.");
        }
    }

    private List<Integer> convertStringToList(String input) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char charAtPosition = input.charAt(i);
            int digit = Character.getNumericValue(charAtPosition);
            resultList.add(digit);
        }
        return resultList;
    }

}
