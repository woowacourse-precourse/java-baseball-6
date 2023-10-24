package baseball;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.*;
import java.util.List;

public class RerunOrNot {
    public static void reGameStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int ifReGame = Integer.parseInt(Console.readLine());

        if(ifReGame == 1){
            List<Integer> userBalls = UserBalls.inputBalls();
            List<Integer> newComputerBalls = ComputerBalls.inputComputerBalls();

            Battle.startBaseball(userBalls, newComputerBalls);
        } else if (ifReGame ==2) {
        } else{
            throw new IllegalArgumentException("1 또는 2를 입력하세요");
        }

    }
}
