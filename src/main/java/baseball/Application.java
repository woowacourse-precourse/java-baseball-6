package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            int number = Randoms.pickNumberInRange(0, 9);

            while (randomNumbers.contains(number)) {

                number = Randoms.pickNumberInRange(0, 9);

            }

            randomNumbers.add(number);
        }

        


    }
}
