package view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_STRING = "숫자를 입력해주세요 : ";
    private static final String EXIT_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    // 숫자 답 입력
    public String inputAns() {
        System.out.println(START_STRING);
        System.out.print(INPUT_STRING);
        String ans = Console.readLine();

        return ans;
    }


    // 종료 여부 입력
    public String inputExit() {
        System.out.println(EXIT_STRING);
        String ans = Console.readLine();

        return ans;
    }
}
