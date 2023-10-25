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
    public static final int ZERO_COUNT = 0;

    public BaseBallGame(Player player) {
        this.player = player;
    }

//    게임 시작 및 재시작
    public void startGame(){
        System.out.println(START_MESSAGE);
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


//    사용자가 입력한 숫자에 대한 결과값 콘솔로 출력
    private void printResult(List<Integer> resultList){
        StringBuilder sb = new StringBuilder();
        if(isOut(resultList)){
            System.out.println(NOT_THING_MESSAGE);
            return ;
        }

        sb.append(getBallMessage(resultList));
        sb.append(getStrikeMessage(resultList));

        System.out.println(sb.toString());
    }

//    사용자가 모든 숫자를 맞췄는지 확인
    private boolean checkResult(List<Integer> resultList){
        return resultList.get(STRIKE_INDEX) == resultList.size();
    }

//    아웃인지 확인
    private boolean isOut(List<Integer> resultList){
        return resultList.get(OUT_INDEX) == resultList.size();
    }

//    볼 스코어에 대한 메세지 만들기
    private String getBallMessage(List<Integer> resultList){
        if(resultList.get(BALL_INDEX)==ZERO_COUNT){
            return "";
        }
        return resultList.get(BALL_INDEX)+BALL_MESSAGE+" ";
    }

//    스트라이크 스코어에 대한 메세지 만들기
private String getStrikeMessage(List<Integer> resultList){
    if(resultList.get(STRIKE_INDEX)==ZERO_COUNT){
        return "";
    }
    return resultList.get(STRIKE_INDEX)+STRIKE_MESSAGE;
}



}
