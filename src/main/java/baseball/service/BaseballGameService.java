package baseball.service;

import baseball.model.Computer;
import baseball.util.Randomutil;
import java.util.*;

public class BaseballGameService {

    private static final String STRIKE_KEY = "STRIKE";
    private static final String BALL_KEY = "BALL";
    private static Computer computer;
    private static HashMap<String, Integer> userResult = new HashMap<>();


    public void initUserResult() {
        userResult.put(STRIKE_KEY, 0);
        userResult.put(BALL_KEY, 0);
    }

    public void createComputer() {
        computer = new Computer(Randomutil.CreateRandomNum());
    }

    public ArrayList<Integer> changeStirngToList(String num) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (char x : num.toCharArray()) {
            nums.add(Integer.parseInt(String.valueOf(x)));
        }
        return nums;
    }

    public HashMap<String, Integer> judgeResult(String num) {
        ArrayList<Integer> nums = changeStirngToList(num);

        for (int i = 0; i < nums.size(); i++) {
            if (computer.getComputerNum().contains(nums.get(i)) && computer.getComputerNum().get(i) == nums.get(i)) {
                userResult.put(STRIKE_KEY, userResult.get(STRIKE_KEY) + 1);
            }
            if (computer.getComputerNum().contains(nums.get(i)) && computer.getComputerNum().get(i) != nums.get(i)) {
                userResult.put(BALL_KEY, userResult.get(BALL_KEY) + 1);
            }
        }
        return userResult;
    }

    public void judgeCorrectInputNum(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자가 3자리의 수가 아닙니다.");
        }
        if (num.contains("0")) {
            throw new IllegalArgumentException("1~9사이의 숫자만 입력해야 합니다.");
        }
        HashSet<Character> inputNumSet = new HashSet<>();
        for (char x : num.toCharArray()) {
            inputNumSet.add(x);
        }
        if (inputNumSet.size() < 3) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }

    public void judgeCorrectRestartNum(int num) {
        if (num != 1 && num != 2) {
            throw new IllegalArgumentException("1,2 둘중 하나의 수만 입력해야 합니다.");
        }
    }

    public int StrikeCount() {
        return userResult.get("STRIKE");
    }

}
