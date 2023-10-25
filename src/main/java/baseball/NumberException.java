package baseball;

import java.util.Arrays;

public class NumberException {
    private boolean isException;
    public NumberException(){
        isException = false;
    }

    //정답 수 예측 수 입력 시 Exception 판정
    public void checkPlayerInputException(String inputString){
        isException =  isLengthThree(inputString) || isDuplicateValue(inputString) || isOutOfRange(inputString);
        if(isException){
            throwIllegalArgumentException();
        }
    }

    //게임 종료 여부 입력 시 Exception 판정
    public void checkPlayerQuitException(String playerInputQuit){
        isException= !playerInputQuit.equals("1") && !playerInputQuit.equals("2");
        if(isException){
            throwIllegalArgumentException();
        }
    }

    //IllegalArgumentException 발생 함수
    public void throwIllegalArgumentException(){
        throw new IllegalArgumentException("IllegalArgumentException");
    }
    
    //정답 수 예측 수 입력 시 중복 숫자 입력 여부 판정
    private boolean isDuplicateValue(String inputString) {
        char[] arr = inputString.toCharArray();
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

    //정답 수 예측 수 입력 시 수 범위 밖의 입력 여부 판정
    private boolean isOutOfRange(String inputString) {
        char[] chars = inputString.toCharArray();
        for (char ch : chars) {
            if (ch <'1' && ch>'9') {
                return true;
            }
        }
        return false;
    }

    //정답 수 예측 수 입력 시 입력 문자 개수 일치 판정
    private boolean isLengthThree(String inputString) {
        return inputString.length() != 3;
    }
}
