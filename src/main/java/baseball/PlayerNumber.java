package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

    Exception exception = new Exception();

    public List<Integer> getPlayer() throws IllegalArgumentException{
        // 플레이어의 숫자를 입력받는 메소드
        String inputNumber = Console.readLine();
        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < Constant.gameNumberLength; i++) {
            player.add(Integer.parseInt(inputNumber.substring(i, i + 1)));
        }

        // 플레이어 숫자 자리수가 초과되었을 때 예외 송출
        exception.Exception_PlayerNumberLength(inputNumber);
        return player;
    }
}