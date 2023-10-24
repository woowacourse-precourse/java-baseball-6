package baseball.utils;

public class CompareNumber {
    private int ball;
    private int strike;

    public int getStrike(){
        return strike;
    }

    public int[] getCompareNumberResult(String userNumber, String answerNumber) {
        resetCount();
        countBallAndStrike(userNumber, answerNumber);

        return new int[]{ball - strike, strike}; // Direct calculation in return statement to maintain logic.
    }

    public void resetCount(){
        ball = 0;
        strike = 0;
    }

    private void countBallAndStrike(String userNumber, String answerNumber) {
        for (int i = 0; i < userNumber.length(); i++) {
            char currentChar = userNumber.charAt(i);
            if (answerNumber.indexOf(currentChar) != -1) { // Check if the character is present in the answerNumber.
                ball++;
                if (i == answerNumber.indexOf(currentChar)) { // It's a strike if the positions are the same.
                    strike++;
                }
            }
        }
    }
}
