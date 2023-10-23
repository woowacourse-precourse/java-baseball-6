package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ViewResult {
    private final String correct = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String restart = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final String start = "숫자 야구 게임을 시작합니다.";
    public final String userInput = "숫자를 입력해주세요 : ";
    private final String threeStrike = "3스트라이크";
    private final String strike = "스트라이크";
    private final String nothing = "낫싱";
    private final String ball = "볼";

    Validator validator = new Validator();
    public int printResult(Score.ScoreBoard scoreBoard) {
        if(scoreBoard.strike == 3){
            endGame();
            String choice = Console.readLine();
            validator.checkUserRestart(choice);

            if(stoi(choice) == 1)   return 1;
            else if(stoi(choice) == 2)  return 2;
        }
        else if(scoreBoard.strike >= 1 && scoreBoard.ball >= 1){
            System.out.println(scoreBoard.ball + ball + " "+ scoreBoard.strike + strike);
        }
        else if(scoreBoard.strike == 0 && scoreBoard.ball == 0){
            System.out.println(nothing);
        }
        else if(scoreBoard.strike == 0 && scoreBoard.ball >= 1){
            System.out.println(scoreBoard.ball + ball);
        }
        else if(scoreBoard.strike >= 1 && scoreBoard.ball == 0){
            System.out.println(scoreBoard.strike + strike);
        }
        return 3;
    }

    private void endGame() {
        System.out.println(threeStrike);
        System.out.println(correct);
        System.out.println(restart);
    }

    private int stoi(String s){
        return Integer.parseInt(s);
    }
}
