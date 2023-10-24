package baseball.function;

public class ChkDigit {

    public Boolean chkUnique(int[] numbers, int i, int number) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == number) {
                return false;
            }
        }
        return true;
    }

    public void chkSize(String Number) throws IllegalArgumentException{
        if(Number.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    public void chkIsNum(String Number) throws IllegalArgumentException{
        if (!Number.matches("[1-9]+")){
            throw new IllegalArgumentException();
        }
    }
}