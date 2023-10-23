package baseball;

import baseball.service.InputService;
import baseball.service.UmpireService;

public class BaseBallGame {

    private final UmpireService umpireService = new UmpireService();
    private final InputService inputService = new InputService();

    public String start(){
        System.out.println("숫자 야구게임을 시작합니다.");
        inputService.computerAnswer();

        while(true){
            System.out.print("숫자를 입력 해주세요: ");
            inputService.userAnswer();

            umpireService.umpire(inputService.getUser(),inputService.getComputer());
            if(umpireService.var()){
                return umpireService.decision();
            }
        }
    }
}