package baseball.domain;

public class GameNumberSet {

    public static final int NUMBER_LENGTH = 3;

    private final InputNumber inputNumber;
    private final RandomNumber randomNumber;

    public GameNumberSet(RandomNumber randomNumber, InputNumber inputNumber) {
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
