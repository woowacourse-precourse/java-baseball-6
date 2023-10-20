package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");     // 프로그램 시작

        List<Integer> computer = new ArrayList<>();     // 컴퓨터에게 랜덤 숫자 생성하기
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String num = Console.readLine();        // 사용자에게 숫자를 입력받기

            if (num.length() != 3) throw new IllegalArgumentException();    // 예외처리

            char[] checkDup = num.toCharArray();        // 예외처리
            HashMap<Character, Integer> hm = new HashMap<>();
            for (char c : checkDup) {
                if (!hm.containsKey(c)) {
                    hm.put(c, 0);
                } else {
                    throw new IllegalArgumentException();
                }
            }

            List<Integer> userNum = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                userNum.add(Character.getNumericValue(num.charAt(i)));
            }

            System.out.println(userNum + " " + computer);
        }
    }
}

