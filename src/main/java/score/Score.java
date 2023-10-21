package score;

public class Score {

    private Integer score;

    public Score() {
        score = 0;
    }

    public Score(Integer score) {
        this.score = score;
    }

    public void plus() {
        score++;
    }

    public void clear() {
        score = 0;
    }

    public Integer getScore() {
        return score;
    }
}
