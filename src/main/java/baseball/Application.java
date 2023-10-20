package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static Integer LENGTH = 3;

    private enum RESULT_CODE {
        STRIKE(0, "스트라이크"), BALL(1, "볼"), MISS(2, "낫싱");
        private int value;
        private String title;

        RESULT_CODE(int value, String title) {
            this.value = value;
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // TODO: 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
        List<Integer> computer = generateRandomNumber(LENGTH);

        // TODO: 입력값에 따라 처리
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            List<Integer> user = convert(input, LENGTH);

            int[] result = compare(computer, user);

            if (result[0] == LENGTH) {
                break;
            }
        }

        // TODO: 게임 종료
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
        if (string.length() > limit || string.indexOf("0") > -1) {
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
                result[RESULT_CODE.STRIKE.value]++;
            } else if (miss.indexOf(user.get(i)) > -1) {
                result[RESULT_CODE.BALL.value]++;
                miss.remove(user.get(i));
            } else {
                miss.add(user.get(i));
            }
        }

        result[RESULT_CODE.MISS.value] = miss.size();
        return result;
    }
}

