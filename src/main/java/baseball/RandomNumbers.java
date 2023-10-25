package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private RandomNumbers(){ };
    // 숫자 야구가 3자리 숫자까지 있음.

    public static ArrayList<Integer> getRandomNumbers(int size){
        // 숫자를 저장할 컴퓨터의 array 리스트 만들기
        ArrayList<Integer> answerList = new ArrayList<>();

        // 숫자가 중복되면 넣지 말고 중복되지 않으면 넣기
        do {
            int temp = Randoms.pickNumberInRange(1,9);
            if (!answerList.contains(temp)){
                answerList.add(temp);
            }
            else{ continue; }
        }
        while (answerList.size() < size);

        return answerList;
    }
}
