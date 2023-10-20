package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // 게임 시작을 사용자에게 알린다.
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 숫자 랜덤 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.println(randomNumber);
            }
        }

        // 사용자 숫자 입력
        List<Integer> user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) throw new IllegalArgumentException("세 자리 숫자가 아니다.");

        for (int i = 0; i < 3; i++) {
            char splitInput = input.charAt(i);
            if (!Character.isDigit(splitInput) || splitInput == '0')
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력하세요");

            int inputInt = Character.getNumericValue(splitInput);
            if (user.contains(inputInt)) throw new IllegalArgumentException("같은 숫자가 존재한다");
            user.add(inputInt);
        }

        int s = 0, b = 0;

        // 컴퓨터의 수와 사용자의 수 비교
        for (int i = 0; i < 3; i++) {
            int num = user.get(i);
            if (computer.contains(num)) {
                if (computer.get(i) == num) s++;
                else b++;
            }
        }

        if (s == 0 && b == 0) System.out.println("낫싱");
        else if (s != 0 && b != 0) System.out.println(b + "볼 " + s + "스트라이크");
        else if (b == 0) System.out.println(s + "스트라이크");
        else if (s == 0) System.out.println(b + "볼");
        else System.out.println("낫싱");


        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


    }

}
