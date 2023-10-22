package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 정답 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) computer.add(randomNumber);
        }

        // 정답 입력
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!input.matches("^(?!.*(.).*\\1)[1-9]{3}$")) throw new IllegalArgumentException("서로 다른 3개의 숫자를 공백 없이 입력해 주세요.");
        
    }
}
