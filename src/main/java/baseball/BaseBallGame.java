package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class BaseBallGame {
    private String decision="";
    private final ComputerInput computerInput = new ComputerInput();
    private final BaseBallUmpire baseballUmpire = new BaseBallUmpire();
    private final AllRightAnswer allRightAnswer = new AllRightAnswer();

    // 게임 시작
    public String start(){
        System.out.println("숫자 야구게임을 시작합니다.");
        computerInput.create();

        // 사용자 입력
        while(true){
            System.out.print("숫자를 입력 해주세요: ");
            UserInput userInput  = UserInput.from(readLine().replaceAll(" ",""));

            // 사용자 입력과 컴퓨터 값과 비교
            decision = baseballUmpire.umpire(userInput.value(), computerInput.value());

            // 3스트라이크일 경우
            if(allRightAnswer.threeStrikeVAR(decision)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                computerInput.reset();
                return allRightAnswer.restartOrExit();
            }
        }
    }
}