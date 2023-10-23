package baseball;



public class Exception {

    public static void checkOneOrTwo(int userInput){
        if(userInput != 1 && userInput != 2){
            throw new IllegalArgumentException("프로그램 종료");
        }
    }

    public static void checkUserInput(char[] userInput){
        checkNumbers(userInput);
        checkDigits(userInput);
        checkDuplicateNumbers(userInput);
    }

    public void  checkDigits(){
    public static void checkNumbers(char[] userInput){
        for (char c : userInput) {
            if ((int) c < 49 || (int) c > 57) {
                throw new IllegalArgumentException("프로그램 종료");
            }
        }
    }

    }

    public void checkDuplicateNumbers(){

    }
}
