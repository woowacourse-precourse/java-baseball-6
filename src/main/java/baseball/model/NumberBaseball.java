package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseball {
    // 더 좋은 변수명 생각해보기
    private List<Integer> computerNum = new ArrayList<>();

    public NumberBaseball() {
        generateComputerNum();
    }

    public List<Integer> getComputerNumToList() {
        return computerNum;
    }

    public int getComputerNumToInt() {
        return modifyListToInt();
    }

    private int modifyListToInt() {
        String compNumStr = "";
        List<String> stringList = computerNum.stream().map(i -> i.toString()).collect(Collectors.toList());
        for (String s : stringList) {
            compNumStr+=s;
        }
//        Integer intNum = Integer.parseInt(compNumStr);
//        System.out.println("intNum = " + intNum);
        return Integer.parseInt(compNumStr);
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
