package baseball;

public class CheckInputNumber {
    private static final int NUMBER_LENGTH = 3;
    int strike = 0;
    int ball = 0;

    public int checkStrike(String randomNumber, String userNumber) {

        String[] randomNumberArr = String.valueOf(randomNumber).split("");
        String[] userNumberArr = String.valueOf(userNumber).split("");

        strike = 0;
        // calculate strike
        for(int i=0; i<NUMBER_LENGTH; i++) {
            if(randomNumberArr[i].equals(userNumberArr[i])) {
                strike++;
            }
        }
        return strike;
    }

    public int checkBall(String randomNumber, String userNumber) {

        String[] randomNumberArr = String.valueOf(randomNumber).split("");
        String[] userNumberArr = String.valueOf(userNumber).split("");

        ball = 0;
        for(int i=0; i<NUMBER_LENGTH; i++) {
            for(int k=0; k<NUMBER_LENGTH; k++){
                if(randomNumberArr[i].equals(userNumberArr[k]) && i != k) {
                    ball++;
                }
            }
        }
        return ball;
    }
}
