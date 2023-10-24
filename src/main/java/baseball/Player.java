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

    public ArrayList<Integer> outputPlayerNumbers(){
        String playerInputString = Console.readLine();

        NumberException numberException = new NumberException();
        numberException.checkPlayerInputException(playerInputString);
        
        BaseballNumber baseballNumber = new BaseballNumber();
        playerNumbers = baseballNumber.toIntegerArray(playerInputString);

        return playerNumbers;
    }
    
    public Integer outputPlayerIsQuit(){
        String playerInputQuit = Console.readLine();

        NumberException numberException = new NumberException();
        numberException.checkPlayerQuitException(playerInputQuit);

        int isQuitInt = Integer.parseInt(playerInputQuit);
        return isQuitInt;
    }
    
}
