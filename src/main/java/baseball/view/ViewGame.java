package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ViewGame {

    public void viewStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

    }

    public static String enterGameNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void viewEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static String enterAnswerRestartGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        return Console.readLine();
    }


    public static void viewStrike_Ball(String Strike_Ball){
        System.out.println(Strike_Ball);
    }
}
