package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { //중복 제거
                computer.add(randomNumber);
            }
        }

        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();

        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < userNumber.length(); i++) {
            int temp = userNumber.charAt(i) - '0';

            if ((temp >= 1 && temp <= 9 && user.size() < 3 && !(user.contains(temp)))) {
                user.add(temp);

            }
            else {
                throw new IllegalArgumentException();
            }

        }
        
        if (!(user.size() == 3)) {
            throw new IllegalArgumentException();
        }

    }

}