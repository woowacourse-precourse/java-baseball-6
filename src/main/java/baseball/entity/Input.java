package baseball.entity;

public class Input {
    private String inputString;
    private boolean isInGame;

    public Input(String inputString, boolean isInGame) {
        this.inputString = inputString;
        this.isInGame = isInGame;
    }

    public String getInputString() {
        return inputString;
    }

    public void validate() {
        if (isInGame) {
            inGameValidate();
            return;
        }
        reGameValidate();
    }

    private void reGameValidate() {
        checkIsNum();
        checkLength(1);
        isOneOrTwo();
    }

    private void inGameValidate() {
        checkIsNum();
        checkLength(3);
        checkAllDiffer();
    }

    private void checkLength(int length) {
        if (inputString.length() != length) {
            throw new IllegalArgumentException(String.format("입력 길이 초과입니다. 입력길이 : [%s],  예상 길이: [%s]",inputString.length(),length));
        }
    }
    private void isOneOrTwo() {
        if (!(inputString.equals("1") || inputString.equals("2"))) {
            throw new IllegalArgumentException(String.format("입력이 1혹은 2가 아닙니다. 입력한 문자 : [%s]",inputString));
        }
    }
    private void checkIsNum(){
        try {
            Integer.parseInt(inputString);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("입력이 숫자가 아닙니다. 입력한 문자 : [%s]",inputString));
        }
    }

    private void checkAllDiffer( ) {
        if (inputString.charAt(0) == inputString.charAt(1) || inputString.charAt(0) == inputString.charAt(2) || inputString.charAt(1) == inputString.charAt(2)) {
            throw new IllegalArgumentException("입력에서 중복된 숫자가 존재합니다.");
        }
    }
}
