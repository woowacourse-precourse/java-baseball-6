package baseball.view;

import baseball.controller.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

//유저에게 보이는 UI를 제공하고 입력 받음
public class BaseballStadium {
    static String start = "1";
    static String result = "";

    public static void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (start.equals("1")){
            BaseballGame.pitcherPitch();
            while(!result.equals("3스트라이크")){
                result = BaseballGame.compareNumbers(inputNum());
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            start = continewGame();
        }


    }

    public static String inputNum(){
        System.out.println("숫자를 입력해주세요 : ");

        return Console.readLine();
    }
    public static String continewGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return Console.readLine();
    }


}
