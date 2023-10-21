package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        while (true) {
            List<Integer> computer = getComputerNumber();

            while(true)
            {
                List<Integer> player = getPlayerNumber();

                BallCount ballCount = BallCount.createBallCount(computer, player);

                if(ballCount.getBallCountType() == BallCountType.STRIKEOUT){
                    ballCount.printStrikeOut();
                    break;
                }
                switch (ballCount.getBallCountType()) {
                    case NOTHING -> ballCount.printNothing();
                    case STRIKE_AND_BALL -> ballCount.printBallAndStrike();
                    case ONLY_BALL -> ballCount.printOnlyBall();
                    case ONLY_STRIKE -> ballCount.printOnlyStrike();
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String fin = Console.readLine();
            if (fin.equals("1")) {
            } else if (fin.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException();
            }

        }
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> getPlayerNumber() {
        List<Integer> player = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        final char[] playerInput = Console.readLine().toCharArray();

        if (playerInput.length > 3){
            throw new IllegalArgumentException();
        }

        for (int c : playerInput) {
            int i = c - 48;
            if(player.contains(i)){
                throw new IllegalArgumentException();
            }
            player.add(i);
        }

        return player;
    }
}
