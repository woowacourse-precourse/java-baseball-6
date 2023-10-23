package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.lang.Object;

public class Application {
    public static int RanNumber() {
        ArrayList<Integer> randomNumArray = new ArrayList<>();
        while(randomNumArray.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);

            if(!randomNumArray.contains(randomNumber)) {
                randomNumArray.add(randomNumber);
            }
        }

        int answer = 100 * randomNumArray.get(0) + 10 * randomNumArray.get(1) + randomNumArray.get(2);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        //랜덤 세 자리 수를 생성하는 함수
        System.out.println(RanNumber());
    }
}
