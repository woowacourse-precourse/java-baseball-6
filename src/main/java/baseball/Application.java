package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean[] temp = new boolean[10];
        while(true) {
            int val = Randoms.pickNumberInRange(0,8) + 1;
            System.out.println(val);
            temp[val] = true;
            int cnt = 0;
            for(int i = 1; i < 10; i++) {
                if(temp[i]) { cnt++; }
            }
            if(cnt == 9) { break; }

        }
        System.out.println("done");

    }
}
