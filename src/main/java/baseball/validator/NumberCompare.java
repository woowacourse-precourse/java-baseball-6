package baseball.validator;

public class NumberCompare {
    private int ball;
    private int strike;

    public int getStrike(){
        return strike;
    }

    public int[] getNumberCompare(String player_num, String answer_num) {
        resetCount();
        ballCount(player_num, answer_num);
        strikeCount(player_num, answer_num);
        strikeExcept();

        return new int[]{ball, strike};
    }

    public void resetCount(){
        ball = 0;
        strike = 0;
    }

    public void ballCount(String player_num, String answer_num){
        for (int i = 0; i < player_num.length(); i++) {
            if (answer_num.contains(Character.toString(player_num.charAt(i)))) {
                ball ++;
            }
        }
    }

    public void strikeCount(String player_num, String answer_num){
        for (char playerNum : player_num.toCharArray()) {
            if (answer_num.indexOf(playerNum) == player_num.indexOf(playerNum)) {
                strike ++;
            }
        }
    }

    public void strikeExcept(){
        ball = ball - strike;
    }
}
