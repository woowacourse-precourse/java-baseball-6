package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//숫자 야구 게임의 컴퓨터의 사용자의 수를 위한 클래스
public class BaseballNumber {
    private List<Integer> number = new ArrayList<>(3);

    public BaseballNumber(List<Integer> number) {
        findException(number);
        this.number = number;
    }


    //지우기
    @Override
    public String toString() {
        return "BaseballNumber{" +
                "number=" + number +
                '}';
    }
    //테스트를 진행해보기 위한 initializeUserNumberForTest
    public static BaseballNumber initializeUserNumberForTest(String input) {
        isInputOnlyNumber(input);
        List<Integer> numberByList=stringToList(input);
        System.out.println(numberByList);
        return new BaseballNumber(numberByList);
    }

    public static BaseballNumber initializeUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> number = new ArrayList<>();
        String input = Console.readLine();
        isInputOnlyNumber(input);
        List<Integer> numberByList=stringToList(input);
        System.out.println(numberByList);
        return new BaseballNumber(numberByList);
    }

    private static List<Integer> stringToList(String input) {
        int inputToInt = Integer.parseInt(reverseString(input));
        List<Integer> inputList = new ArrayList<Integer>();
        while (inputToInt > 0) {
            inputList.add(inputToInt % 10);
            inputToInt /= 10;
        }
        return inputList;
    }

    private static String reverseString(String str) {
        StringBuilder stringBuffer = new StringBuilder(str);
        String reverseStr = stringBuffer.reverse().toString();
        return reverseStr;
    }

    //예외발생시 프로그램이 종료되는지 확인
    private static boolean isInputOnlyNumber(String input) {
        try {
            int inputToInt = Integer.parseInt(input);
            if (inputToInt <= 0) {
                throw new IllegalArgumentException("0 또는 음수는 입력될 수 없습니다");
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자연수를 제외한 문제는 입력할 수 없습니다.");
        }
    }

    private void findException(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException("게임을 진행할 수는 항상 3개여야 합니다.");
        }
        if (number.get(0) == number.get(1) || number.get(1) == number.get(2) || number.get(0) == number.get(2)) {
            throw new IllegalArgumentException("서로 같은 숫자들은 입력될 수 없습니다.");
        }
    }

    public static BaseballNumber initializeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new BaseballNumber(computer);
    }

    public BaseballScore compareNumber(BaseballNumber userNumber) {
        BaseballScore baseballScore = new BaseballScore(0, 0);
        List<Integer> computerNumberList = this.number;
        List<Integer> UserNumberList = userNumber.number;
        for (int i = 0; i < 3; i++) {
            compareByIdx(baseballScore,computerNumberList.get(i),i , UserNumberList);
        }
        return baseballScore;
    }

    private void compareByIdx(BaseballScore baseballScore, int computerNumberByIdx,int idx,List<Integer> userNumberList) {
        for (int i = 0; i < 3; i++) {
            if (userNumberList.get(i) == computerNumberByIdx && idx == i) {
                baseballScore.addStrikeCount();
            } else if (userNumberList.get(i) == computerNumberByIdx && idx != i) {
                baseballScore.addBallCount();
            }
        }
    }
}
