package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private UserGame usergame = new UserGame(); //UserGame 클래스 객체 생성
    private ComputerGame computergame = new ComputerGame(); // ComputerGame 클래스 객체 생성

    // 내 생각 : 1. 객체 생성한 걸로 다른 변수로 새로 만들어주기
    public void start() { // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            computergame.randomNumber();
            usergame.inputUserNum();
        } while (canRestart());

    }
    public boolean canRestart() { // 게임을 종료할건지 재시작할건지?
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine(); // input => 1 혹은 2만 가능
        return Integer.parseInt(input) == 1;
    }
}
