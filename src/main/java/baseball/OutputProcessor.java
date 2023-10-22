package baseball;

public class OutputProcessor {
    public static void printExitMessage() {
        System.out.println("게임을 끝냅니다.");
    }

    public static void printCompleteMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printPitchInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printScore(Score score) {
        if (score.getBall() == 0 && score.getStrike() == 0) {
            System.out.println("낫싱");
            return;
        }
        if (score.getBall() > 0) {
            System.out.print(score.getBall() + "볼 ");
        }
        if (score.getStrike() > 0) {
            System.out.print(score.getStrike() + "스트라이크");
        }
        System.out.println();
    }

}
