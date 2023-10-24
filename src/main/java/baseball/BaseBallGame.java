package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

            System.out.println(computer);

            while (true) {
                List<Integer> input = inputNumber();

                int[] result = compareAnswerInput(computer, input);

                boolean isAns = printResult(result);
                if (isAns) {
                    break;
                }
            }

            boolean isEnd = inputRestartOrEnd();
            if (isEnd) {
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
     * 숫자 입력 및 예외 처리
     *
     * @return List<Integer> 타입으로 변환된 입력값
     */
    private List<Integer> inputNumber() {

        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> input = stringToListInt(Console.readLine());

        inputErrorCheck(input);

        return input;

    }

    /**
     * 문자열을 List<Integer> 타입으로 변경
     *
     * @param str 사용자가 입력한 문자열
     * @return List<Integer>타입의 숫자
     */
    private List<Integer> stringToListInt(String str) {
        List<Integer> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (!(Character.isDigit(c))) {
                throw new IllegalArgumentException("숫자를 입력해 주세요");
            }

            int digit = Character.getNumericValue(c);
            list.add(digit);
        }
        return list;
    }

    /**
     * 숫자 input에 대한 유효성 확인
     * <p>
     * 3자리 숫자인가 / 중복되지 않았는가
     *
     * @param input 사용자가 입력한 숫자
     */
    private void inputErrorCheck(List<Integer> input) {

        if (input.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        Set<Integer> inputSet = new HashSet<>(input);
        if (inputSet.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }

        for (Integer num : input) {
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("유효한 숫자 범위가 아닙니다.");
            }
        }

    }

    /**
     * input값과 정답값을 비교해서 볼, 스트라이크 개수 계산
     *
     * @param ans   게임의 정답
     * @param input 사용자가 입력한 숫자
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
     * result 값 (볼, 스트라이크 갯수)에 다른 결과 출력
     *
     * @param result 볼, 스트라이크 수를 포함한 array
     * @return 정답 : true, 오답 : false
     */
    private boolean printResult(int[] result) {

        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "볼");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "스트라이크");
        } else if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }

        if (result[1] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    /**
     * 재시작 여부 입력 및 예외 처리
     *
     * @return 1(재시작) : false, 2(끝내기) : true
     */
    private boolean inputRestartOrEnd() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = stringToInt(Console.readLine());

        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("유효하지 않는 옵션 번호 입니다.");
        }

        return input != 1;

    }


    /**
     * 문자열을 int 타입으로 변경
     *
     * @param str 사용자가 입력한 문자열
     * @return int 타입으로 변환된 숫자
     */
    private int stringToInt(String str) {

        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }

        return num;

    }

}
