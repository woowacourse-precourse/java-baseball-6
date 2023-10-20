package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    void Start() {
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        System.out.println(Console.readLine());
        
    }
}
