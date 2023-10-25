package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//숫자 입력 > 형식 검사 >  List에 저장 > 중복검사 > GM에게 List 넘김
public class Player {

    private final ArrayList<Integer> nums;

    public ArrayList<Integer> getNums() {
        return new ArrayList<>(nums);
    }

    public Player() {
        String input = Console.readLine();

        validateInput(input);

        nums = strToArrayList(input);

        isDuplicate(nums);
    }

    private void validateInput(String input) {
        if (!input.matches("[1-9]{3}"))
            throw new IllegalArgumentException("1부터 9까지 서로 다른 숫자 3개를 입력하세요.");
    }

    private ArrayList<Integer> strToArrayList(String input) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            nums.add(input.charAt(i) - '0');
        }

        return nums;
    }

    private void isDuplicate(ArrayList<Integer> nums) {
        Set<Integer> set = new HashSet<>(nums);

        if (set.size() < nums.size())
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
    }

}
