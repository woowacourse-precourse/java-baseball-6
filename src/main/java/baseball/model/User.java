package baseball.model;

public class User implements Player{
    private int score = 0;
    private String number ;
    @Override
    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String getNumber() {
        return number;
    }
    @Override
    public int addScore() {
        return score++;
    }
    @Override
    public int getScore() {
        return score;
    }
}
