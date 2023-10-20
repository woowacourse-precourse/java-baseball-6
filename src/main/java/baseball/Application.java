package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static Integer LENGTH = 3;

    public static void main(String[] args) {
        // TODO: 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
        List<Integer> computer = generateRandomNumber(LENGTH);

        // TODO: 입력값에 따라 처리
        while (true) {
            String input = readLine();
            List<Integer> user = convert(input, LENGTH);
            int[] result = compare(computer, user);
            if(result[0] == LENGTH) break;
        }
    }

    private static List<Integer> generateRandomNumber(Integer length) {
        List<Integer> result = new ArrayList<>();
        while (result.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    private static List<Integer> convert(String string, Integer limit) {
        if (string.length() > limit || string.indexOf("0") < 0) {
            throw new IllegalArgumentException();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            try {
                Integer temp = Integer.parseInt(String.valueOf(string.charAt(i)));
                result.add(temp);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return result;
    }

    private static int[] compare(List<Integer> computer, List<Integer> user) {
        int[] result = new int[3];

        List<Integer> miss = new ArrayList<>();
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                result[0]++;
            } else if (miss.indexOf(user.get(i)) > -1) {
                result[1]++;
                miss.remove(user.get(i));
            } else {
                miss.add(user.get(i));
            }
        }

        result[2] = miss.size();
        return result;
    }
}

