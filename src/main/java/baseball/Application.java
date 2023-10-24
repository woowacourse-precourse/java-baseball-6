package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int num = generateRandomNumber();
        List<Integer> integers = parseDigits(num);


    }

    private static int generateRandomNumber() {
        int result = 0;

        // 중복 되지 않은 3개의 수 무작위 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        result = listToInt(computer);

        return result;
    }

    /**
     * number = 123
     * return = [1, 2, 3]
     */
    private static List<Integer> parseDigits(int number) {
        List<Integer> result = new ArrayList<>();

        int tmpNumber = number;

        while (tmpNumber > 0) {
            result.add(tmpNumber % 10);
            tmpNumber = tmpNumber / 10;
        }

        Collections.reverse(result);

        return result;
    }

    /**
     * list = [1, 2, 3]
     * return = 123
     */
    private static int listToInt(List<Integer> integers) {
        int result = 0;

        for (int i=0; i<integers.size(); i++) {
            result = result * 10 + integers.get(i);
        }

        return result;
    }

}
