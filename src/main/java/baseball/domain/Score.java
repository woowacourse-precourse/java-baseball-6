package baseball.domain;

public class Score {
    private int strikeScore;
    private int ballScore;

    public Score(int strikeScore, int ballScore) {
        this.strikeScore = strikeScore;
        this.ballScore = ballScore;
    }

    //세터를 public으로 만드는건 너무 위험함.
    public String getScoreOutput() {
        if (isNothing()) {
            return "낫싱";
        }
        //아니라면
        return strikeAndBallScoreOutput();
    }

    private boolean isNothing() {
        return (strikeScore == 0 && ballScore == 0);
    }

    private String strikeAndBallScoreOutput() {
        String ballOutput = ballScoreToString();
        String strikeOutput = strikeScoreToString();

        if (ballOutput.length() != 0 && strikeOutput.length() != 0) {
            return ballOutput + " " + strikeOutput;
        }
        return ballOutput + strikeOutput;
    }

    private String strikeScoreToString() {
        if (strikeScore == 0) {
            return "";
        }
        return strikeScore + "스트라이크";
    }

    private String ballScoreToString() {
        if (ballScore == 0) {
            return "";
        }
        return ballScore + "볼";
    }

}
