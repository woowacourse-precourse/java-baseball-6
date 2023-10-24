/*
 * <pre>
 * Class : InputView
 * Comment: 사용자로부터 숫자를 입력받는 뷰
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * 2023-10-23       손준형           예외 처리 추가
 * 2023-10-23       손준형           매직넘버 상수 대체
 * 2023-10-23       손준형           사용자 입력 로직 분리
 * </pre>
 *
 * @author 손준형
 * @version 1.1.3
 * @see
 */


package view;

import model.InputUserNumber;
import vo.UserBall;

public class InputView {

    public static UserBall userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return InputUserNumber.inputUserNumber();
    }
}
