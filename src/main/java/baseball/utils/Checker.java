package baseball.utils;

public class Checker {

    public int[] checkPlayerInput(String input, int size) throws IllegalArgumentException{
        checkSize(input,size);
        return intPlayerInput(input,size);
    }

    private void checkSize(String input, int size) throws IllegalArgumentException{
        if (input.length()!=size)
            throw new IllegalArgumentException();
    }

    private int[] intPlayerInput(String input, int size) {
        int[] playerInput =new int[size];

        for(int idx=0;idx<input.length();idx++){
            if(!checkNumber(input,idx)||checkDuplicated(input,idx)){
                throw new IllegalArgumentException();
            }
            playerInput[idx]=charToInt(input,idx);
        }
        return playerInput;
    }

    private Boolean checkNumber(String input, int index){
        return '1'<=input.charAt(index)&&input.charAt(index)<='9';
    }
    private Boolean checkDuplicated(String input, int index){
        for(int cnt=0;cnt<index;cnt++){
            if(input.charAt(cnt)==input.charAt(index))
                return true;
        }
        return false;
    }

    private int charToInt(String input, int index){
        return input.charAt(index)-'0';
    }
}
