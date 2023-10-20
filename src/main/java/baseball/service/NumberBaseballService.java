package baseball.service;

import baseball.model.NumberBaseball;
import baseball.model.NumberBaseballResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NumberBaseballService {
    private NumberBaseball numberBaseball;

    public NumberBaseballService() {
        numberBaseball = new NumberBaseball();
    }

    public void newGame() {
        numberBaseball = new NumberBaseball();
    }

    public boolean isSameNum(int inputNum) {
        if(inputNum == numberBaseball.getComputerNumToInt()) {
            return true;
        }
        return false;
    }

    public NumberBaseballResult countStrikeAndBall(int inputNum) {
        // 굳이 List로 안둬도 될듯 리팩토링 대상
        List<Integer> inputNumList = convertIntToList(inputNum);
        List<Integer> compNumList = numberBaseball.getComputerNumToList();

        // 같은 수 개수 구하기
        int sameNumCnt = getSameNumCnt(inputNumList, compNumList);
        if(sameNumCnt == 0) {
            return new NumberBaseballResult(0, 0);
        }

        int strikeCnt = getStrikeCnt(inputNumList);
        return new NumberBaseballResult(strikeCnt, getBallCnt(sameNumCnt, strikeCnt));
    }

    public List<Integer> convertIntToList(Integer num) {
        List<String> strNumList = convertIntegerToStringList(num);

        // 여기 메서드 추출 해도 될듯
        return convertStrListToIntList(strNumList);
    }

    private List<String> convertIntegerToStringList(Integer num) {
        String strNum = num.toString();
        return Arrays.asList(strNum.split(""));
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

    private int getStrikeCnt(List<Integer> inputNumList) {
        int strikeCnt = 0;
        for(int i=0; i<inputNumList.size(); i++) {
            // 메서드 추출 대상
            if(Objects.equals(inputNumList.get(i), numberBaseball.getComputerNumToList().get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }
}
