package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        game Baseball = new game();

        while (true) {
            setComputer setCom = new setComputer();
            Baseball.result(setCom.setRandom());
            System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");
            if (Integer.parseInt(Console.readLine()) == 2)
                break;
        }
    }
}