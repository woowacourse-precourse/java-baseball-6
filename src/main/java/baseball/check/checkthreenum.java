package baseball.check;

import java.util.Arrays;
import java.util.List;

public class checkthreenum implements Checknum {
    @Override
    public boolean checkIsNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean checkIsThreeDigit(String num) {
        if(num.length() == 3){
            return true;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean checkIsDuplicate(String num) {
        char cc = 'a';
        for(char c : num.toCharArray()){
            if(cc == c){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
    @Override
    public boolean checkIsOneToNine(String num){

        List<Integer> digit = Arrays.asList(1,2,3,4,5,6,7,8,9);
        for(char c : num.toCharArray()){
            c -= '0';
            if(!digit.contains(c))
                throw new IllegalArgumentException();
        }
        return true;
    }
}
