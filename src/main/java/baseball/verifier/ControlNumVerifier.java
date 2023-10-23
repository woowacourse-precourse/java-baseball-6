package baseball.verifier;

import baseball.system.ExceptionMessage;

public class ControlNumVerifier implements Verifier {
    @Override
    public void check(String input) throws IllegalArgumentException {
        checkNumeric(input);
        checkRange(input);
    }

    private void checkNumeric(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC);
        }
    }

    private void checkRange(String input){//1 또는 2가 아닌 모둔 숫자는 예외처리.
        int control = Integer.parseInt(input);
        if(control != 1 && control != 2){
            throw new IllegalArgumentException(ExceptionMessage.UNKNOWN_CONTROL_INPUT);
        }
    }
}
