package baseball;

public class ValidateInputValue {

    String inputValue;
    char[] charArrInputValue;

    public ValidateInputValue(String inputValue) {
        this.inputValue = inputValue;
        charArrInputValue = inputValue.toCharArray();
    }

    boolean validate(){
        return validateLengthOfInputValue() && validateSameAndNotNumber() ? true : false;
    }

    protected boolean validateSameAndNotNumber() {
        String str = "";
        for(int i = 0 ; i < charArrInputValue.length ; i++) {
            if(str.contains(charArrInputValue[i] + "")) {
                return false;
            }

            if (!(charArrInputValue[i] > '0' && charArrInputValue[i] <= '9')) {
                return false;
            }

            str += charArrInputValue[i];
        }

        return true;
    }

    protected boolean validateLengthOfInputValue() {
        return charArrInputValue.length == 3 ? true : false ;
    }
}
