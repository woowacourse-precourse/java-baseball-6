package baseball.playGround;

import baseball.console.ConsoleHandler;
import baseball.judge.Judge;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PlayGround {

    private final ConsoleHandler consoleHandler;
    private final List<Integer> answer;
    private boolean judgement = false;

    public PlayGround(ConsoleHandler consoleHandler){
        this.consoleHandler = consoleHandler;
        this.answer = setAnswer();
    }

    public void playGame(){
        while(!judgement) {
            String player = consoleHandler.inputNumber();

            Judge judge = new Judge(player, answer, consoleHandler);
            judgement = judge.judge();
        }
        consoleHandler.endMessage();
    }

    public List<Integer> setAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }



}
