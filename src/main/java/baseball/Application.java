package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumberList = computerRanNumList();
    }

    // computer
    private static List<Integer> computerRanNumList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randNumber)) {
                computerNumberList.add(randNumber);
            }
        }
        return computerNumberList;
    }
}


