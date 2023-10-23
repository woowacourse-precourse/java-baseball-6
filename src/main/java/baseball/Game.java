package baseball;

import java.util.Scanner;

public class Game {
    private int firstNum;
    private int secondNum;
    private int thirdNum;

    private void inputBaseBallNumber(){
        Scanner scanner = new Scanner(System.in);
        String[] userInput = scanner.nextLine().split("");

        firstNum = Integer.parseInt(userInput[0]);
        secondNum = Integer.parseInt(userInput[1]);
        thirdNum = Integer.parseInt(userInput[2]);
    }

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        inputBaseBallNumber();
    }
}
