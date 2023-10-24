package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public static Integer LENGTH = 3;
    private List<Integer> randomNumber;
    private int[] result;

    public Game() {
        this.randomNumber = generateRandomNumber(LENGTH);
    }

    private List<Integer> generateRandomNumber(Integer length) {
        List<Integer> result = new ArrayList<>();
        while (result.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    void compare(List<Integer> user) {
        int[] result = new int[3];

        List<Integer> miss = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++) {
            if (randomNumber.get(i) == user.get(i)) {
                result[ResultCode.STRIKE.value]++;
            } else {
                if (randomNumber.indexOf(user.get(i)) > -1) {
                    result[ResultCode.BALL.value]++;
                } else {
                    miss.add(user.get(i));
                }
            }
        }

        result[ResultCode.MISS.value] = miss.size();
        this.result = result;
    }

    void printResult() {
        List<String> print = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (result[i] > 0) {
                if (ResultCode.BALL.value == i) {
                    print.add(result[i] + ResultCode.BALL.title);
                } else if (ResultCode.STRIKE.value == i) {
                    print.add(result[i] + ResultCode.STRIKE.title);
                }
            }
        }

        if (print.size() < 1) {
            print.add("낫싱");
        }
        System.out.println(String.join(" ", print));
    }

    boolean isOver() {
        return result[ResultCode.STRIKE.value] == LENGTH;
    }
}
