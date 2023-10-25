package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        game();
    }

    static void game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        continueGame(setComputerNum());
    }

    static List<Integer> setComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void continueGame(List<Integer> computer) throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> user = getPlayerNum();
        printResult(computer, user);
    }

    static List<Integer> getPlayerNum() {
        List<Integer> player = new ArrayList<>();
        char[] user_chArr = Console.readLine().toCharArray();
        for (char character : user_chArr) {
            int num = character - '0';
            //서로 다른 수가 아닌 경우
            if (player.contains(num)) {
                throw new IllegalArgumentException();
            } else {
                player.add(num);
            }
        }
        //숫자 3개가 아닌 경우
        if (player.size() != 3) throw new IllegalArgumentException();
        //숫자가 아닌 경우
        for (int i = 0; i < 3; i++) {
            if (!(1 <= player.get(i) && player.get(i) <= 9)) {
                throw new IllegalArgumentException();
            }
        }
        return player;
    }

    static void printResult(List<Integer> computer, List<Integer> player) throws IllegalArgumentException {
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            } else if (player.contains(computer.get(i))) {
                ball++;
            }
        }
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameOver();
            return;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        continueGame(computer);
    }

    static void gameOver() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            continueGame(setComputerNum());
        } else if (!input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}