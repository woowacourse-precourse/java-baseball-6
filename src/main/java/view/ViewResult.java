package view;

/**
 * ViewResult.java
 * <p>
 * 입력에 대한 야구게임 결과 출력
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */

public class ViewResult {

    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int NUMBER_LENGTH = 3;

    public static void view(int[] result) {

        if (result[BALL] == 0 && result[STRIKE] == 0) {
            System.out.println("낫싱");
        } else if (result[STRIKE] == 0) {
            System.out.println(result[BALL] + "볼");
        } else if (result[BALL] == 0) {
            System.out.println(result[STRIKE] + "스트라이크");
        } else if (result[BALL] > 0 && result[STRIKE] > 0) {
            System.out.println(result[BALL] + "볼 " + result[STRIKE] + "스트라이크");
        }

        if (result[STRIKE] == NUMBER_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }

}
