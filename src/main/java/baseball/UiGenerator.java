package baseball;

public class UiGenerator {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRequestUserPrediction() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printEndCurrentGameAndAskNewGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printStrikeBall(GuessStatus guessStatus) {
        if (guessStatus.isNoting()) {
            System.out.println("낫싱");
            return;
        }
        
        int strike = guessStatus.getStrike();
        int ball = guessStatus.getBall();
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
    }
}
