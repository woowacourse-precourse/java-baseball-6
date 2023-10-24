package baseball;

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
        }

        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        System.out.println();
    }


}
