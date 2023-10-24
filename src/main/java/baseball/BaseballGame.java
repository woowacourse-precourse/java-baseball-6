package baseball;

import baseball.global.GameMessage;
import baseball.global.util.MessagePrinter;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;



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
                MessagePrinter.printNumberAndMessage(NUMBER_SIZE, GameMessage.BASEBALL_WIN_GAME);
            }
        }
    }

    public void end() {
        // 게임 종료
        MessagePrinter.printMessage(GameMessage.BASEBALL_RESTART);
        String input = Console.readLine();
        if (input.equals(GameMessage.RESTART)) {
            continueGame = true;
        }
        else if (input.equals(GameMessage.END)) {
            continueGame = false;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        MessagePrinter.printMessage(GameMessage.BASEBALL_START_GAME);
        while (continueGame) {
            this.game();
            this.end();
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
        String playerInput = this.getNumbersString();
        String[] split = playerInput.split("");

        List<Integer> playerNumbers = new ArrayList<>();
        for (String s : split) {
            int n;

            // 타입 변환 (String -> int)
            try {
                n = Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
            // 중복 숫자가 있을 경우
            if (playerNumbers.contains(n)) {
                throw new IllegalArgumentException();
            }
            // 1~9 범위를 벗어난 숫자일 경우
            if (n < NUMBER_RANGE_START || n > NUMBER_RANGE_END) {
                throw new IllegalArgumentException();
            }
            playerNumbers.add(n);
        }
        return playerNumbers;
    }

    private String getNumbersString() {
        MessagePrinter.printMessage(GameMessage.GET_NUMBER);
        String input = Console.readLine();

        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        return input;
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
