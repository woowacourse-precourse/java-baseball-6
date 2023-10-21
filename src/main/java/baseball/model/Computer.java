package baseball.model;

public class Computer {
    private final ComputerNumber computerNumber;

    public Computer() {
        computerNumber = new ComputerNumber();
    }

    public int getNumbersLength() {
        return computerNumber.getSize();
    }

    public boolean hasDuplicatedNumber() {
        return computerNumber.hasDuplicatedNumber();
    }

    public int getNumberByPosition(int position) {
        return computerNumber.getNumberByPosition(position);
    }

    public boolean hasNumber(int number) {
        return computerNumber.hasNumber(number);
    }

}
