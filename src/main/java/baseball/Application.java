package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        int i, j;
        int n;

        //1. 랜덤한 3개의 수 생성하기
        while(computer.size() < 3){
            n = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(n))
                computer.add(n);
        }
        //System.out.println(computer);

        //2. 사용자 값 입력받기
    }
}
