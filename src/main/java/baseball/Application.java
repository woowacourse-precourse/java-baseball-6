package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        String input;
        int i, j;
        int n;

        System.out.println("숫자 야구 게임을 시작합니다.");

        //1. 랜덤한 3개의 수 생성 하기
        while(computer.size() < 3){
            n = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(n))
                computer.add(n);
        }
        //System.out.println(computer);

        //2. 사용자 값 입력 받기
        while(!computer.equals(user)) {
            System.out.println("숫자를 입력해주세요 : ");
            input = Console.readLine();
            for(i = 0; i < 3; i++)
                user.add((int) input.charAt(i));


        }
    }
}
