package baseball.utils;

public class Printer {
    public static void printGameResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
    }
    public static void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameEnd(){
        System.out.println("게임이 종료됩니다.");
    }
    public static void printCorrect(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
