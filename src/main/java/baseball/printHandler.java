package baseball;

public class printHandler {
    public static void gameStartPrint(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameEndPrint(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void choiceEndOrRePrint(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void baseballPrint(int ball, int strike) {
        if (strike == 3) {
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if ((ball > 0) && (strike > 0)) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if ((ball > 0) && (strike == 0)) {
            System.out.println(ball + "볼");
        } else if ((ball == 0) && (strike > 0)) {
            System.out.println(strike + "스트라이크");
        } else if ((ball == 0) && (strike == 0)) {
            System.out.println("낫싱");
        }
    }
}
