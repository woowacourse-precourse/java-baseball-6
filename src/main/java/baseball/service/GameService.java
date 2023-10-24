package baseball.service;

import baseball.domain.Player;
import baseball.domain.Rule;
import baseball.utils.Checker;
import baseball.utils.RandomGenerator;
import baseball.view.GameMessage;
import baseball.view.RequestMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    int size;
    Rule game;
    Player player=new Player();
    Checker checker =new Checker();
    GameMessage gameMessage=new GameMessage();
    public void setGame(int start,int end, int size){
        this.size=size;
        game = new Rule(RandomGenerator.pickRandomNum(start, end, size));
    }

    public void startGame(){
        int flag=0;
        while(!(flag == 3)){
            playGame();
            gameMessage.printResultMessage(game.getBallCount(),game.getStrikeCount());
            flag= game.getStrikeCount();
        }
    }

    private void playGame(){
        game.initParam();
        player.setPlayerInput(getPlayerInput());
        calculateScore();
    }

    private int[] getPlayerInput() throws IllegalArgumentException{
        RequestMessage.requestInput();
        String input = Console.readLine();
        return checker.checkPlayerInput(input,size);
    }

    private void calculateScore() {
        for (int index = 0; index < size; index++) {
            calculate(game.getComputerInput(),player.getPlayerInput(),index);
        }
    }

    private void calculate(int[] goal, int[] shot, int shotIndex){
        int goalIndex=-1;
        for (int idx = 0; idx < goal.length; idx++) {
            if(goal[idx]==shot[shotIndex]){
                goalIndex=idx;
                break;
            }
        }
        countScore(goalIndex,shotIndex);
    }

    private void countScore(int goal, int shot){
        if(goal!=shot&&goal!=-1)
            game.countBall();
        if(goal==shot)
            game.countStrike();
    }
}
