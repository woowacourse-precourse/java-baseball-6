package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> randomnumber = new ArrayList<>();
        List<Integer> inputnumber = new ArrayList<>();
        int[] count = new int[2]; // 첫번째는 스트라이크 카운트, 두번째는 볼카운트
        int quit = 0;
        Computer computer = new Computer();
        Referee referee = new Referee();
        User user = new User();

        randomnumber = computer.makecomputernumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(quit != 2){
            System.out.printf("숫자를 입력해주세요 : ");
            inputnumber = user.saveinput(Integer.parseInt(Console.readLine()));
            count = referee.judgecount(inputnumber, randomnumber);
            quit = referee.printcount(count);
            if(quit == 1){
                randomnumber = computer.makecomputernumber();
            }
            else if(quit == 2){
                quit = 2;
            }
        }
        return;
    }
}
