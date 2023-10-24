package baseball.judge;

import baseball.console.ConsoleHandler;
import java.util.Arrays;
import java.util.List;

public class Judge {

    private final ConsoleHandler consoleHandler;
    private final List<Integer> playerAnswer;
    private final List<Integer> answer;

    public Judge(String playerAnswer, List<Integer> answer, ConsoleHandler consoleHandler) {
        this.playerAnswer = stringToList(playerAnswer);
        this.answer = answer;
        this.consoleHandler = consoleHandler;
    }

    private List<Integer> stringToList(String playerAnswer){
        return Arrays.stream(playerAnswer.split(""))
            .map(Integer::valueOf)
            .toList();
    }

    public boolean judge(){
        int ball=checkBall();
        int strike=checkStrike();

        if(ball == 0 & strike == 0){
            consoleHandler.showNothing();
        }
        else{
            consoleHandler.showResult(ball, strike);
        }

        return strike==3;
    }

    private int checkStrike() {
        int result = 0;
        for (int i = 0; i < answer.size(); i++) {
            Integer playerNum = playerAnswer.get(i);
            Integer answerNum = answer.get(i);
            if(playerNum.equals(answerNum)){
                result++;
            }
        }
        return result;
    }

    private int checkBall() {
        int result = 0;
        for (int i = 0; i < answer.size(); i++) {
            Integer playerNum = playerAnswer.get(i);
            Integer answerNum = answer.get(i);
            if(answer.contains(playerNum) && !playerNum.equals(answerNum)){
                result++;
            }
        }
        return result;
    }


}
