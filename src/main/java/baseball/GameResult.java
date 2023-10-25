package baseball;

public record GameResult(
        int strikeCount,
        int ballCount,
        boolean isCorrectAnswer
) {
    public void announce() {
        if (isCorrectAnswer) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }

        if (ballCount > 0) {
            System.out.print(ballCount + "볼");
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
    }
}
