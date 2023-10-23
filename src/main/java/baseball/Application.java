package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력 받은 내용을 처리하거나 출력하기
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);


        System.out.println("숫자 야구 게임을 시작합니다.");

//        while(true){
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = readLine();

            System.out.println("사용자가 입력한 값: " + userInput);


//        }



    }
}
