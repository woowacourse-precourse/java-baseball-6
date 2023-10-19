package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int DIGIT = 3;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        List<Integer> pickedList = selectDigitNumbers(DIGIT);
        assert(pickedList.stream().distinct().count() == DIGIT);
    }

    public static List<Integer> selectDigitNumbers(int digit){
        List<Integer> pickedList = new ArrayList<>();
        while(pickedList.size() < digit){
            int pickedRandomNum = Randoms.pickNumberInRange(1, 9);
            if(pickedList.contains(pickedRandomNum)) continue;
            pickedList.add(pickedRandomNum);
        }
        return pickedList;
    }
}
