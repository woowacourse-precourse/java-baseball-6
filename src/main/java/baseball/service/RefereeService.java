package baseball.service;

import baseball.domain.Referee;

public class RefereeService {
    private StringBuilder sb;
    public RefereeService(){
        sb = new StringBuilder();
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
