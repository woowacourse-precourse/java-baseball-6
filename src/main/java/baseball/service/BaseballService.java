package baseball.service;

public class BaseballService {

    public void verifyException(String number){

        if(number.length() != 3){
            throw new IllegalArgumentException();
        }

        for(char x : number.toCharArray()){
            if(x -'0' < 0 || x -'0' > 9){
                throw new IllegalArgumentException();
            }
        }
    }
}
