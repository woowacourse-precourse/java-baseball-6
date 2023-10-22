package baseball.check;

import java.util.ArrayList;
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

    // ?? ???? 1?? 9?? ???? ??? ???, ????? ?? ???
    // 1?? 9?? ?? ?????? ??? ??? ???.
    @Override
    public boolean checkIsDuplicate(String num) {
        //new ArrayList? ?? ?? ? remove ?? ??
        List<Integer> digit = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for(char c : num.toCharArray()){
            int oneDigit = c - '0';

            if(!digit.contains(oneDigit)){
                throw new IllegalArgumentException();
            }

            digit.remove(digit.indexOf(oneDigit));
        }
        return true;
    }


}
