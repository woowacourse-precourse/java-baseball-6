package baseball.Controller;

import baseball.DTO.Computer;
import baseball.DTO.User;
import baseball.Service.JudgmentService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final Computer computer;
    public GameController(){
        computer = new Computer();
    }

    public void input(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        Integer strike = 0;
        while (strike < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            User user = new User(userInput);

            JudgmentService judgmentService = new JudgmentService(user, computer);

            strike = judgmentService.judgeStrike();
            Integer ball = judgmentService.judgeBall();

            System.out.println(judgeUserInput(strike, ball));
        }
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
