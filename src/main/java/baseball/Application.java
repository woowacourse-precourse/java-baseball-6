package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.\n" +
                "숫자를 입력해주세요: ");
        String initial = Console.readLine();
        game:while(inputCheck(initial)){
        String processed = initial.trim().replaceAll("\\s+", "");
        boolean toContinue = inputCheck(initial);
        if(!inputCheck(initial)){
            throw new IllegalArgumentException();
        }
        int[] target = new int[3];
        for(int i=0;i<3;i++){
            target[i]= Randoms.pickNumberInRange(1,9);
        }
//            System.out.println(Arrays.toString(target));
        while (toContinue){

            int ball=0;
            int strike=0;
            if(target[1]==processed.charAt(0)-'0'){
                ball+=1;
            }
            if(target[2]==processed.charAt(0)-'0'){
                ball+=1;
            }
            if(target[0]==processed.charAt(1)-'0'){
                ball+=1;
            }
            if(target[2]==processed.charAt(1)-'0'){
                ball+=1;
            }
            if(target[0]==processed.charAt(2)-'0'){
                ball+=1;
            }
            if(target[1]==processed.charAt(2)-'0'){
                ball+=1;
            }

            for(int i=0;i<3;i++){
                if(target[i]==processed.charAt(i)-'0') {
                    strike += 1;
                }
            }
            System.out.println(ball>0?ball+"볼 ":(strike>0?strike+"스트라이크":"낫싱"));
            if(strike==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                int next = Integer.parseInt(Console.readLine());
                Console.readLine();
                if(next==1){
                    System.out.println("숫자 야구 게임을 시작합니다.\n" +
                            "숫자를 입력해주세요: ");
                    initial = Console.readLine();
                    continue game;
                } else if (next==2) {
                    return;
                }
            }
            System.out.println("strike: "+strike+" ball: "+ball);
            System.out.println("숫자를입력해주세요");
            initial =Console.readLine();
            processed = initial.trim().replaceAll("\\s+", "");
            toContinue=inputCheck(initial);
            if(!inputCheck(initial)){
                throw new IllegalArgumentException();
            }
        }
        }

    }

    public static boolean inputCheck(String input) {
        String processed = input.trim().replaceAll("\\s+", "");
        boolean isNumbers = false;
        if (processed.length() != 3) {
            return isNumbers;
        } else {
            for (int i = 0; i < 3; i++) {
                if (processed.charAt(i) >= '0' && processed.charAt(i) <= '9') {
                    isNumbers = true;
                } else {
                    isNumbers = false;
                    break;
                    //processed.charAt(i) < '0' || processed.charAt(i) > '9';
                }

            }
        }
        return isNumbers;
    }

}
