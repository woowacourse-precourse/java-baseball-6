package baseball.Controller;

import baseball.DTO.Computer;
import baseball.DTO.User;
import baseball.Service.JudgmentService;
import baseball.view.View;

public class GameController {
    private final View view;
    private final JudgmentService judgmentService;
    private final Computer computer;
    public GameController(){
        view = new View();
        judgmentService = new JudgmentService();
        computer = new Computer();
        System.out.println(computer.getComputerNumbers().toString());
    }

    public void controlGameFlow(){
        Integer strike = 0;
        while (strike < 3) {
            User user = new User(view.input());

            strike = judgmentService.countStrike(user.getUserNumbers(),computer.getComputerNumbers());
            Integer ball = judgmentService.judgeBall(user.getUserNumbers(),computer.getComputerNumbers());

            view.printJudgement(judgeUserInput(strike,ball));
        }
        endGame();
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

    public void endGame(){
        String isAgainStart = view.againStart();
        if (isAgainStart.equals("1")){
            GameController gameController = new GameController();
            gameController.controlGameFlow();
        }
    }
}
