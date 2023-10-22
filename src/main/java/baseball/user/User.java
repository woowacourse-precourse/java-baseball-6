package baseball.user;

import baseball.io.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class User {

    public ArrayList<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return Converter.convertToUniqueIntList(userInput, 3);
    }

    public boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        int select = Converter.convertIntWithRange(userInput, 1, 2);

        return select == 1;
    }


}
