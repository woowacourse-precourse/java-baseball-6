package baseball;

public class CheckException {
    public void checkRestart(int isRe) {
        if (!(isRe == 1 || isRe == 2))
            throw new IllegalArgumentException();
    }

    public void checkAll(String[] inputNumbers) {
        checkSize(inputNumbers);
        checkZero(inputNumbers);
        checkDup(inputNumbers);
    }

    private void checkSize(String[] inputNumbers) {
        if (inputNumbers.length > 3)
            throw new IllegalArgumentException();
    }

    private void checkZero(String[] inputNumbers) {
        for (String number : inputNumbers) {
            if (number.equals("0"))
                throw new IllegalArgumentException();
        }
    }

    private void checkDup(String[] inputNumbers) {
        if (inputNumbers[0].equals(inputNumbers[1]))
            throw new IllegalArgumentException();
        if (inputNumbers[1].equals(inputNumbers[2]))
            throw new IllegalArgumentException();
        if (inputNumbers[0].equals(inputNumbers[2]))
            throw new IllegalArgumentException();
    }
}
