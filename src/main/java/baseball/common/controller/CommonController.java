package baseball.common.controller;

import camp.nextstep.edu.missionutils.Console;

public class CommonController {

    //야구 시작 -> 정답 생성
    private void baseballStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    //야구 종료 -> 재시작 or 종료
    private int baseballEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        //1,2번이 입력될 때까지 재귀
        if(!input.equals("1")&&!input.equals("2")) return baseballEnd();

        return Integer.parseInt(input);
    }
}
