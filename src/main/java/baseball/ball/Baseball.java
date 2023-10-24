package baseball.ball;

import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    private String number = new String();

    public Baseball(int max_value, int min_value){
        while(number.length() < 3){
            String random = String.valueOf(Randoms.pickNumberInRange(min_value, max_value));
            if(!number.contains(random)) number += random;
        }
    }

    public String getNumber() {
        return number;
    }
}
