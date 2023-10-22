package baseball.model;

public class User implements Player{
    private String number ;
    @Override
    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String getNumber() {
        return number;
    }
}
