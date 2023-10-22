package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Player player = new Player(Integer.parseInt(Console.readLine()));
        player.validateNumber(player);
        Computer computer = new Computer(Randoms.pickNumberInRange(1, 9) * 100 + Randoms.pickNumberInRange(1, 9) * 10 + Randoms.pickNumberInRange(1, 9));
        System.out.println("player num: "+player.player_num);
        System.out.println("computer num: "+computer.computer_num);


    }
}
