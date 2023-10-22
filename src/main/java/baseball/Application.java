package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        /**
         * 1~9로 이루어진 서로 다른 3자리 수 생성
         * computer 리스트에 3개의 수를 저장
         */
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            System.out.print(randomNumber);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}