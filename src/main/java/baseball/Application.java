package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static Integer LENGTH = 3;

    private enum RESULT_CODE {
        BALL(0, "볼"), STRIKE(1, "스트라이크"), MISS(2, "낫싱");
        private int value;
        private String title;

        RESULT_CODE(int value, String title) {
            this.value = value;
            this.title = title;
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // TODO: 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
            List<Integer> computer = generateRandomNumber(LENGTH);

            // TODO: 입력값에 따라 처리
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = readLine();
                List<Integer> user = convert(input, LENGTH);

                int[] result = compare(computer, user);
                printResult(result);

                if (result[RESULT_CODE.STRIKE.value] == LENGTH) {
                    break;
                }
            }

            // TODO: 게임 종료
            System.out.println(LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = readLine();
            if (input.equals("2")) {
                break;
            } else if (!input.equals("1")) {
                throw new IllegalArgumentException();
            }
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
        if (string.length() > limit || string.indexOf("0") > -1) {
            throw new IllegalArgumentException();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '1' && string.charAt(i) <= '9'
                    && result.indexOf(Integer.parseInt(String.valueOf(string.charAt(i)))) < 0) {
                result.add(Integer.parseInt(String.valueOf(string.charAt(i))));
            } else {
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
            } else {
                if (computer.indexOf(user.get(i)) > -1) {
                    result[RESULT_CODE.BALL.value]++;
                } else {
                    miss.add(user.get(i));
                }
            }
        }

        result[RESULT_CODE.MISS.value] = miss.size();
        return result;
    }

    private static void printResult(int[] result) {
        List<String> print = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (result[i] > 0) {
                if (RESULT_CODE.BALL.value == i) {
                    print.add(result[i] + RESULT_CODE.BALL.title);
                } else if (RESULT_CODE.STRIKE.value == i) {
                    print.add(result[i] + RESULT_CODE.STRIKE.title);
                }
            }
        }

        if (print.size() < 1) {
            print.add("낫싱");
        }
        System.out.println(String.join(" ", print));
    }
}