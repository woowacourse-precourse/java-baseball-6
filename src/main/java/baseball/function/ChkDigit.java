package baseball.function;

public class ChkDigit {

    public Boolean ChkUnique(int[] computerNumber, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (computerNumber[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}