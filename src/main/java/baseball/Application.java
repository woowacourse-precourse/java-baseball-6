package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();
        boolean isEnd = false;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!isEnd) {
            gameMaster.playGame(); // 정답맞추면 다음으로 진행
            isEnd = resetOrExit();
        }
    }

    private static boolean resetOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        if (input.equals("1"))
            return false;
        if (input.equals("2"))
            return true;
        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
}
