package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        //랜덤 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        //사용자 숫자 입력(맞을 때까지 반복)
        //잘못 입력 시 (IllegalArgumentException 발생)
            Scanner sc = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요 : ");
            String input = sc.next();
            String[] user = input.split("");


            int strike = 0;
            int ball = 0;

            for(int i = 0; i < user.length; i ++){
                if (computer.get(i).equals(Integer.valueOf(user[i]))) {
                    System.out.println("Contain!");
                }
            }
    }
}
