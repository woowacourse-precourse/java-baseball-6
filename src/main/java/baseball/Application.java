package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        RandomNum randomNum = new RandomNum();
        Input input = new Input();
        DisplayCount displayCount = new DisplayCount();
        Regame regame = new Regame();
        boolean again = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (again){
            List<Integer> computer = randomNum.create();
            String result = "";
            while(!result.equals("3스트라이크")){
                result = displayCount.displayCount(computer,input.playerNumber());
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            again = regame.reGame();
        }

    }









}
