package Util;

public class NumberCompare {
    private int ball;
    private int strike;

    public int[] getNumberCount(String computerNumber, String userNumber){
        resetCount();
        ballCount(computerNumber,userNumber);
        strikeCount(computerNumber,userNumber);
        resultCount();
        return new int[]{ball,strike};
    }

    private void resetCount(){
        ball = 0;
        strike = 0;
    }

    private void ballCount(String computerNumber, String userNumber){
        for(int i = 0; i<userNumber.length(); i++){
            if(computerNumber.contains(Character.toString(userNumber.charAt(i)))){
                ball ++;
            }
        }
    }

    private void strikeCount(String computerNumber, String userNumber){
        for (int i = 0; i < userNumber.length(); i++) {
            if (computerNumber.charAt(i) == userNumber.charAt(i)) {
                strike++;
            }
        }
    }

    private void resultCount(){
        ball = ball - strike;
    }

}
