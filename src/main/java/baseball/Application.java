package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {


//        System.out.println("숫자 야구 게임을 시작합니다.");
//        System.out.print("숫자를 입력해주세요 : ");
//        String str = Console.readLine();
//        String[] strings = str.split("");
//
//        for (int i = 0; i < strings.length; i++){
//
//        }

        List<Integer> computer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            computer.add(Randoms.pickNumberInRange(1, 9));
        }

        System.out.println("컴퓨터 숫자 : "+computer);

//        System.out.println("입력한 숫자: " + str);
    }
}
