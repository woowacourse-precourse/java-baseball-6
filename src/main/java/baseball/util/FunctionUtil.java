package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionUtil {
    public static List<Integer> generateRandomList() {
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size()<3) {
            int number = Randoms.pickNumberInRange(1,9);

            if(!randomNumberList.contains(number)) {
                randomNumberList.add(number);
            }
        }
        return randomNumberList;
    }

    public static List<Integer> stringToInt(String data) {

        return Arrays.stream(data.split(""))
            .mapToInt(Integer::parseInt)
            .boxed().toList();
    }

    public static int[] isNumberExist(List<Integer> randomList) {
        int[] isExist = new int[10];
        for(int i=1; i<=randomList.size(); i++) {
            isExist[randomList.get(i-1)] = i;
        }
        return isExist;
    }

}
