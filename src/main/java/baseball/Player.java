package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Player {
    ExceptionUtil exceptionUtil = new ExceptionUtil();

    public List<Integer> player() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        exceptionUtil.checkException(userInput); //오류체크
        List<Integer> integerList = new ArrayList<>(); //입력받은 문자열 숫자를 정수형으로 List에 추가
        for (String s : userInput.split("")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }

    public boolean newGame() { //게임이 종료된 이후 재시작할건지 종료할건지 입력하는 기능
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        exceptionUtil.checkOneOrTwoException(userInput); //1이나 2인지 체크
        if (userInput.equals("2")) {
            return true;
        }
        return false;
    }
}
