package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // 랜덤 3자리 수 만들기
    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 사용자 3자리 수 입력 받기
    public static List<Integer> userNumber() {
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        checkValue(input);
        for(int i=0; i<3; i++) {
            user.add(input.charAt(i) - '0');
        }
        return user;
    }

    // 사용자 숫자 사용 가능 여부 확인
    public static void checkValue(String input) {
        // 3자리가 아닌 경우 사용 불가능
        if(input.length() != 3) throw new IllegalArgumentException();

        // 1~9 숫자 이외의 값을 입력한 경우 사용 불가능
        for(int i=0; i<3; i++) {
            char c = input.charAt(i);
            if (c > '9' || c < '1') throw new IllegalArgumentException();
        }

        // 중복된 숫자를 입력한 경우 사용 불가능
        if(input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2)
                || input.charAt(0) == input.charAt(2)) throw new IllegalArgumentException();
    }
}
