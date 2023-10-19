package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void printInitialGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void printHint(String hint) {
        System.out.println(hint);
    }

    private static void printNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
