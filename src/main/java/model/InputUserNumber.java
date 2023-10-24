/*
 * <pre>
 * Class : InputUserNumber
 * Comment: 사용자로부터 숫자를 입력받기
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * 2023-10-24       손준형           예외 처리 로직 변경
 * 2023-10-24       손준형           매직 넘버 상수 대체
 * 2023-10-24       손준형           유효 처리 메서드 분리
 * </pre>
 *
 * @author 손준형
 * @version 1.1.2
 * @see
 */

package model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import vo.UserBall;

public class InputUserNumber {
    public static final int NUMBER_SIZE = 3;
    public static final int MIN_ASCII_CODE = 49;
    public static final int MAX_ASCII_CODE = 57;

    public static void checkLengthException(int length){
        if(length != NUMBER_SIZE){
            throw new IllegalArgumentException();
        }
    }

    public static void checkValidNumberException(List<Integer> userNumber, int inputNumber){
        if (inputNumber < MIN_ASCII_CODE || inputNumber > MAX_ASCII_CODE) {
            throw new IllegalArgumentException();
        }
        if (userNumber.contains(inputNumber - '0')){
            throw new IllegalArgumentException();
        }
    }

    public static UserBall inputUserNumber() {
        String input = Console.readLine();

        checkLengthException(input.length());

        List<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int inputNumber = input.charAt(i);
            checkValidNumberException(userNumber, inputNumber);
            userNumber.add(inputNumber - '0');
        }

        return new UserBall(userNumber);
    }
}
