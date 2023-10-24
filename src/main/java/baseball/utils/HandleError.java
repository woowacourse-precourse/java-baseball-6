package baseball.utils;

public class HandleError {
    void validateInputString(String inputString) {
        char[] characters = inputString.toCharArray();
        Integer count = 0; //입력한 문자가 3자리 인지 확인하는 변수

        for (char ch : characters) {
            count+=1;
            //입력한 문자가 숫자로 이루어져 있는지
            if(!Character.isDigit(ch)) {
                throw new IllegalArgumentException("input value is not number");
            }
        }
        //입력한 문자가 3자리 인지
        if(count!=3) {
            throw new IllegalArgumentException("input number is not 3 characters long.");
        }
    }
}
