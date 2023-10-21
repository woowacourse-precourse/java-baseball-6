package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {

    /**
     * 플레이어의 숫자를 입력받는 메서드 입니다.
     */
    public List<Integer> PlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");

        Scanner scanner = new Scanner(System.in);

        List<Integer> playerNumbers = new ArrayList<>();
        String input = scanner.next();

        for(String number : input.split("")){
            playerNumbers.add(Integer.parseInt(number));
        }

        return playerNumbers;
    }
}
