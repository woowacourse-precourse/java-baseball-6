package baseball;

import java.util.List;
import model.ModelCreateRandomNumber;
import model.ModelUserNumCheck;
import view.ViewInput;
import view.ViewResult;
import view.ViewStart;

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

        ViewStart.view();

        while (true) {

            List<Integer> computer = ModelCreateRandomNumber.createRandomNumber();

            System.out.println(computer);

            while (true) {

                List<Integer> input = ModelUserNumCheck.changeToComparable(ViewInput.numInputView());

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

        ViewResult.view(result);

        return result[1] == 3;
    }

    /**
     * 재시작 여부 입력 및 예외 처리
     *
     * @return 1(재시작) : false, 2(끝내기) : true
     */
    private boolean inputRestartOrEnd() {

        int input = stringToInt(ViewInput.restartOrEndInputView());

        inputErrorCheck(input);

        return input != 1;

    }

    /**
     * 문자열을 int 타입으로 변경
     *
     * @param str 사용자가 입력한 문자열
     * @return int 타입으로 변환된 숫자
     */
    private int stringToInt(String str) {

        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            errorThrow("notNum");
        }

        return num;

    }

    /**
     * 재시작 여부 input에 대한 유효성 확인
     * <p>
     * 유효한 숫자인가?
     *
     * @param input 사용자가 입력한 숫자
     */
    private void inputErrorCheck(int input) {

        if (input != 1 && input != 2) {
            errorThrow("invalidNum");
        }

    }

    /**
     * 예외에 따른 메세지 설정 및 예외 던지기
     *
     * @param str 예외 이유
     */
    public static void errorThrow(String str) {

        String message = switch (str) {
            case "notNum" -> "숫자를 입력해 주세요";
            case "wrongLen" -> "3자리 숫자가 아닙니다.";
            case "duplicate" -> "중복된 숫자가 존재합니다.";
            case "invalidNum" -> "유효한 숫자가 아닙니다.";
            default -> "";
        };

        throw new IllegalArgumentException(message);
    }
}
