package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final int INPUT_LENGTH = 3;
    private static final String RESTART_NUM = "1";
    private static final String END_NUM = "2";

    private String input;
    private String endInput;

    public Player(){
    }

    public String getInput(){
        input = Console.readLine();
        System.out.println(input);
        validateInput();

        return input;
    }

    private void validateInput(){
        if(input.length() != INPUT_LENGTH){
            throw new IllegalArgumentException();
        }

        for(int i=0;i<INPUT_LENGTH;i++){
            char ch = input.charAt(i);

            if(!Character.isDigit(ch)){
                throw new IllegalArgumentException();
            }
        }
    }

    public void setEndInput(){
        endInput = Console.readLine();
        validateEndInput();
    }

    private void validateEndInput(){
        if(!endInput.equals(RESTART_NUM) && !endInput.equals(END_NUM)){
            throw new IllegalArgumentException();
        }
    }

    public boolean isEnd(){
        return endInput.equals(END_NUM);
    }
}
