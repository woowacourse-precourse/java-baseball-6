package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseball {
    // 더 좋은 변수명 생각해보기
    private List<Integer> computerNum = new ArrayList<>();

    private NumberBaseball() {
        generateComputerNum();
    }

    public static NumberBaseball getInstance() {
        return new NumberBaseball();
    }

    public List<Integer> getComputerNumToList() {
        return computerNum;
    }

    public int getComputerNumToInt() {
        return modifyListToInt();
    }

    private int modifyListToInt() {
        return Integer.parseInt(convertListToString(convertStringToStringList()));
    }

    private List<String> convertStringToStringList() {
        return computerNum.stream().map(i -> i.toString()).collect(Collectors.toList());
    }

    private String convertListToString(List<String> stringList) {
        String compNumStr = "";
        for (String s : stringList) {
            compNumStr+=s;
        }
        return compNumStr;
    }

    private void generateComputerNum() {
        while(computerNum.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNum.contains(randNumber)) {
                computerNum.add(randNumber);
            }
        }
    }
}
