package baseball;

import baseball.global.GameMessage;
import baseball.model.GameResult;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;



public class BaseballGame implements Game {
    static final int NUMBER_RANGE_START = 1;
    static final int NUMBER_RANGE_END = 9;
    static final int NUMBER_SIZE = 3;

    private final List<Integer> numbers;
    private boolean continueGame = true;

    public BaseballGame() {
        numbers = new ArrayList<>();
    }
    private void start() {
        System.out.println(GameMessage.BASEBALL_START_GAME);
    }

    public void setting() {
        this.setComputerNumber();
    }

    public void game() {
        // 게임 반복
        boolean win = false;
        while (!win) {
            List<Integer> playerNumbers = getPlayerNumbers();
            GameResult result = compareInputWithComputerNumbers(playerNumbers);
            System.out.println(result.getMessage());
            if (result.isEnd(NUMBER_SIZE)) {
                System.out.println(NUMBER_SIZE + GameMessage.BASEBALL_WIN_GAME);
                win = true;
            }
        }
    }

    public void end() {
        System.out.println(GameMessage.BASEBALL_RESTART);
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

    public void execute() {
        this.start();
        
        while (continueGame) {
            this.setting();
            this.game();
            this.end();
        }
    }


    private void setComputerNumber() {
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
        System.out.println(GameMessage.GET_NUMBER);
        String input = Console.readLine();
        // 오버라이드 interface, abstract
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    private GameResult compareInputWithComputerNumbers(List<Integer> input) {
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
        return GameResult.from(strike, ball);
    }
}
