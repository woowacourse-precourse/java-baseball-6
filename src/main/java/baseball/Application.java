package baseball;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Application {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final int START_NUM = 1;
        int num = START_NUM;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (num == START_NUM) {
            startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            num = Integer.parseInt(br.readLine());
        }


    }
    public static void startGame() throws IOException {
        System.out.print("숫자를 입력해 주세요 : ");
        String str = br.readLine();
        //예외처리 (1)3자리가 아니거나 숫자가 아니거나
        if(!check(str)) throw new IllegalArgumentException();
        //게임로직시작
        numberBasketballGame();
    }
    //사용자가 제대로된 값을 입력했는지 확인하는 여부
    public static boolean check(String str){
        if(str.length() != 3) return false;
        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
    public static void numberBasketballGame() {

    }
    public static void printResult(){

    }
}
