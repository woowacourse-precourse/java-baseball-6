package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class NumberBaseball {

    int[] answer;
    boolean[] generatedNumberFlag;

    public NumberBaseball() {
        this.generatedNumberFlag = new boolean[10];
        this.answer = new int[3];
    }

    public void generateAnswerNumber() {
        for(int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if(this.generatedNumberFlag[number]) {
                i--;
                continue;
            }
            answer[i] = number;
            generatedNumberFlag[number] = true;
        }
    }

    
}
