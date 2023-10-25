package baseball;

public class VerifyCharInString {
    // 문자열이 모두 숫자로만 이루어져있는지 검사하는 함수
    public boolean isCharacterExist(String randomNum) {
        try{
            Integer.parseInt(randomNum);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }
}
