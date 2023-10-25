package baseball.utils;

public class BaseballGamePrinterUtils {

    public static void announceStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printAskStartNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void announcePlayerWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void askPlayerTargetNums() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void announceGameResult(int ballCount, int strikeCount) {
        String announceText = "";
        if (ballCount > 0) {
            announceText += ballCount + "볼";
        }
        if (strikeCount > 0) {
            if (announceText.length() > 0) {
                announceText += " ";
            }
            announceText += strikeCount + "스트라이크";
        }
        if (ballCount == 0 && strikeCount == 0) {
            announceText = "낫싱";
        }
        System.out.println(announceText);
    }
}
