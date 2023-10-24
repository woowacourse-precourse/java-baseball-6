package model;

/**
 * ModelRestartOrEnd.java
 * <p>
 * 재시작 여부 관련 모델
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */

public class ModelRestartOrEnd {

    /**
     * 재시작 여부 입력값 이용해 결과 출력
     *
     * @return 1(재시작) : false, 2(끝내기) : true
     */
    public static boolean isEnd(String str) {

        int input = stringToInt(str);

        inputErrorCheck(input);

        return input != 1;

    }

    /**
     * 문자열을 int 타입으로 변경
     *
     * @param str 사용자가 입력한 문자열
     * @return int 타입으로 변환된 숫자
     */
    private static int stringToInt(String str) {

        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            ModelErrorThrow.errorThrow("notNum");
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
    private static void inputErrorCheck(int input) {

        if (input != 1 && input != 2) {
            ModelErrorThrow.errorThrow("invalidNum");
        }

    }

}
