package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    static final int correct_digit = 3;

    public void playGame (List<Integer> answer){
        CheckNum checknum = new CheckNum(answer);
        String result="";
        while(!result.equals("3스트라이크")){
            result = checknum.Checknum(receive());
            System.out.println(result);
        }
        return ;
    }

    public List<Integer> receive(){
        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> receive_num = new ArrayList<>();
        String tmp = Console.readLine();

        for(String num : tmp.split("")){
            receive_num.add(Integer.parseInt(num));
        }
        if(receive_num.size() != correct_digit)
            throw new IllegalArgumentException("3자리 수를 입력하세요.");

        return receive_num;
    }

}
