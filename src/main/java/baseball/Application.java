package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        Player player = new Player();

        // 1. 랜덤하게 숫자 1~9 로 이루어진 3자리 숫자 생성
        computer.setRandomNums();
        System.out.println("computer.getNumbers() = " + computer.getNumbers());

        // 2. 숫자 입력
        player.inputNums();

        // 3. 숫자 비교
        computer.compareNums(player);
    }
}
