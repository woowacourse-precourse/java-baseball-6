package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //List<Integer> saveThreeNumbers = new ArrayList<>(3);

    public List<Integer> getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputText = Console.readLine();
        return Validator.checkThreeNumbers(inputText);

    }

    public int getWantEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputText = Console.readLine();
        return Validator.checkEndNumber(inputText);
    }

}
