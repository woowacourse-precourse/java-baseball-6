package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> comArrayList = new ArrayList<>();
        List<Integer> humanArrayList = new ArrayList<>();
        getComNumber(comArrayList);

    }
    private static void getComNumber(List<Integer> comArrayList){
        while (comArrayList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comArrayList.contains(randomNumber)) {
                comArrayList.add(randomNumber);
            }
        }
    }
}