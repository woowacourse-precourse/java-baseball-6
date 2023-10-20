package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    NumberArray user;

    void Start() {
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        game();
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if ("1".equals(readMenu())) {
                game();
            } else {
                break;
            }
        }

    }

    String readMenu() {
        String data = Console.readLine();
        if (!(data.length() < 2 && (data == "1" || data == "2"))) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        return data;
    }
//    String readNum() {
//        String data = Console.readLine();
//        if (!(data.length() < 4 && (data  == "1" || data =="2") )) {
//            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
//        }
//        return data;
//    }


    void game() {
        System.out.print("숫자를 입력해주세요 : ");
        user = new NumberArray(Console.readLine());
    }
}
