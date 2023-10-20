package baseball.exception;

public class ReGameException {

    public void validation(String request){
        requestLengthValidation(request);
        requestNumberValidation(request);
    }

    private void requestLengthValidation(String request){
        if (request.length() != 1){
            throw new IllegalArgumentException("숫자 하나만 입력해주세요.");
        }
    }

    private void requestNumberValidation(String request){
        int result = request.charAt(0) - '0';

        if (!(result == 1 || result == 2)){
            throw new IllegalArgumentException("숫자 1 또는 2를 입력해주세요.");
        }
    }
}
