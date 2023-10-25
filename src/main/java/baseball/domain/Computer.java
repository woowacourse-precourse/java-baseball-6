package baseball.domain;

public class Computer {

    private Number number;

    public Computer() {
        this.number = new Number();
    }

    public Number getNumber() {
        return number;
    }

    public void createNewGameNumber(){
        this.number = new Number();
    }
}
