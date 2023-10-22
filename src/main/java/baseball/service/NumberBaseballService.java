package baseball.service;

import baseball.model.NumberBaseball;
import baseball.model.NumberBaseballResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NumberBaseballService {
    private NumberBaseball numberBaseball;

    private NumberBaseballService() {
        initNumberBaseball();
    }

    public static NumberBaseballService getInstance() {
        return new NumberBaseballService();
    }

    private void initNumberBaseball() {
        numberBaseball = NumberBaseball.getInstance();
    }

    public void newGame() {
        initNumberBaseball();
    }

    public boolean isSameNum(int inputNum) {
        if(inputNum == numberBaseball.getComputerNumToInt()) {
            return true;
        }
        return false;
    }

    public NumberBaseballResult countStrikeAndBall(int inputNum) {
        List<Integer> inputNumList = convertIntToList(inputNum);
        List<Integer> compNumList = numberBaseball.getComputerNumToList();

        // 같은 수 개수 구하기
        int sameNumCnt = getSameNumCnt(inputNumList, compNumList);
        if(sameNumCnt == 0) {
            return new NumberBaseballResult(0, 0);
        }

        int strikeCnt = getStrikeCnt(inputNumList, compNumList);
        return new NumberBaseballResult(strikeCnt, getBallCnt(sameNumCnt, strikeCnt));
    }

    public List<Integer> convertIntToList(Integer num) {
        return convertStrListToIntList(convertIntegerToStringList(num));
    }

    private List<String> convertIntegerToStringList(Integer num) {
        return Arrays.asList(num.toString().split(""));
    }

    private List<Integer> convertStrListToIntList(List<String> strNumList) {
        List<Integer> integerList = new ArrayList<>();
        for (String s : strNumList) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }

    private int getBallCnt(int sameNumCnt, int strikeCnt) {
        return sameNumCnt - strikeCnt;
    }

    private int getSameNumCnt(List<Integer> inputNumList, List<Integer> compNumList) {
        return (int) inputNumList.stream()
                .filter(i -> compNumList.contains(i)).count();
    }

    private int getStrikeCnt(List<Integer> inputNumList, List<Integer> compNumList) {
        return (int) inputNumList.stream()
                .filter(n -> n == compNumList.get(inputNumList.indexOf(n)))
                .count();
    }
}
