package baseball;

import baseball.model.ComputerNumbers;
import baseball.model.RestartInputNumber;
import baseball.model.UserNumbers;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    public void play() {
        ComputerNumbers computerNums = new ComputerNumbers();
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input_str = Console.readLine();
            UserNumbers userNums = new UserNumbers(input_str);
            if(CompareWithAnswer.compareWithAnswer(computerNums,userNums)){
                return;
            }
        }
    }

    public boolean isRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input_num = Console.readLine();
        return new RestartInputNumber(input_num).isRestart();
    }
}
