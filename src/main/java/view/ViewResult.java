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

    public static void view(int[] result) {

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
        }

    }

}
