package baseball;

import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
    RandomNumberPicker randomNumberPicker = new RandomNumberPicker();
    Scanner scanner = new Scanner(System.in);

    public void play() {
        List<Integer> randomNums = randomNumberPicker.pickRandomNums();
        System.out.print(randomNums.get(0));
        System.out.print(randomNums.get(1));
        System.out.println(randomNums.get(2));

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input_str = scanner.nextLine();
            List<Integer> user_nums = StringToIntegerList.turnToIntList(input_str);

            if(CompareWithAnswer.compareWithAnswer(randomNums,user_nums)){
                return;
            }
        }
    }

    public boolean isRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input_num = scanner.nextLine();
        if(input_num.equals("1"))
            return true;
        else
            return false;
    }
}
