package baseball;

import baseball.input.ComputerInput;
import baseball.input.InputService;
import baseball.input.UserInput;
import baseball.umpire.AllRightAnswer;
import baseball.umpire.BaseBallUmpire;
import baseball.umpire.UmpireService;

public class BaseBallGame {

    private final UmpireService umpireService = new UmpireService();
    private final InputService inputService = new InputService();

    // 게임 시작
    public String start(){
        System.out.println("숫자 야구게임을 시작합니다.");
        inputService.computer();

        // 사용자 입력
        while(true){
            System.out.print("숫자를 입력 해주세요: ");
            inputService.user();

            // 사용자 입력과 컴퓨터 값과 비교
            umpireService.umpire(inputService.getUser(),inputService.getComputer());
            // 3스트라이크일 경우
            if(umpireService.var()){
                return umpireService.decision();
            }
        }
    }
}