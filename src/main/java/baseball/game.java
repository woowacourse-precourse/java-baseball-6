package baseball;

import java.util.List;

public class game {

    numInput ni = new numInput();
    judge jg = new judge();
    void result (List<Integer> ran){
        while(true) {
            if(jg.judgement(ni.userNum(), ran)==3)
                break;
        }
    }
}