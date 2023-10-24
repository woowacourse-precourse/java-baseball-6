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

//    게임 시작 및 재시작
    public void startGame(){
        int restart;
        do{
            this.computer = Computer.create();

            gameProgress();
            System.out.println(FINISH_MESSAGE);
            System.out.println(RESTART_MESSAGE);
            restart = Integer.parseInt(Console.readLine());
            verifyRestartInput(restart);

        }while(restart !=EXIT_GAME_NUMBER);
    }

//    게임 진행 중
    private void gameProgress(){
        boolean isCorrect = false;

        while (!isCorrect){
            System.out.print(INPUT_NUMBER_MESSAGE);
            List<Integer> resultList = computer.compareNumbers(player.guessNumbers());

            printResult(resultList);

            isCorrect = checkResult(resultList);
        }

    }


    private void printResult(List<Integer> resultList){
        StringBuilder sb = new StringBuilder();
        if(resultList.get(OUT_INDEX) == resultList.size()){
            System.out.println(NOT_THING);
            return ;
        }

        sb.append(resultList.get(BALL_INDEX)!=0? resultList.get(BALL_INDEX)+BALL_MESSAGE+" ":"");
        sb.append(resultList.get(STRIKE_INDEX)!=0? resultList.get(STRIKE_INDEX)+STRIKE_MESSAGE:"");

        System.out.println(sb.toString());
    }

    private boolean checkResult(List<Integer> resultList){
        return resultList.get(STRIKE_INDEX) == resultList.size();
    }



}
