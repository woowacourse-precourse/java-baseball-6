package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        BaseballUI baseballUI = new BaseballUI();
        InputValidator inputValidator = new InputValidator();

        baseballUI.printStart();
        //컴퓨터 랜덤 값 생성
        List<Integer> computer = baseballGame.computer();

        while(true){
            baseballUI.printInput();
            String playerStr = Console.readLine();
            inputValidator.inputChk(playerStr);
            baseballGame.playGame(playerStr, computer);

            boolean result = baseballGame.showResult();

            if(result){
                baseballUI.printEndGame();
                baseballUI.printReStart();
                String startBtn = Console.readLine();
                //컴퓨터 랜덤 값 재생성
                if(startBtn.equals("1")) computer = baseballGame.computer();
                //프로그램 종료
                else if(startBtn.equals("2")){
                    return;
                } else throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
            }
        }
    }
}
