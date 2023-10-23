package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean game = true;
        while(game) {
            Computer computer = new Computer();
            computer.createNumber();

            Player player = new Player();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = camp.nextstep.edu.missionutils.Console.readLine();
                List<Integer> guess = player.makeGuess(input);

                Judge judge = new Judge(computer.answer, guess);
                judge.calcResult();
                judge.printResult();

                if(judge.isCorrect()) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String restart = camp.nextstep.edu.missionutils.Console.readLine();
                    if (restart.equals("1")) {
                        break;
                    } else if (restart.equals("2")) {
                        game = false;
                        break;
                    } else {
                        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
                    }
                }
            }
        }
    }
}
