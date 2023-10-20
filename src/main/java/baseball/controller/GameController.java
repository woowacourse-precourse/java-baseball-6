package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final int NUMBER_LENGTH = 3;
    private static final char ZERO_CHAR = '0';

    private int strike;
    private int ball;
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    ComputerNumber computerNumber = new ComputerNumber();
    PlayerNumber playerNumber = new PlayerNumber();

    public void startGame() {
        outputView.printStartMessage();
        computerNumber.setComputerNumbers(getRandomNumbers());

        String playerNumberStr = inputView.inputPlayerNumber();
        playerNumber.setPlayerNumbers(convertPlayerNumberToList(playerNumberStr));

        initStrikeAndBall();
        List<Integer> player = playerNumber.getPlayerNumbers();
        List<Integer> computer = computerNumber.getComputerNumbers();
        if (isPlayerSameAsComputer(player, computer)) {
            strike = 3;
        } else {
            calculateHint(player, computer);
        }
    }

    public List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public List<Integer> convertPlayerNumberToList(String playerNumberStr) {
        List<Integer> player = new ArrayList<>();
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            int number = playerNumberStr.charAt(index) - ZERO_CHAR;
            player.add(number);
        }

        return player;
    }

    public void initStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    public boolean isPlayerSameAsComputer(List<Integer> player, List<Integer> computer) {
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (!player.get(index).equals(computer.get(index))) {
                return false;
            }
        }

        return true;
    }

    public void calculateHint(List<Integer> player, List<Integer> computer) {
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (player.get(index).equals(computer.get(index))) {
                strike++;
                continue;
            }

            if (computer.contains(player.get(index))) {
                ball++;
            }
        }
    }
}
