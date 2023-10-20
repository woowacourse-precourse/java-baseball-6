package baseball;

import java.util.Scanner;

public class Application {
    static int[] answer = {2, 2, 4};
    static int[] keyNum = new int[3];

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean inputNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int j = 100;
        for (int i = 0; i < 3; i++) {
            if (i == 0 && num/j == 0) return false;

            keyNum[i] = (int) num/j;
            num -= (num/j)*j;
            j /= 10;
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(answer[i]);
            System.out.println(keyNum[i]);
        }
        return true;
    }

//    public String returnResult(int[] numbers){
//
//    }

    public static void main(String[] args) {
        Application startGame = new Application();
        Application inputNumbers = new Application();
        startGame.startGame();

        while(true){
            boolean alert = inputNumbers.inputNumbers();
            if (!alert) break;
        }

    }
}
