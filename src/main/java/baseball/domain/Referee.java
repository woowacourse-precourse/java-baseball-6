package baseball.domain;

public class Referee {
    private int ball;
    private int strike;
    private StringBuilder sb;

    public Referee(){
        this.ball = 0;
        this.strike = 0;
        this.sb = new StringBuilder();
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
    public String judgement(int ball, int strike){
        if(ball != 0){
            sb.append(ball).append("볼 ");
        }
        if(strike != 0){
            sb.append(strike).append("스트라이크");
        }
        if(sb.isEmpty()){
            sb.append("낫싱");
        }
        return sb.toString();
    }
    public boolean gameEnd(String computer, String player){
        if(computer.equals(player)){
            return true;
        }
        return false;
    }
}
