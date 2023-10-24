package baseball;

import static baseball.Game.end;
import static baseball.Game.start;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        boolean game_flag = false;          // 게임 진행 여부
        StringBuilder randomNumber;         // 컴퓨터의 랜덤 숫자

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!game_flag) {

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int tempNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(tempNumber)) {
                    computer.add(tempNumber);
                }
            }

            randomNumber = new StringBuilder();

            for (Integer com : computer) {
                randomNumber.append(com);
            }

            // 게임 시작과 종료
            start(randomNumber.toString());
            game_flag = end();
        }
    }
}
