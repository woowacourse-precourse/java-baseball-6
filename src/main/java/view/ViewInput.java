package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * ViewInput.java
 * <p>
 * input 관련 문구 출력
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */

public class ViewInput {

    /**
     * 숫자 입력 문구 출력 및 값 받아오기
     *
     * @return 입력 받은 문자열 반환
     */
    public static String numInputView() {

        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();

    }

    /**
     * 재시작 여부 입력 문구 출력 및 값 받아오기
     *
     * @return 입력 받은 문자열 반환
     */
    public static String restartOrEndInputView() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return Console.readLine();

    }
}
