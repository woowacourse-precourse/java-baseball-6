package baseball.domain;

public class Referee {
    private int ball;
    private int strike;

    public Referee(){
        this.ball = 0;
        this.strike = 0;
    }
    public int countBall(String computer, String player){
        for(int idx=0;idx<computer.length();idx++){
            if(computer.charAt(idx)!=player.charAt(idx) && computer.contains(String.valueOf(player.charAt(idx)))){
                ball++;
            }
        }
        return ball;
    }
    public int countStrike(String computer, String player){
        for(int idx=0;idx<computer.length();idx++){
            if(computer.charAt(idx)==player.charAt(idx)){
                strike++;
            }
        }
        return strike;
    }
}
