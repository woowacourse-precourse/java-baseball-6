package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        Integer answer1 = Randoms.pickNumberInRange(1, 9);
        Integer answer2 = Randoms.pickNumberInRange(1, 9);
        Integer answer3 = Randoms.pickNumberInRange(1, 9);

        String answer1String = answer1.toString();
        String answer2String = answer2.toString();
        String answer3String = answer3.toString();

        System.out.println("answer : " + answer1String + answer2String + answer3String);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            List<Character> inputList = new ArrayList<>();

            for (char ch : input.toCharArray()) { 
  
                inputList.add(ch); 
            } 

            System.out.println("입력값 : " + inputList.get(0) + inputList.get(1) + inputList.get(2));

        }

    }
}
