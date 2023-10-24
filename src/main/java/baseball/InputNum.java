package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputNum {
    private List<Integer> num;

    public InputNum() { //사용자 입력 받아 List 에 넣음
        this.num = input();
    }

    private List<Integer> input() {
        String s = readLine();

        if (s.length()!=3) throw new IllegalArgumentException();

        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Integer num = s.charAt(i) - '0';
            if(num<1 || num>9) throw new IllegalArgumentException(); //입력한 단어가 1~9사이의 숫자가 아니라면 에러
            if(input.contains(num)) throw new IllegalArgumentException(); //숫자를 중복해서 입력할 경우 에러

            input.add(num);
        }

        return input;
    }


    public Integer[] compare(RandomNum randomNum) {
        Integer[] counting = {0, 0}; // 0:볼 ,1:스트라이크

        for (int i = 0; i < 3; i++) {
            int answerNum = randomNum.getNum(i);
            int inputNum = num.get(i);

            if(answerNum==inputNum) counting[1]++; //스트라이크
            if(num.contains(answerNum) && answerNum!=inputNum) counting[0]++; //볼
        }

        return counting;
    }
}
