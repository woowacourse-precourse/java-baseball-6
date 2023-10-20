package baseball;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 시작합니다.");
        while(true)
        {
            System.out.print("숫자를 입력해주세요 : ");
            readLine();
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
        }
    }
}
