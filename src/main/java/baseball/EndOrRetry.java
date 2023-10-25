package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class EndOrRetry {
    public boolean endOrRetry() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        boolean reTry = true;
        while (reTry == true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            char num = Console.readLine().charAt(0);
            if (num == '1') //새로 시작
                return true;
            else if (num == '2') //종료
                return false;
            else
                reTry = exception_try(num);

        }
        return false;
    }

    public boolean exception_try(char num) {
        if (num != '1' || num != '2') {
            throw new IllegalArgumentException("1이나 2를 입력해주세요.");
        } else return false;
    }
}
