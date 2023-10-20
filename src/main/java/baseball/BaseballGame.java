package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static BaseballGame baseballGame;

    private BaseballGame() {
    }

    private static BaseballGame getInstance() {
        if (baseballGame == null) {
            baseballGame = new BaseballGame();
        }
        return baseballGame;
    }

    public static void start() {
        getInstance().play();
    }

    public void play() {
        List<Integer> computerNumber = setComputerNumber();

        boolean playing = true;
        while (playing) {
            List<Integer> myNumber = setMyNumber();

            Result result = compareNumber(computerNumber, myNumber);
            printResult(result);

            if (result.getStrike() == 3) {
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

        return MistakeChecker.checkAndMakeList(Console.readLine());
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

    private void printResult(Result result) {
        int ball = result.getBall();
        int strike = result.getStrike();

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
}
