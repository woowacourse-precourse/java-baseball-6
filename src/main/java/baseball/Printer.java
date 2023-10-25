package baseball;

public class Printer {
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printReplayMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printGuessNumMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printScore(BaseballForm result) {
        Boolean isAnyStrike = !(result.getNumberOfStrikes().equals(0));
        Boolean isAnyBall = !(result.getNumberOfBalls().equals(0));
        Boolean isCorrect = result.getCorrect();
        Boolean isNothing = result.getNothing();

        if (isNothing) {
            System.out.print("낫싱");
        }
        if (isAnyBall) {
            System.out.print(result.getNumberOfBalls() + "볼");
        }
        if (isAnyStrike) {
            if (isAnyBall) {
                System.out.print(" ");
            }
            System.out.print(result.getNumberOfStrikes() + "스트라이크");
        }
        if (isCorrect) {
            System.out.println();
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.println();
    }

}
