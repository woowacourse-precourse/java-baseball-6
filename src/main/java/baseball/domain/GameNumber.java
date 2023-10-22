package baseball.domain;

public class GameNumber {

    private final InputNumber inputNumber;
    private final RandomNumber randomNumber;

    public GameNumber(RandomNumber randomNumber, InputNumber inputNumber) {
        this.randomNumber = randomNumber;
        this.inputNumber = inputNumber;
    }

    public boolean isStrike(int index) {
        Integer randomNumAtIdx = randomNumber.getNumberAtIndex(index);
        Integer inputNumAtIdx = inputNumber.getNumberAtIndex(index);

        return inputNumAtIdx.equals(randomNumAtIdx);
    }

    public boolean isBall(int index) {
        Integer randomNumAtIdx = randomNumber.getNumberAtIndex(index);
        Integer inputNumAtIdx = inputNumber.getNumberAtIndex(index);

        return randomNumber.numberExistsInList(inputNumAtIdx) &&
                !randomNumAtIdx.equals(inputNumAtIdx);
    }
}
