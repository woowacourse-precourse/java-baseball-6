package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.util.ConstMessages.*;
import static baseball.util.Validation.verifyRestartInput;

public class BaseBallGame {

    private Computer computer;
    private Player player;
    public static final int EXIT_GAME_NUMBER= 2;
    public static final int STRIKE_INDEX = 0;
    public static final int BALL_INDEX = 1;
    public static final int OUT_INDEX = 2;

    public BaseBallGame(Player player) {
        this.player = player;
    }

    public void startGame(){
        int restart;
        do{
            this.computer = Computer.create();

             gameProgress();

            restart = Integer.parseInt(Console.readLine());
            verifyRestartInput(restart);

        }while(restart !=EXIT_GAME_NUMBER);
    }

    private void gameProgress(){
        boolean isCorrect = false;

        while (!isCorrect){
            System.out.println(INPUT_NUMBER_MESSAGE);
            List<Integer> playerNumbers = player.guessNumbers();

            printResult(playerNumbers);

            isCorrect = checkResult(playerNumbers);
        }

    }


    private void printResult(List<Integer> resultList){
        StringBuilder sb = new StringBuilder();
        if(resultList.get(OUT_INDEX) == resultList.size()){
            System.out.println(NOT_THING);
            return ;
        }

        sb.append(resultList.get(BALL_INDEX)!=0? resultList.get(BALL_INDEX)+BALL:"");
        sb.append(resultList.get(STRIKE_INDEX)!=0? resultList.get(STRIKE_INDEX)+STRIKE:"");

        System.out.println(sb.toString());

    }

    private boolean checkResult(List<Integer> playerNumbers){
        return playerNumbers.get(STRIKE_INDEX) == playerNumbers.size();
    }



}
