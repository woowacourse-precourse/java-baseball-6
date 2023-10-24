package baseball;

import java.util.List;

public class BaseballGame {
    private static final String START_MSG = "숫자를 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBERS_MSG = "숫자를 입력해주세요 : ";
    private static final String END_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private User user;
    private Computer computer;
    private Result result;

    public BaseballGame() {
        this.user = new User();
        this.computer = new Computer();
        this.result = new Result();
    }

    public void startGame(){
        System.out.println(START_MSG);

        while(true){
            //(1) 컴퓨터 : 1에서 9까지 서로 다른 임의의 수 3개 생성
            List<Integer> computerNumbs = computer.getNumbers();

            //(2) 사용자가 추측하는 3개의 수 입력 받기
            while(true){
                System.out.print(INPUT_NUMBERS_MSG);
                List<Integer> userNumbs = user.getNumbers();
                result.compare(computerNumbs, userNumbs);
                if(result.findAnswer()){
                    break;
                }
            }

            //(3) 게임 재실행 여부 입력 받기
            System.out.println(END_MSG);
            if(!user.continueGame()){
                break;
            }
        }
    }
}
