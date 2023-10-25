package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import util.Util;

public class BaseBallGame {
    private List<Integer> computer;

    public BaseBallGame() {
        this.computer = new ArrayList<>();
    }

    public void run() {
        System.out.println(MessageList.GAME_START);
        while (true) {
            startGame();
            if (!isRestart()) {
                break;
            }
        }
    }

    private void startGame() {
        computer = Util.makeRandomNumbers();
        String input;

        while (true) {
            System.out.print(MessageList.INPUT);
            input = Console.readLine();
            InputException.validGameInput(input);

            List<Integer> inputNumbers = Util.toIntegerArray(input);
            String message = takeTurn(computer, inputNumbers);
            System.out.println(message);
            if (isEnd(message)) {
                break;
            }
        }
    }

    private boolean isRestart() {
        System.out.println(MessageList.RESTART_OR_END);
        String input = Console.readLine();
        InputException.validRestartInput(input);
        if (input.contains(MessageList.CONTINUE)) {
            return true;
        }
        return false;
    }

    private String takeTurn(List<Integer> computer, List<Integer> inputNumbers) {
        int ballCount = countBall(computer, inputNumbers);
        int strikeCount = countStrike(computer, inputNumbers);
        String message = MessageList.setBallMessage(ballCount) + MessageList.setStrikeMessage(strikeCount);
        return checkMessage(message);
    }

    private boolean isEnd(String message) {
        return message.contains(MessageList.GAME_END);
    }

    public String checkMessage(String message) {
        if (message.isEmpty()) {
            message = MessageList.NOTHING;
        }
        if (message.contains(MessageList.GAME_END)) {
            message += MessageList.ALL_CORRECT;
        }
        return message;
    }

    public int countStrike(List<Integer> computer, List<Integer> inputNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(inputNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(List<Integer> computer, List<Integer> inputNumbers) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            Integer inputNumber = inputNumbers.get(i);
            if (!computer.get(i).equals(inputNumber) && computer.contains(inputNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
