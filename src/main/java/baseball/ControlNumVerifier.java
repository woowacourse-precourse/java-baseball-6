package baseball;

import static baseball.SystemConstant.GAME_EXIT_CODE;
import static baseball.SystemConstant.GAME_RESTART_CODE;

public class ControlNumVerifier implements Verifier {
    @Override
    public void check(String input) {
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
        if(control != GAME_RESTART_CODE && control != GAME_EXIT_CODE){
            throw new IllegalArgumentException(ExceptionMessage.UNKNOWN_CONTROL_INPUT);
        }
    }
}
