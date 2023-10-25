package baseball.domain;


import java.util.List;

public class Hint {

    private String answer;
    private static final String IS_STRIKE = "스트라이크";
    private static final String IS_BALL = "볼";
    private static final String IS_NOTHING = "낫싱";
    private static final String IS_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private boolean isTrue = false;
    private int strike = 0;
    private int ball = 0;

    public void initStatus(){
        strike = 0;
        ball = 0;
        isTrue = false;
    }

    public boolean compareNumber(List<BaseballNumber> computer, List<BaseballNumber> player) {

        for(int i = 0; i <computer.size(); i++){
            compareNumber(computer, player, i);
        }

        getHint();

        System.out.println(answer);

        return isTrue;
    }

    private void compareNumber(List<BaseballNumber> computer, List<BaseballNumber> player, int i) {
        for(int j = 0; j < player.size(); j++){
            addStrike(computer, player, i, j);
            addBall(computer, player, i, j);
        }
    }

    private void addBall(List<BaseballNumber> computer, List<BaseballNumber> player, int i, int j) {


        if(computer.get(i).equals(player.get(j)) && i != j){
            ball++;
        }
    }

    private void addStrike(List<BaseballNumber> computer, List<BaseballNumber> player, int i, int j) {
        if(computer.get(i).equals(player.get(j)) && i == j){
            strike++;
        }
    }

    private void getHint(){

        StringBuilder sb = new StringBuilder();

        if(strike == 0 && ball == 0){
            answer = IS_NOTHING;
            return;
        }

        if(strike>0 && strike<3 && ball==0){
            answer = sb.append(strike).append(IS_STRIKE).toString();
            return;
        }

        if(ball>0 && ball < 3 && strike == 0){
            answer = sb.append(ball).append(IS_BALL).toString();
            return;
        }

        if(strike>0 && strike<3 && ball>0 && ball < 3){
            answer = sb.append(ball).append(IS_BALL).append(" ").append(strike).append(IS_STRIKE).toString();
            return;
        }

        if(strike == 3){
            isTrue = true;
            answer = sb.append(strike).append(IS_STRIKE).append("\n").append(IS_CORRECT).toString();
        }
    }

}
