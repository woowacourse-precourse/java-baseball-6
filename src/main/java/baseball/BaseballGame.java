package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int NUMBER_SIZE = 3;
    private final List<Integer> numbers;
    private boolean continueGame = true;

    public BaseballGame() {
        numbers = new ArrayList<>();
        setNumber();
    }

    public void game() {
        setNumber();
        boolean win = false;
        while (!win) {
            List<Integer> playerNumbers = getPlayerNumbers();
            String result = compareInputAndNumbers(playerNumbers);
            System.out.println(result);
            if (result.contains(NUMBER_SIZE + BaseballJudgement.STRIKE.message)) {
                win = true;
                System.out.println(NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (continueGame) {
            this.game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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

    private void setNumber(){
        numbers.clear();
        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    private List<Integer> getPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
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
            if (n < START_NUMBER || n > END_NUMBER) {
                throw new IllegalArgumentException();
            }
            playerNumbers.add(n);
        }
        return playerNumbers;
    }

    private String compareInputAndNumbers(List<Integer> input) {
        int ball = 0;
        int strike = 0;
        // 포함하고 있는지 검사 => 볼 개수
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

        // 동적으로 추가하기
        StringBuilder sb = new StringBuilder();
        if (ball + strike == 0)
            return BaseballJudgement.NOTHING.message;
        if (ball > 0) {
            sb.append(ball).append(BaseballJudgement.BALL.message).append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append(BaseballJudgement.STRIKE.message).append(" ");
        }
        return sb.toString();
    }
}
