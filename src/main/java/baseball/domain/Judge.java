package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Judge {
    public boolean judgeGameResult(List<Integer> computer, List<Integer> inputNumber) {
        int strikes = getStrikesCount(computer, inputNumber);
        int balls = getBallsCount(computer, inputNumber);

        if (strikes > 0 && balls > 0) {
            System.out.println(balls + "볼" + " " + strikes + "스트라이크");
        } else if (strikes > 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls > 0) {
            System.out.println(balls + "볼");
        } else if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }

        if (strikes == 3) {
            return true;
        }

        return false;
    }

    private int getStrikesCount(List<Integer> computer, List<Integer> inputNumber) {
        return (int) IntStream.range(0, computer.size())
                .filter(i -> computer.get(i).equals(inputNumber.get(i)))
                .count();
    }

    private int getBallsCount(List<Integer> computer, List<Integer> inputNumber) {
        return (int) IntStream.range(0, computer.size())
                .filter(i -> !computer.get(i).equals(inputNumber.get(i))
                        && computer.contains(inputNumber.get(i)))
                .count();
    }
}
