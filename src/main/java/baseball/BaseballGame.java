package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private static BaseballGame baseballGame;

    private BaseballGame() {
    }

    public static void start() {
        getInstance().play();
    }

    private static BaseballGame getInstance() {
        if (baseballGame == null) {
            baseballGame = new BaseballGame();
        }
        return baseballGame;
    }

    public void play() {
        List<Integer> computerNumber = setComputerNumber();

        boolean playing = true;
        while (playing) {
            List<Integer> myNumber = setMyNumber();

            Result result = compareNumber(computerNumber, myNumber);

            int ball = result.getBall();
            int strike = result.getStrike();
            printResult(ball, strike);

            if (strike == 3) {
                playing = false;
            }
        }
    }

    private List<Integer> setComputerNumber() {
        List<Integer> computer = new ArrayList<>(3);
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private List<Integer> setMyNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> numberList;
        try {
            numberList = Arrays.stream(Console.readLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        List<Integer> distinctList = numberList.stream().distinct().collect(Collectors.toList());
        if (distinctList.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }

        if (numberList.size() != 3 || numberList.contains(0)) {
            throw new IllegalArgumentException("1 ~ 9 사이 3개의 숫자를 입력해주세요.");
        }

        return numberList;
    }

    private Result compareNumber(List<Integer> computerNumber, List<Integer> myNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerNumber.get(i) == myNumber.get(j)) {
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }

        return new Result(ball, strike);
    }

    private void printResult(int ball, int strike) {
        StringBuilder sb = new StringBuilder();

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        if (ball != 0) {
            sb.append(ball + "볼 ");
        }
        if (strike != 0) {
            sb.append(strike + "스트라이크");
        }

        System.out.println(sb);
    }

    static class Result {

        private int ball;
        private int strike;

        public Result(int ball, int strike) {
            this.ball = ball;
            this.strike = strike;
        }

        public int getBall() {
            return ball;
        }

        public int getStrike() {
            return strike;
        }
    }
}
