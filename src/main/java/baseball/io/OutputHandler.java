package baseball.io;

import baseball.model.ResultScoreBoard;

public class OutputHandler {

    public void printScore (ResultScoreBoard resultScoreBoard) {
        if (resultScoreBoard.strike() == 0 && resultScoreBoard.ball() == 0) {
            System.out.println("낫싱");
        }else if(resultScoreBoard.ball() == 0) {
            System.out.println(resultScoreBoard.strike() +"스트라이크");
        }else if(resultScoreBoard.strike() == 0) {
            System.out.println(resultScoreBoard.ball() + "볼 ");
        }else if(resultScoreBoard.strike() != 0 && resultScoreBoard.ball() != 0){
            System.out.println(resultScoreBoard.ball() + "볼 " + resultScoreBoard.strike() + "스트라이크");
        }
    }
}
