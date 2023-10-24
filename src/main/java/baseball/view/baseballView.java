package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class baseballView {
    String Start = "숫자 야구 게임을 시작합니다.";
    String Insert = "숫자를 입력해주세요 : ";
    String End = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startConsole() { //게임 시작 부분
        System.out.println(Start);
    }

    public String insertConsole() {// 게임 사용자 입력 부분
        System.out.print(Insert);
        return Console.readLine();
    }

    public String endConsole() {// 재시작/종료 여부 판단 부분
        System.out.println(End);
        return Console.readLine();
    }

    public void resultConsole(String result) { //결과 판단 부분
        System.out.println(result);
    }

    public void closeConsole() { //게임 종료 -> 콘솔 종료
        Console.close();
    }
}
