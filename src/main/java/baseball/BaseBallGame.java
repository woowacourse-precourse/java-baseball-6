package baseball;

import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
    RandomNumberPicker randomNumberPicker = new RandomNumberPicker();
    Scanner scanner = new Scanner(System.in);

    public void play() {
        List<Integer> randomNums = randomNumberPicker.pickRandomNums();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            String input_str = scanner.next();
            List<Integer> user_nums = StringToIntegerList.turnToIntList(input_str);

        }

    }



    public void compareWithAnswer(){

    }


}
