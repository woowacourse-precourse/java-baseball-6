package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Player player = new Player(Integer.parseInt(Console.readLine()));
        player.validateNumber(player);
        int[] player_numbers = Stream.of(String.valueOf(player.player_num).split("")).mapToInt(Integer::parseInt)
                .toArray();
        player.checkDuplicates(player_numbers);
        int firstNumber = Randoms.pickNumberInRange(1, 9);
        int secondNumber = Randoms.pickNumberInRange(1, 9);
        int thirdNumber = Randoms.pickNumberInRange(1, 9);
        Computer computer = new Computer(firstNumber, secondNumber
                , thirdNumber);
        int[] computer_numbers = Stream.of(
                        String.valueOf(computer.createNumber(firstNumber, secondNumber, thirdNumber)).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        Controller controller = new Controller();
        controller.checkStrike(player_numbers, computer_numbers);
        controller.checkNothing(player_numbers, computer_numbers);
        controller.checkBall(player_numbers, computer_numbers);
        System.out.println("player num: " + player.player_num);
        System.out.println("computer num: " + computer.createNumber(firstNumber, secondNumber, thirdNumber));


    }
}
