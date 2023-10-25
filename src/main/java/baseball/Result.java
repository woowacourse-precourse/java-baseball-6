package baseball;

public class Result {

    private boolean correct;
    private String message;

    public boolean isCorrect() {
        return correct;
    }

    public String getMessage() {
        return message;
    }

    public void setResult(Game game) {
        if (game.getNumberOfStrike() == 3 && game.getNumberOfBall() == 0) {
            this.message = "3스트라이크\n3개 숫자를 모두 맞히셨습니다! 게임 종료";
            this.correct = true;
            return;
        }

        if (game.getNumberOfStrike() == 0 && game.getNumberOfBall() == 0) {
            this.message = "낫싱\n";
            this.correct = false;
            return;
        }

        if (game.getNumberOfStrike() == 0) {
            this.message = game.getNumberOfBall() + "볼\n";
            this.correct = false;
            return;
        }

        if (game.getNumberOfBall() == 0) {
            this.message = game.getNumberOfStrike() + "스트라이크\n";
            this.correct = false;
            return;
        }

        this.message = game.getNumberOfBall() + "볼 " + game.getNumberOfStrike() + "스트라이크\n";
        this.correct = false;
    }

}
