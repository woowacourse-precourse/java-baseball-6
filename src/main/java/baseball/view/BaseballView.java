package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class BaseballView {
    String start = "숫자 야구 게임을 시작합니다.";
    String insert = "숫자를 입력해주세요 : ";
    String end = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startConsole() { //게임 시작 부분
        System.out.println(start);
    }

    public String insertConsole() {// 게임 사용자 입력 부분
        System.out.print(insert);
        return Console.readLine();
    }

    public String getEndConsole() {// 재시작/종료 여부 판단 부분
        System.out.println(end);
        return Console.readLine();
    }

    public void getResultConsole(String result) { //결과 판단 부분
        System.out.println(result);
    }

    public void closeConsole() { //게임 종료 -> 콘솔 종료
        Console.close();
    }
}
