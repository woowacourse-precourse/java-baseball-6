package baseball.model;

public class Computer {
    ComputerNumber computerNumber;

    public Computer() {
        computerNumber = new ComputerNumber();
    }

    public int getNumbersLength() {
        return computerNumber.getSize();
    }

    public boolean hasDuplicatedNumber() {
        return computerNumber.hasDuplicatedNumber();
    }

}
