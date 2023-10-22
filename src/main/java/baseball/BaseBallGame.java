package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    RandomNumberPicker randomNumberPicker = new RandomNumberPicker();

    public void play() {
        List<Integer> randomNums = randomNumberPicker.pickRandomNums();

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input_str = Console.readLine();
            List<Integer> user_nums = StringToIntegerList.turnToIntList(input_str);

            if(CompareWithAnswer.compareWithAnswer(randomNums,user_nums)){
                return;
            }
        }
    }

    public boolean isRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input_num = Console.readLine();
        if(input_num.equals("1"))
            return true;
        else
            return false;
    }
}
