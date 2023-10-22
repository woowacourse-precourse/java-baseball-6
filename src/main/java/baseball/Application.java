package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    final static int LENGTH_OF_CORRECTION_ANSWER = 3;
    final static int RANGE_START = 0;
    final static int RANGE_END = 9;

    public static void main(String[] args) {
        List<Integer> randomNumberList;

        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNumberList = getNewRandomNumberList();


        System.out.println("게임이 종료되었습니다.");
    }

    /**
     * 게임을 위한 새로운 숫자 리스트 생성
     *
     * @return 길이 3의 Integer 리스트
     */
    public static List<Integer> getNewRandomNumberList() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < LENGTH_OF_CORRECTION_ANSWER) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            uniqueAdd(numberList, randomNumber);
        }
        return numberList;
    }

    /**
     * 리스트 내에 존재하지 않는 값인 경우 리스트에 추가
     *
     * @param list   값을 추가할 리스트
     * @param number 리스트에 추가할 값
     */
    public static void uniqueAdd(List<Integer> list, Integer number) {
        if (!list.contains(number)) {
            list.add(number);
        }
    }
}
