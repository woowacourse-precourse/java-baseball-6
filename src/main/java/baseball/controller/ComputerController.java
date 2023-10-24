package baseball.controller;

import baseball.domain.Computer;
import baseball.validation.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Computer computer = new Computer();
    Validator validator = new Validator();

    public void start() {
        boolean gameState = false;
        computer.setComputerNumber();
        int computerNumber = computer.getComputerNumber();
        while (!gameState) {
            String playerNum = inputView.print_input_message();
            int playerNumber = validator.checkValid(playerNum);
            gameState = compareNumber(computerNumber, playerNumber);
        }
        outputView.print_end();
    }

    private boolean compareNumber(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            outputView.print_strike(3);
            return true;
        }
        compareComputerAndPlayer(playerNumber);
        return false;
    }

    private void compareComputerAndPlayer(int playerNumber) {
        List<Integer> playerNumbers = numberToList(playerNumber);
        List<Integer> computerNumbers = computer.getComputerNumbers();
        int strike = strikeCheck(playerNumbers, computerNumbers);
        int ball = ballCheck(playerNumbers, computerNumbers);

        print_hint(strike, ball);
    }

    private void print_hint(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            outputView.print_strike_and_ball(ball, strike);
            return;
        }
        if (strike != 0 && ball == 0) {
            outputView.print_strike(strike);
            return;
        }
        if (strike == 0 && ball != 0) {
            outputView.print_ball(ball);
            return;
        }
        outputView.print_nothing();
    }

    private int ballCheck(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (playerNumbers.get(i) != computerNumbers.get(i) && computerNumbers.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int strikeCheck(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (playerNumbers.get(i) == computerNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private List<Integer> numberToList(int playerNumber) {
        List<Integer> tempList = new ArrayList<>();
        while (playerNumber % 10 != 0){
            int temp = playerNumber % 10;
            tempList.add(temp);
            playerNumber /= 10;
        }
        Collections.reverse(tempList);
        return tempList;
    }
}
