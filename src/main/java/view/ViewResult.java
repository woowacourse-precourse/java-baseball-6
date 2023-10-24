package view;

import static constant.Constants.NUMBER_LENGTH;

import vo.Result;

/**
 * ViewResult.java
 * <p>
 * 입력에 대한 야구게임 결과 출력
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */

public class ViewResult {


    public static void view(Result result) {

        if (result.ball() == 0 && result.strike() == 0) {
            System.out.println("낫싱");
        } else if (result.strike() == 0) {
            System.out.println(result.ball() + "볼");
        } else if (result.ball() == 0) {
            System.out.println(result.strike() + "스트라이크");
        } else if (result.ball() > 0 && result.strike() > 0) {
            System.out.println(result.ball() + "볼 " + result.strike() + "스트라이크");
        }

        if (result.strike() == NUMBER_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }

}
