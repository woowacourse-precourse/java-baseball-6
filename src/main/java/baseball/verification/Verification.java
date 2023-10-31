package baseball.verification;

public class Verification {
    public void checkStringIsNum(String stringOfNum) {
        for(int i=0 ; i<stringOfNum.length() ; i++){
            char currentChar = stringOfNum.charAt(i);

            if(Character.isDigit(currentChar) == false) {
                throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
            }
        }
    }

    public void checkStringLength(String stringOfNum) {
        if(stringOfNum.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
    }

    public void checkFinishInput(String finishInput) {
        if (finishInput.equals("1") || finishInput.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("1과 2중에 선택하세요.");
    }
}
