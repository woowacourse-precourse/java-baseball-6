package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setNewNumbers();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = true;
        while (flag) {
            System.out.print("숫자를 입력해주세요 : ");
            Player player = new Player(Console.readLine());
            player.setNumbers();
            if (computer.getResult(player.getNumbers())) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String newGame = Console.readLine();
                switch (newGame) {
                    case "1" -> computer.setNewNumbers();
                    case "2" -> {
                        System.out.println("게임 종료");
                        flag = false;
                    }
                    default -> throw new IllegalArgumentException();
                }
            }
        }
    }
}
