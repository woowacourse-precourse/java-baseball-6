package game;

import baseball.Initialize;
import java.util.List;

public class GameBoard {

    private static Initialize init = new Initialize();
    private static UserInput user = new UserInput();

    private static List<Integer> list;
    private static String num;
    private static int[] check;

    public void board() {
        boolean state = true;
        while(state) {
            if(gameplay())
                state = user.restart();
        }
    }

    // 게임 진행
    private boolean gameplay() {
        list = init.create_answer();

        while(true) {
            System.out.print("숫자를 입력해주세요: ");
            num = user.Input();
            check = new int[2];

            baseball();
            System.out.println(result());

            // 정답 확인
            if(check[1] == 3)
                return true;
        }
    }

    // 숫자 비교
    private void baseball() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                compare(i, j);
            }
        }
    }

    private void compare(int p1, int p2) {
        if(list.get(p1) == num.charAt(p2) - '0') {
            if(p1 == p2)
                check[1]++;
            else if(p1 != p2)
                check[0]++;
        }
    }

    // 결과 출력
    private String result() {
        if(check[0] == 0 && check[1] == 0)
            return "낫싱";
        else if(check[1] == 0)
            return check[0] + "볼";
        else if(check[0] == 0)
            return check[1] + "스트라이크";
        return check[0] + "볼 " + check[1] + "스트라이크";
    }
}
