package baseball.view;

import baseball.global.Validator;
import baseball.model.Score;
import camp.nextstep.edu.missionutils.Console;

public class ViewResult {
    private final String correct = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String choice = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final String start = "숫자 야구 게임을 시작합니다.";
    public final String userInput = "숫자를 입력해주세요 : ";
    private final String threeStrike = "3스트라이크";
    private final String strike = "스트라이크";
    private final String nothing = "낫싱";
    private final String ball = "볼";
    public final int restart = 1;
    public final int end = 2;
    Validator validator = new Validator();
    public int printResult(Score.ScoreBoard scoreBoard) {
        if(scoreBoard.getStrike() == 3){
            endGame();
            String choice = Console.readLine();
            validator.checkUserChoice(choice);

            if(stoi(choice) == restart)   return restart;
            else if(stoi(choice) == end)  return end;
        }
        else if(scoreBoard.getStrike() >= 1 && scoreBoard.getBall() >= 1){
            System.out.println(scoreBoard.getBall() + ball + " "+ scoreBoard.getStrike() + strike);
        }
        else if(scoreBoard.getStrike() == 0 && scoreBoard.getBall() == 0){
            System.out.println(nothing);
        }
        else if(scoreBoard.getStrike() == 0 && scoreBoard.getBall() >= 1){
            System.out.println(scoreBoard.getBall() + ball);
        }
        else if(scoreBoard.getStrike() >= 1 && scoreBoard.getBall() == 0){
            System.out.println(scoreBoard.getStrike() + strike);
        }
        return 3;
    }

    private void endGame() {
        System.out.println(threeStrike);
        System.out.println(correct);
        System.out.println(choice);
    }

    private int stoi(String s){
        return Integer.parseInt(s);
    }
}
