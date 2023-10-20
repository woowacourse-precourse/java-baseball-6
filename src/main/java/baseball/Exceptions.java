package baseball;

public class Exceptions {

    public void isInvalidNumberRestart(String input){
        if(input.equals("1") || input.equals("2")){
            return;
        }throw new IllegalArgumentException("유효하지않은 값입니다.");
    }

}
