package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Integer> computer;

    public static void main(String[] args) {

        genNumbers();
        System.out.println(computer);

    }

    static void genNumbers() {

        computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            //1부터 9까지의 난수 중 중복되지 않게 3개의 난수를 computer라는 리스트에 집어넣음.
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

    }
}
