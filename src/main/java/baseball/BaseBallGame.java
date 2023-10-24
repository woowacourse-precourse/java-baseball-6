package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseBallGame.java
 * <p>
 * 야구게임이 수행될 메인 부분
 *
 * @author Lee NaYeon
 * @since 2023-10-24
 */

public class BaseBallGame {

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            List<Integer> computer = createRandomNumber();

            while (true) {

                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> input = stringToListInt(Console.readLine());

                int[] result = compareAnswerInput(computer, input);

                printResult(result);

                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int option = Integer.parseInt(Console.readLine());

            if (option == 2) {
                break;
            }

        }

    }


    /**
     * 3자리 난수 생성
     *
     * @return List<Integer> 타입의 3자리 난수
     */
    private List<Integer> createRandomNumber() {

        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }

    /**
     * 문자열을 List<Integer> 타입으로 변경
     *
     * @param str
     * @return List<Integer>타입의 숫자
     */
    private List<Integer> stringToListInt(String str) {
        List<Integer> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                list.add(digit);
            }
        }
        return list;
    }

    /**
     * input값과 정답값을 비교해서 볼, 스트라이크 개수 계산
     *
     * @param ans
     * @param input
     * @return int[] 타입의 비교 결과 (index 0 : 볼, 1 : 스트라이크)
     */
    private int[] compareAnswerInput(List<Integer> ans, List<Integer> input) {

        int[] result = {0, 0};

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).equals(input.get(i))) {
                result[1]++;
            } else if (ans.contains(input.get(i))) {
                result[0]++;
            }
        }

        return result;

    }

    /**
     * result 값 (볼, 스트라이크 갯수)데 다른 결과 출력
     *
     * @param result
     */
    private void printResult(int[] result) {

        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "볼");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "스트라이크");
        } else if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }

    }

}
