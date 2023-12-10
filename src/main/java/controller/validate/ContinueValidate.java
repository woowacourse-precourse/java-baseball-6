package controller.validate;

public class ContinueValidate {

    public void ContinueValidateMachine(int numberToCheck){
        if(!checkNumber(numberToCheck)) {
            throw new IllegalArgumentException("[ERROR] 1과 2중에서 선택해주세요.");
        }
    }

    private boolean checkNumber(int playerChoose){
        if(playerChoose == 1 || playerChoose == 2){
            return true;
        }
        return false;
    }
}
