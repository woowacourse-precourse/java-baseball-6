package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        //1부터 9까지 서로 다른 임의의 수 3개 선택하여 정답 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        //서로 다른 3자리 수 입력받고 잘못된 값 입력 시 예외 발생 후 프로그램 종료
        List<Integer> user = new ArrayList<>();
        IllegalArgumentException exp = new IllegalArgumentException();

        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        if (str.length() != 3) {
            throw exp;
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw exp;
            } else {
                user.add(str.charAt(i) - '0');
            }
        }
        System.out.println(user);

    }
}
