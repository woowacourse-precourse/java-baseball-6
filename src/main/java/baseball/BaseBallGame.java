package baseball;

import baseball.input.ComputerInput;
import baseball.input.InputService;
import baseball.input.UserInput;
import baseball.umpire.AllRightAnswer;
import baseball.umpire.BaseBallUmpire;

public class BaseBallGame {
    private String decision="";
    private final ComputerInput computerInput = new ComputerInput();
    private final BaseBallUmpire baseballUmpire = new BaseBallUmpire();
    private final AllRightAnswer allRightAnswer = new AllRightAnswer();

    private final InputService inputService = new InputService();

    // 게임 시작
    public String start(){
        System.out.println("숫자 야구게임을 시작합니다.");
        inputService.computer();
        //computerInput.create();

        // 사용자 입력
        while(true){
            System.out.print("숫자를 입력 해주세요: ");
            inputService.user();
//            UserInput userInput  = UserInput.create();
//            userInput.checking();

            // 사용자 입력과 컴퓨터 값과 비교
            //baseballUmpire.umpire(userInput.value(), computerInput.value());
            baseballUmpire.shouting();

            // 3스트라이크일 경우
            if(baseballUmpire.threeStrikeVAR()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return allRightAnswer.restartOrExit();
            }
        }
    }
}