package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer com = new Computer();
        com.getNumbers();
        System.out.print("숫자를 입력해주세요 : ");
        String player = Console.readLine();
        
        com.getClear();
        Console.close();
    }
}
