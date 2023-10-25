package baseball;

public class Output {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printScoreMessage(String score) {
        System.out.println(score);
    }

    public static void printWinMessage() {
        System.out.println("3개의 숫자를 모두 맞회셨습니다! 게임 종료");
    }

    public static void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
