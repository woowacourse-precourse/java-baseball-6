package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class GameViewer {

    // Todo : random list implementation
    private static final UserService userService = new UserService();
    private static final ComputerService computerService = new ComputerService();

    private static Scanner sc = new Scanner(System.in);

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){ // Todo : consider ending case
            System.out.print("숫자를 입력해주세요 : ");
            String tmp = sc.next();
            User user = userService.createUser(tmp);
            Computer computer = computerService.createComputer();
        }

        // System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}

