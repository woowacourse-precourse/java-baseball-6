package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
            // TODO: 프로그램 구현
            boolean reGame = true;
            //게임 새로 시작.
            while(reGame) {
                Baseball baseball = new Baseball();
                System.out.println("숫자 야구 게임을 시작합니다.");
                reGame =baseball.run(reGame);
                }
    }
}
