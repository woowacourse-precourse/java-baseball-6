package baseball.exception;

public class InputException {
    public boolean isThree(String number){
        return number.length()==3;
    }
    public boolean isToInt(String number){
        try {
            int num = Integer.parseInt(number);
        }catch (IllegalArgumentException illegalArgumentException){
            illegalArgumentException = new IllegalArgumentException("잘못 입력 게임 종료");
            return false;
        }
        return true;
    }
    public boolean isRange(String number){
        int num = Integer.parseInt(number);
        if(num>=123 && num<=987){
            return true;
        }
        return false;
    }
    public boolean isContainZero(String number){
        if(number.contains("0")){
            return true;
        }
        return false;
    }
    public boolean isContainSameNum(String number){
        if(number.charAt(0)==number.charAt(1) || number.charAt(0)==number.charAt(2) || number.charAt(1)==number.charAt(2)) {
            return true;
        }
        return false;
    }
    public boolean inputContinue(int number){
        if(number==1 || number == 2){
            return true;
        }
        throw  new IllegalArgumentException("잘못 입력 게임 종료");
    }
}
