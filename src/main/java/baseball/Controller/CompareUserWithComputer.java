package baseball.Controller;

public class CompareUserWithComputer {
    private String userNumber;
    private String computerNumber;

    private int strikeNum;
    private int ballNum;

    public CompareUserWithComputer(String userNumber, String computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public int getBallNum() {
        return ballNum;
    }

    public void countStrikeNum() {
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                this.strikeNum++;
            }
        }
    }

    public void countBallNum() {
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) != computerNumber.charAt(i) && computerNumber.contains(
                    String.valueOf(userNumber.charAt(i)))) {
                this.ballNum++;
            }
        }
    }
}
