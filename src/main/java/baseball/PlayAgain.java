package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class PlayAgain {
    public boolean playAgain(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        char answer = input.charAt(0);

        if(answer == '1'){
            return true;
        }
        return false;
    }
}
