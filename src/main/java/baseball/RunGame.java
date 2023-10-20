package baseball;

import java.util.Scanner;
import baseball.IsMatch;

public class RunGame {
    static int[] answer = {2, 2, 4};
    static int[] keyNum = new int[3];
    
    public static void run(){
        RunGame startGame = new RunGame();
        RunGame inputNumbers = new RunGame();
        RunGame returnResult = new RunGame();
        startGame.startGame();

        while(true){
            boolean alert = inputNumbers.inputNumbers();
            if (!alert) break;
            boolean isEnd = returnResult.returnResult();
            if (isEnd) break;
        }
    }

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        IsMatch.accurateTest();
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

        return true;
    }

    public boolean returnResult(){
        RunGame finishGame = new RunGame();
        int isSame = 0;
        for (int i = 0; i < 3; i++) {
            if (answer[i] == keyNum[i]) { isSame += 1; }
        }
        if (isSame == 3) {
            finishGame.finishGame();
            return true;
        }
        else {
            System.out.println("낫싱");
            return false;
        }
    }

    public void finishGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    
}
