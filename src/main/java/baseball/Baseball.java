package baseball;

import java.util.List;

public class Baseball {
    final List<Integer> computerNumbers;
    final List<Integer> playerNumbers;
    int ball = 0;
    int strike = 0;
    String message;

    public Baseball(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    public void compare() {
        this.setStrikeBall(this.computerNumbers, this.playerNumbers);
        this.setMessage(this.ball, this.strike);
    }

    private void setStrikeBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            Integer computerNumber = computerNumbers.get(i);
            Integer playerNumber = playerNumbers.get(i);

            if (playerNumber.equals(computerNumber)) {
                this.strike += 1;
                continue;
            }

            if (playerNumbers.contains(computerNumber)) {
                this.ball += 1;
            }
        }
    }

    private void setMessage(int ball, int strike) {
        String ballMessage = ball != 0 ? ball + "볼" : "";
        String strikeMessage = strike != 0 ? strike + "스트라이크" : "";

        if (ball == 0 && strike == 0) {
            this.message = "낫싱";
            return;
        }

        if (ball != 0 && strike != 0) {
            this.message = ballMessage + " " + strikeMessage;
            return;
        }

        this.message = ballMessage + strikeMessage;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean getIsSuccess() {
        return this.strike == 3;
    }
}
