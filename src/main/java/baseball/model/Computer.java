package baseball.model;

public class Computer implements Player{
    private int score = 0;
    private String number;
    @Override
    public void setNumber(String value) {
        this.number = value;
    }
    public String getNumber(){
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
    @Override
    public String toString() {
        return "Computer{" +
                "value='" + number + '\'' +
                '}';
    }
}
