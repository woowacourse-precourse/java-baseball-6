package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class StartGame {

    /**
     * 플레이어의 숫자를 입력받는 메서드 입니다.
     */
    public List<Integer> PlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        List<Integer> playerNumbers = new ArrayList<>();

        for(String number : input.split("")){
            playerNumbers.add(Integer.parseInt(number));
        }

        if(playerNumbers.size() != 3){
            throw new IllegalArgumentException();
        }
        return playerNumbers;
    }

    /**
     * 게임을 다시시작 할지에 대한 여부를 묻는 메서드 입니다.
     */
    public boolean isGameStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();;

        if(input.equals("1")){
            return true;
        }

        return false;
    }
}
