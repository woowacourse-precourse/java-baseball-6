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

        HashMap<Integer, Integer> map = new HashMap();

        for (int k = 0; k < user.size(); k++) {
            map.put(computer.get(k), user.get(k));
        }
        int ball = 0;
        int strike = 0;
        for (int m = 0; m < user.size(); m++) {
            if (map.containsKey(user.get(m)) == true) {
                ball++;
                if (user.get(m) == map.get(user.get(m))) {
                    ball--;
                    strike++;
                }
            }
        }
        switch (strike) {
            case 3:
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            default:
                if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                    break;
                }
                System.out.println(ball + "볼 " + strike + "스트라이크");
        }

    }

}