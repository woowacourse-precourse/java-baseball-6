package baseball;



public class Exception {

    public void checkUserInput(){
        checkNumbers();
        checkDigits();
        checkDuplicateNumbers();
    public static void checkOneOrTwo(int userInput){
        if(userInput != 1 && userInput != 2){
            throw new IllegalArgumentException("프로그램 종료");
        }
    }

    public void checkNumbers(){

    }

    public void  checkDigits(){

    }

    public void checkDuplicateNumbers(){

    }
}
