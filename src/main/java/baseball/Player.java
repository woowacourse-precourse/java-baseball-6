package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> playerNumbers;
    private boolean isQuit;

    public Player(){
        playerNumbers = new ArrayList<>();
        isQuit =false;
    }

    //이용자 예측 수 입력
    public ArrayList<Integer> outputPlayerNumbers(){
        String playerInputString = Console.readLine();

        //잘못된 입력 시 예외 처리
        NumberException numberException = new NumberException();
        numberException.checkPlayerInputException(playerInputString);
        
        BaseballNumber baseballNumber = new BaseballNumber();
        playerNumbers = baseballNumber.toIntegerArray(playerInputString);

        return playerNumbers;
    }

    //이용자 게임 종료 여부 입력
    public Integer outputPlayerIsQuit(){
        String playerInputQuit = Console.readLine();

        //잘못된 입력 시 예외 처리
        NumberException numberException = new NumberException();
        numberException.checkPlayerQuitException(playerInputQuit);

        return Integer.parseInt(playerInputQuit);
    }
}
