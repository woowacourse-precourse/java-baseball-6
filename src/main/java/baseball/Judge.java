package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Judge {
    private Player computer;
    private Player human;

    public Judge(Player computer, Player human) {
        this.computer = computer;
        this.human = human;
    }

    private int[] checkStrikesBalls(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                balls++;
            }
        }
        return new int[]{strikes, balls};
    }

    private void showHints(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }

        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        System.out.println();
    }

    public boolean startGame() {
        try {

            boolean gameWin = false;
            List<Integer> computerNumbers = computer.getNumbers();

            while (!gameWin) {
                List<Integer> playerNumbers = human.getNumbers();

                int[] hints = checkStrikesBalls(computerNumbers, playerNumbers);
                int strikes = hints[0];
                int balls = hints[1];

                showHints(strikes, balls);

                gameWin = (strikes == 3);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String choice = Console.readLine();

            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                throw new IllegalAccessException();
            }


        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
