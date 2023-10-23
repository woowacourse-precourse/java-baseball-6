package baseball;

import java.util.Scanner;

public class BaseballGame {

    private boolean isProgress = true;
    private String randomNumber;
    private String inputNumber;

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        Scanner scanner = new Scanner(System.in);

        while (isProgress) {
            System.out.println("숫자를 입력해주세요 : ");
            inputNumber = scanner.next();
            // result = 판단
//            if (result) {
//
//            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int select = scanner.nextInt();

            if (select == 1) {
                isProgress = true;
            }
            if (select == 2) {
                isProgress = false;
            }
        }

    }
}
