package error;

import static error.ErrorConstant.EXIT_CORRECT_LENGTH;
import static error.ErrorConstant.EXIT_LENGTH_ERROR;
import static error.ErrorConstant.INCORRECT_NUMBER;
import static error.ErrorConstant.INPUT_CORRECT_LENGTH;
import static error.ErrorConstant.INPUT_LENGTH_ERROR;
import static error.ErrorConstant.NOT_NUMBER;
import static error.ErrorConstant.SAME_NUMBER;
import static runGame.constant.EXIT_NUMBER;
import static runGame.constant.RESTART_NUMBER;

import java.util.HashSet;

/*
 * 클래스 이름 : ErrorManage
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-10-22
 *
 * 작성자 : 문재경
 */
public class ErrorManage {

    /*
     * 유저가 입력한 user_number에 따라 길이, 숫자, 서로 다른 수인지 판별해주고 오류를 던지는 메서드
     *
     * @param user_number
     * @return void
     */
    public void userNumberErrorManage(String user_number) {
        if (isCorrectLength(user_number)) {
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR);
        }
        if (!isNumeric(user_number)) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
        if (!hasUniqueDigits(user_number)) {
            throw new IllegalArgumentException(SAME_NUMBER);
        }
    }

    /*
     * 유저가 입력한 exit_number에 따라 길이, 올바른 수인지 판별해주고 오류를 던지는 메서드
     *
     * @param exit_number
     * @return void
     */
    public void exitNumberErrorManage(String exit_number) {
        if (isCorrectLength(exit_number)) {
            throw new IllegalArgumentException(EXIT_LENGTH_ERROR);
        }
        if (isRestartOrExit(exit_number)) {
            throw new IllegalArgumentException(INCORRECT_NUMBER);
        }

    }

    /*
     * 유저가 입력한 exit_number가 재시작 수 또는 종료 수 와 일치하는지 return 해주는 메서드
     *
     * @param exit_number
     * @return true | false
     */
    private boolean isRestartOrExit(String exit_number) {
        return (!exit_number.equals(RESTART_NUMBER) && !exit_number.equals(EXIT_NUMBER));
    }


    /*
     * 유저가 입력한 exit 혹은 user 넘버의 길이가 올바른지 판단해주는 메서드
     *
     * @param input_number
     * @return true | false
     */
    private boolean isCorrectLength(String input_number) {
        return (input_number.length() != INPUT_CORRECT_LENGTH && input_number.length() != EXIT_CORRECT_LENGTH);
    }

    /*
     * 유저가 입력한 user_number 가 숫자인지 판단해주는 메서드
     *
     * @param user_number
     * @return true | false
     */
    private boolean isNumeric(String user_number) {
        return user_number.matches("\\d+");
    }

    /*
     * 유저가 입력한 user_number 가 서로 다른 숫자인지 판단해주는 메서드
     *
     * @param user_number
     * @return true | false
     */
    private boolean hasUniqueDigits(String user_number) {
        HashSet<Character> uniqueDigits = new HashSet<>();
        for (char c : user_number.toCharArray()) {
            if (uniqueDigits.contains(c)) {
                return false;
            }
            uniqueDigits.add(c);
        }
        return true;
    }
}
