package controller.validate;

public class NumberValidate {


    public void NumberValidateMachine(String numberToCheck){
        if(!checkNumberLength(numberToCheck)) {
            throw new IllegalArgumentException("[ERROR] 입력한 수가 세자리 수가 아닙니다.");
        }
        if (!containsOnlyNumbers(numberToCheck)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 것이 입력되어 있습니다.");
        }
    }

    private boolean checkNumberLength(String playerNumber){
        if(playerNumber.length() == 3){
            return true;
        }
        return false;
    }

    private boolean containsOnlyNumbers(String playerNumber) {
        // Use regular expression to check if the string contains only numeric characters
        return playerNumber.matches("\\d+");
    }
}
