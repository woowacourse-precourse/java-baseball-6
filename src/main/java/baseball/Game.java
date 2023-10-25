package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Game {
    public final String RESTART = "1";
    public static final String END = "2";

    public void run() {
        Message.startGame();
        String flag = RESTART;

        while (isRestart(flag)) {
            List<Integer> computerNumber = setComputerNumber();
            startNewGame(computerNumber);
            Message.endOrRestart();
            flag = Console.readLine();
        }
    }

    private void startNewGame(List<Integer> computerNumber) {
        boolean gameStatus = false;
        while (!gameStatus) {
            List<Integer> userNumber = setUserNumber();
            gameStatus = isEnd(getStrikeCount(userNumber, computerNumber));
            Message.printResult(getBallCount(userNumber, computerNumber), getStrikeCount(userNumber, computerNumber));
        }
        Message.endGame();
    }

    private int getBallCount(List<Integer> userNumber, List<Integer> computerNumber) {
        return (int) Stream.iterate(0, i -> i < userNumber.toArray().length, i -> i + 1)
                .filter(i -> computerNumber.contains(userNumber.get(i))
                        && computerNumber.get(i) != userNumber.get(i))
                .count();
    }

    private int getStrikeCount(List<Integer> userNumber, List<Integer> computerNumber) {
        return (int) Stream.iterate(0, i -> i < userNumber.toArray().length, i -> i + 1)
                .filter(i -> computerNumber.get(i) == userNumber.get(i))
                .count();
    }

    private List<Integer> setUserNumber() {
        User user = new User();
        List<Integer> userNum = new ArrayList<>();
        userNum = user.input();

        return userNum;
    }

    private List<Integer> setComputerNumber() {
        Computer computer = new Computer();
        List<Integer> comNum = new ArrayList<>();
        comNum = computer.getRandomNumber();

        return comNum;
    }

    private boolean isEnd(int strikeCount) {
        return strikeCount == 3;
    }

    private boolean isRestart(String flag) {
        if (flag.equals(RESTART)) {
            return true;
        } else if (flag.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

}
