package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    @Override
    public String toString() {
        return "Computer{" +
                "Number=" + Number +
                '}';
    }

    private List<Integer> Number = new ArrayList<>(3);

    // Constructor Set Random value
    public Computer() {
        this.setNumber();
    }

    // Set Random Number If New Game Start.
    public void setNumber() {

        // Reset Array For Random
        Number = Arrays.asList(0, 0, 0);

        // Generate Random Value
        for (int numberIdx = 0; numberIdx < 3; numberIdx++) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (this.Number.contains(randomNumber));
            this.Number.set(numberIdx, randomNumber);
        }
    }


    public BaseballResult compareNumber(List<Integer> Human) {
        int strikeBall = 0;

        BaseballResult baseballResult;
        for (int computerIdx = 0; computerIdx < 3; computerIdx++) {
            for (int humanIdx = 0; humanIdx < 3; humanIdx++) {
                if (this.Number.get(computerIdx).equals(Human.get(humanIdx))) {
                    if (computerIdx == humanIdx) {
                        strikeBall += 10;
                        break;
                    }
                    strikeBall++;
                    break;
                }
            }
        }
        baseballResult = setBaseballResult(strikeBall);
        printType(strikeBall);
        return baseballResult;
    }

    private BaseballResult setBaseballResult(int strikeBall) {
        BaseballResult baseballResult = null;
        switch (strikeBall) {
            case (0) -> baseballResult = BaseballResult.NOTHING;
            case (1) -> baseballResult = BaseballResult.B1;
            case (2) -> baseballResult = BaseballResult.B2;
            case (3) -> baseballResult = BaseballResult.B3;
            case (10) -> baseballResult = BaseballResult.S1;
            case (11) -> baseballResult = BaseballResult.B1S1;
            case (20) -> baseballResult = BaseballResult.S2;
            case (30) -> baseballResult = BaseballResult.S3;
            default -> {
            }
        }
        return baseballResult;
    }

    private void printType(int strikeBall) {
        if (strikeBall == 0) {
            System.out.println("낫싱");
        } else if (strikeBall < 10) {
            System.out.println(strikeBall + "볼");
        } else if (strikeBall % 10 == 0) {
            System.out.println(strikeBall / 10 + "스트라이크");
        } else {
            System.out.println(strikeBall % 10 + "볼 " + strikeBall / 10 + "스트라이크");
        }
    }
}
