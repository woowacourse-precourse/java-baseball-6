package baseball;

public class GuessNumber {
    private final String guess;

    public GuessNumber(String string) throws IllegalArgumentException{
        guess=string;
        checkValidation();
    }
    private void checkValidation() throws IllegalArgumentException{
        if (guess.length()!=3){
            throw new IllegalArgumentException();
        }
        for(char ch : guess.toCharArray()){
            checkDigitChar(ch);
        }
        if(guess.charAt(0)==guess.charAt(1)
                || guess.charAt(1)==guess.charAt(2)
                || guess.charAt(0)==guess.charAt(2)){
            throw new IllegalArgumentException();
        }
    }
    private static void checkDigitChar(char ch) throws IllegalArgumentException{
        if (ch>'9' || ch<'1'){
            throw new IllegalArgumentException();
        }
    }
    public String getGuess() {
        return guess;
    }
}
