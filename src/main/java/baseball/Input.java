package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public List<Integer> playerNumber(){
        //console로 수정
        //잘못된 값 입력 시 IllegalArgumentException 발생
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<Integer> playerNum = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            playerNum.add(s.charAt(i) - '0');
        }
        return playerNum;
    }
}
