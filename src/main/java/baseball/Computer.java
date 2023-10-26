package baseball;

public class Computer {
    private String number;

    public Computer(final String number) {
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public Result compareNumber(String inputNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < number.length(); i++) {
            if (isStrike(inputNumber, i)) strikeCount++;
            else if (isBall(String.valueOf(inputNumber.charAt(i)))) ballCount++;
        }

        return new Result(strikeCount, ballCount);
    }

    private boolean isStrike(String inputNumber, int index) {
        return inputNumber.charAt(index) == number.charAt(index);
    }

    private boolean isBall(String num) {
        return number.contains(num);
    }
}
