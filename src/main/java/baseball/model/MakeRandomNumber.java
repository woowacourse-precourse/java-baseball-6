package baseball.model;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Objects;

// contains 대신에 visited로 변경
public class MakeRandomNumber {

    private final static int MAX_RANGE_NUM = 9;
    private final static int MIN_RANGE_NUM = 1;
    private final static int NUM_SIZE = 3;
    private ArrayList<String> ComputerNumber = new ArrayList<>();
    private String visited[];

    public ArrayList<String> MakeRandomNumber() {
        ComputerNumber.clear();
        visited = new String[MAX_RANGE_NUM + 1];

        for(int i = MIN_RANGE_NUM; i <= MAX_RANGE_NUM; i++) {
            visited[i] = "false";
        }

        while(ComputerNumber.size() < NUM_SIZE) {
            String num = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM) + "";
               if(Objects.equals(visited[Integer.parseInt(num)], "false")) {
                    ComputerNumber.add(num);
                    visited[Integer.parseInt(num)] = "true";
                }
        }

        return ComputerNumber;
    }

}
