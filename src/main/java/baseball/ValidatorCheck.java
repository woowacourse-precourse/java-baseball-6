package baseball;

public class ValidatorCheck {

    public void inputOnlyNumber(String inputNum){
        if (!inputNum.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("입력한 숫자는 1-9 사이의 숫자로 이루어져야 합니다.");
        }
    }

    public void inputRangeNumber(String inputNum){
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 길이는 3이어야 합니다.");
        }
    }

    //public void duplicationNumber(String inputNum){
        //inputNum 중복 숫자 check
        //for(int k=0; k<inputNum.length(); k++){
        //
        //}
    //}

//    public boolean gameRestartCheck(int check) {
//        if (check == 2) {
//            return false;
//        } else if (check ==1) {
//            return true;
//        } else {
//            throw new IllegalArgumentException("입력한 숫자는 1또는 2여야합니다.");
//        }
//    }

}
