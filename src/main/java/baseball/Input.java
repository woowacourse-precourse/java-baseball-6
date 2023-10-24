package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Input {
    public static List<Integer> inputnum() {
        //contain함수를 쓰기 위해 입력값도 각 자리수를 List의 원소로 사용하여 List를 만든다.

        List<Integer> numlist = new ArrayList<>();

        System.out.printf("숫자를 입력해 주세요 : ");
        String inputnum = Console.readLine();

        String[] temp = inputnum.split("");

        for(int i =0; i<inputnum.length(); i++){
            numlist.add(Integer.parseInt(temp[i]));
        }
        return numlist;
    }
}
