package baseball.Controller;

import baseball.DTO.Computer;

public class GameController {

    private final Computer computer;
    public GameController(){
        computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public String judgeUserInput(Integer strike,Integer ball){
        String judgement = null;
        if (strike == 0 && ball == 0) {
            judgement = "낫싱";
        }else if(strike > 0 && ball == 0) {
            judgement = strike + "스트라이크";
        } else if (strike == 0 && ball > 0) {
            judgement = ball+"볼";
        } else if (strike > 0 && ball >0) {
            judgement = ball+"볼"+" "+strike+"스트라이크";
        }
        return judgement;
    }
}
