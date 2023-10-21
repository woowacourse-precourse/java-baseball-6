package baseball.view;

public class View {

    public static void askNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void askOneOrTwo() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void showOpening() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void showClosing() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    public static void showResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
