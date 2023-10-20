package baseball.view;

import baseball.domain.Result;

public class OutputHandler {
    public static void theGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printStrikesAndBalls(Result forPrint) {
        String stringForPrint = "";
        if (forPrint.numberOfBalls > 0) {
            stringForPrint += forPrint.numberOfBalls + "볼 ";
        }
        if (forPrint.numberOfStrikes > 0) {
            stringForPrint += forPrint.numberOfStrikes + "스트라이크";
        }
        System.out.println(stringForPrint);
    }

    public static void printAllStrike() {
        System.out.println("3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
