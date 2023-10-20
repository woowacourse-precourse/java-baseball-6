package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //컴퓨터 랜덤값 생성 기능
        List<Integer> computer = new ArrayList<>();
//        System.out.println(computer.size());    //0
        while (computer.size() < 3) {    //0
            int randomNumber = Randoms.pickNumberInRange(1, 9); //랜덤숫자 1개
            if (!computer.contains(randomNumber)) { //컴퓨터수는 중복된 수가 없어야함
                computer.add(randomNumber);
            }
        }

        // 컴퓨터 숫자 확인
        System.out.print("computer: ");
        for (Integer integer : computer) {
            System.out.print(integer);
        }

        System.out.println();
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 사용자 값 입력 받는 기능
        // 서로 다른 3자리의 수 => 잘못된 값을 입력할 경우 예외 발생 후 종료
        // 게임이 끝난 경우 재시작/종료를 구분하는 1과 2중 하나의 수
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        System.out.println("input = " + input);



//        int strike = 0;
//        int ball = 0;
//        while (strike < 3){ // 3스트라이크가 될 때까지 반복
//            System.out.print("숫자를 입력해주세요 : ");
//        }


    }
}
