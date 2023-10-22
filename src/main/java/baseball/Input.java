package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public List<Integer> playerNumber(){
        ErrorExcept error = new ErrorExcept();
        System.out.println("숫자를 입력해주세요");
        String scanner = Console.readLine();
        error.ErrorIllegal(scanner);
        List<Integer> playerNum = new ArrayList<>();


        for(String number:scanner.split("")){
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }
}
