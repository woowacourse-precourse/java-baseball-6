package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Controller {
    private final Player player;
    private final Computer computer;

    public Controller() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        player = new Player(Integer.parseInt(Console.readLine()));
        player.validateNumber(player);
        int firstNumber = Randoms.pickNumberInRange(1, 9);
        int secondNumber = Randoms.pickNumberInRange(1, 9);
        int thirdNumber = Randoms.pickNumberInRange(1, 9);
        computer = new Computer(firstNumber, secondNumber, thirdNumber);
        System.out.println("player num: " + player.player_num);
        System.out.println("computer num: " + computer.createNumber(firstNumber, secondNumber, thirdNumber));
    }

    void checkStrike(int[] player_numbers, int[] computer_numbers) {
        int count = 0;
        for (int i = 0; i < player_numbers.length; i++) {
            if (player_numbers[i] == computer_numbers[i]) {
                count++;
            }
        }
        if (count != 0) {
            System.out.print(count + "스트라이크");
        }
    }

    void checkNothing(int[] player_numbers, int[] computer_numbers) {
        int[] newArray = new int[player_numbers.length + computer_numbers.length];
        System.arraycopy(player_numbers, 0, newArray, 0, player_numbers.length);
        System.arraycopy(computer_numbers, 0, newArray, player_numbers.length, computer_numbers.length);
        Set<Integer> newSet = new HashSet<>();
        for (int i : newArray) {
            newSet.add(i);
        }
        if (newSet.size() == 6) {
            System.out.println("낫싱");
        }
    }


    void checkBall(int[] player_numbers, int[] computer_numbers) {
        int count = 0;
        int[] newArray = new int[player_numbers.length + computer_numbers.length];
        System.arraycopy(player_numbers, 0, newArray, 0, player_numbers.length);
        System.arraycopy(computer_numbers, 0, newArray, player_numbers.length, computer_numbers.length);
        Set<Integer> newSet = new HashSet<>();
        for (int i : newArray) {
            newSet.add(i);
        }
        if (newSet.size() < 6) {
            count = 6 - newSet.size();
            System.out.print(count + "볼");
        }

    }
}
