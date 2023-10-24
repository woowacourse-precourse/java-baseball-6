package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Player {
    public String getPlayerInput(){
        try{
            String playerInput = Console.readLine();
            return playerInput;
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("명령을 입력해주세요!");
        }
    }

}
