package baseball;

public class Output {
    public void printHint(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
