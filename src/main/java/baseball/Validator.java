package baseball;

import java.util.List;

public class Validator {

    public int[] validate(List<Integer>userNumbers,List<Integer>computer) {
        int strikes = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computer.get(i))){
                strikes++;
            }else if(userNumbers.contains(computer.get(i))){
                ball++;
            }
        }
        int[] result ={strikes,ball};
        return result;
    }

}




