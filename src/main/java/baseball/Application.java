package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.internal.IntArrays;

public class Application {
    public static void main(String[] args) {

        //정답이 될 3개의 숫자를 만들기
        int[] answer = new int[3];
        for(int i=0;i<3;i++){
            answer[i] = Randoms.pickNumberInRange(1, 9);
            for(int j=0; j < i && answer[j] == answer[i]; j++){
                answer[i] = Randoms.pickNumberInRange(1, 9);
                j=0;
            }
        }

    }
}
