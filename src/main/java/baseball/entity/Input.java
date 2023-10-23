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
    }

    private void inGameValidate() {
        checkIsNum();
        checkLength(3);
        checkAllDiffer();
    }

    private void checkLength(int length) {
        if (inputString.length() != length) {
            throw new IllegalArgumentException();
        }
    }
    private void checkIsNum(){
        try {
            Integer.parseInt(inputString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkAllDiffer( ) {
        if (inputString.charAt(0) == inputString.charAt(1) || inputString.charAt(0) == inputString.charAt(2) || inputString.charAt(1) == inputString.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }
}
