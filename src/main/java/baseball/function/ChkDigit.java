package baseball.function;

public class ChkDigit {

    public Boolean ChkUnique(int[] numbers, int i, int number) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == number) {
                return false;
            }
        }
        return true;
    }

    public void ChkSize(String Number) throws IllegalArgumentException{
        if(Number.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    public void ChkIsNum(String Number) throws IllegalArgumentException{
        if (!Number.matches("[0-9]+")){
            throw new IllegalArgumentException();
        }
    }
}