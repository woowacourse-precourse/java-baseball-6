package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 정답(3자리 숫자) 생성
        List<Integer> target = new ArrayList<>();
        while (target.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(randomNumber)) {
                target.add(randomNumber);
            }
        }

        // 게임 시작, 입력 받기
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String ans = Console.readLine();

        // 입력 유효성 검사 1. 빈 입력값 확인
        if (ans.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }
}
