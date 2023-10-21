package baseball.view;

public class InputView {
    public static void firstStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String startInput() {
        System.out.println("숫자를 입력해주세요 : ");
        return System.console().readLine();
    }

    public static String endInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return System.console().readLine();
    }

}
