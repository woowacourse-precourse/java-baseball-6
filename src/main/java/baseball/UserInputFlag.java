package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInputFlag {
    private boolean flag;
    public void checkRetry(){
        String input = Console.readLine();
        checkFlag(input);
    }
    private void checkFlag(String input){
        if(input.equals("1")){
            flag=true;
        }
        else if(input.equals("2")){
            flag=false;
        }
        else{
            throw new IllegalArgumentException("invalid flag input");
        }
    }
    public boolean getFlag(){
        return this.flag;
    }
}
