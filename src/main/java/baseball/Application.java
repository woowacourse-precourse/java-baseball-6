package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        Application app = new Application();
        Baseball baseball = new Baseball();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isEnd = false;
        while (!isEnd) {
            /* 게임 실행 */
            baseball.start();

            /* 종료 의사 확인 */
            isEnd = app.isEnd();
        }
        System.out.println("프로그램을 종료합니다.");
    }



    /* 종료 의사 확인 */
    public boolean isEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endInput = readLine();
        isValidateEnd(endInput);
        if (endInput.equals("1")){
            return false;
        }
        return true;
    }

    public static void isValidateEnd(String input){
        if (input.equals("1") || input.equals("2")){
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    /* -------------------- */

}
