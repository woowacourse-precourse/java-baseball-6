package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 랜덤값 생성
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String computerNumber = String.join("",computer);


    }
}
