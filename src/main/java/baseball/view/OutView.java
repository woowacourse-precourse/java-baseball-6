package baseball.view;

public class OutView {

    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printResult(Integer strikeCount, Integer ballCount) {
        // count가 0일때는 출력 X
        if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }
        else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        else if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public static void printDuplicatedInput() {
        System.out.println("이전 입력과 중복됩니다.");
    }
}
