package game;

import baseball.Initialize;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameBoard {

    private static Initialize init = new Initialize();
    private static UserInput user = new UserInput();
    private static Validation validation;

    private static List<Integer> list;
    private static String num;
    private static int[] check;

    public boolean board() {
        boolean state = true;
        while(state) {
            if(gameplay())
                state = restart();
            else
                break;
        }
        return false;
    }

    // 게임 진행
    private boolean gameplay() {
        list = init.create_answer();

        while(true) {
            if(!user.InputNum())
                return false;
            num = user.input;
            check = new int[2];

            baseball();
            System.out.println(result());

            // 정답 확인
            if(check[1] == 3)
                return true;
        }
    }
    private void baseball() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                compare(i, j);
            }
        }
    }

    // 숫자 비교
    private void compare(int p1, int p2) {
        if(list.get(p1) == num.charAt(p2) - '0') {
            if(p1 == p2)
                check[1]++;
            else check[0]++;
        }
    }

    // 결과 출력
    private String result() {
        if(check[0] == 0 && check[1] == 0)
            return "낫싱";
        if(check[1] == 0)
            return check[0] + "볼";
        if(check[0] == 0)
            return check[1] + "스트라이크";
        return check[0] + "볼 " + check[1] + "스트라이크";
    }

    private static boolean restart() {
        validation = new Validation();
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return validation.change(Console.readLine());
    }
}
