package baseball.model;

public class Computer implements Player{
    private String number;
    @Override
    public void setNumber(String value) {
        this.number = value;
    }
    @Override
    public String getNumber(){
        return number;
    }
}
