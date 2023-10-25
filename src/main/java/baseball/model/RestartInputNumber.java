package baseball.model;

public class RestartInputNumber {
    private int number;

    public RestartInputNumber(String inputNum) {
        if(!isValidNumber(inputNum))
            throw new IllegalArgumentException("입력 값은 1 또는 2여야 합니다.");
        this.number = Character.getNumericValue(inputNum.charAt(0));
    }

    public boolean isValidNumber(String number){
        int numericValue =  Integer.parseInt(number);
        return 0<numericValue && numericValue<3;
    }

    public boolean isRestart() {
        if(number==1)
            return true;
        else
            return false;
    }
}
