package baseball.verifier;

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
            throw new IllegalArgumentException("1~9사이 수가 아닌 값을 입력하였습니다.");
        }
    }

    private void checkRange(String input){//1 또는 2가 아닌 모둔 숫자는 예외처리.
        int control = Integer.parseInt(input);
        if(control != 1 && control != 2){
            throw new IllegalArgumentException("알 수 없는 컨트롤 값입니다.");
        }
    }
}
