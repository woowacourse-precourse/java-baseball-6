package baseball.view;

import baseball.model.BaseballInformation;

public class Output {

    private static final Output output = new Output();

    private Output() {
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printGameEndMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printHint(BaseballInformation baseballInformation) {
        int strikeCount = baseballInformation.getStrikeCount();
        int ballCount = baseballInformation.getBallCount();

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.printf("%d스트라이크\n", strikeCount);
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.printf("%d볼\n", ballCount);
        }
    }

}
