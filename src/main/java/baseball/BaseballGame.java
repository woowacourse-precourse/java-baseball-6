package baseball;

import baseball.global.util.MessagePrinter;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.global.GameMessage.*;


public class BaseballGame implements ComputerGame {
    static final int NUMBER_RANGE_START = 1;
    static final int NUMBER_RANGE_END = 9;
    static final int NUMBER_SIZE = 3;

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private final List<Integer> numbers;
    private boolean continueGame = true;

    public BaseballGame() {
        numbers = new ArrayList<>();
    }

    public void game() {
        // 게임 설정
        // 게임 반복
        setting();
        boolean win = false;
        while (!win) {
            List<Integer> playerNumbers = getPlayerNumbers();
            String result = compareInputAndNumbers(playerNumbers);
            MessagePrinter.printMessage(result);
            if (result.contains(NUMBER_SIZE + STRIKE)) {
                win = true;
                MessagePrinter.printNumberAndMessage(NUMBER_SIZE, BASEBALL_WIN_GAME.message);
            }
        }
    }

    public void play() {
        MessagePrinter.printMessage(BASEBALL_START_GAME.message);
        while (continueGame) {
            this.game();
            MessagePrinter.printMessage(BASEBALL_RESTART.message);
            String input = Console.readLine();
            if (input.equals("1")) {
                continueGame = true;
            }
            else if (input.equals("2")) {
                continueGame = false;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
    }

    public void setting() {
        this.setNumber();
    }

    private void setNumber() {
        numbers.clear();
        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    private List<Integer> getPlayerNumbers() {
        MessagePrinter.printMessage(GLOBAL_GET_NUMBER.message);
        String input = Console.readLine();
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        String[] split = input.split("");
        List<Integer> playerNumbers = new ArrayList<>();
        for (String s : split) {
            int n;
            try {
                n = Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }

            if (playerNumbers.contains(n)) {
                throw new IllegalArgumentException();
            }
            if (n < NUMBER_RANGE_START || n > NUMBER_RANGE_END) {
                throw new IllegalArgumentException();
            }
            playerNumbers.add(n);
        }
        return playerNumbers;
    }

    private String compareInputAndNumbers(List<Integer> input) {
        // 숫자 비교
        // 비교한 결과 출력
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (numbers.get(i).equals(input.get(i))) {
                strike++;
            }
            else {
                if (numbers.contains(input.get(i))) {
                    ball++;
                }
            }
        }
        return getCompareResult(ball, strike);
    }

    private String getCompareResult(int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if (ball + strike == 0)
            return NOTHING;
        if (ball > 0) {
            sb.append(ball).append(BALL).append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append(STRIKE).append(" ");
        }
        return sb.toString();
    }
}
