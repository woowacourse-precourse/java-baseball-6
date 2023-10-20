package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Set<Integer> computerSet = new HashSet<>();
        while (computerSet.size() < 3) {
            computerSet.add(Randoms.pickNumberInRange(1, 9));
        }
        List<Integer> computer = new ArrayList<>(computerSet);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String readNumber = Console.readLine();
        Integer.parseInt(readNumber);
    }
}
