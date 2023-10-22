package baseball.entity;

import baseball.impl.Player;

public class PlayerImpl implements Player {

    private static final String GameInput = "^[1-9]{3}";
    public static final String ContinueInput = "^[1-2]";
    @Override
    public void gameInputCheck(String input) throws IllegalArgumentException{
        if(!input.matches(GameInput)){
            throw new IllegalArgumentException();
        }
        if(!redendancyCheck(input)){
            throw new IllegalArgumentException();
        }
    }
    @Override
    public boolean continueInputCheck(String input) throws IllegalArgumentException{
        if(!input.matches(ContinueInput)){
            throw new IllegalArgumentException();
        }
        if(input.equals("2")){
            return false;
        }
        return true;
    }
    private boolean redendancyCheck(String input){
        String[] tmp = input.split("");
        return !tmp[0].equals(tmp[1]) && !tmp[0].equals(tmp[2]) && !tmp[1].equals(tmp[2]);
    }
}
