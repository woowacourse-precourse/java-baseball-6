package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        // 컴퓨터 숫자 랜덤 뽑기
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        // 사용자 숫자 입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        String[] user = userNumber.split("");
        if (userNumber.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
        }
        // 숫자 범위 미달, 초과 예외 처리
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자를 입력해야 합니다.");
        }
        // 숫자 중복 예외 처리
        if (user[0].equals(user[1])) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력해야 합니다.");
        } else if (user[1].equals(user[2])) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력해야 합니다.");
        } else if (user[2].equals(user[0])) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력해야 합니다.");
        }
        // Null값 예외 처리
        if (user[0].equals(" ")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}