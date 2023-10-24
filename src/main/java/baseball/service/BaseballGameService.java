package baseball.service;

import baseball.model.Computer;
import baseball.util.RandomUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BaseballGameService {

    private static final String STRIKE_KEY = "STRIKE";
    private static final String BALL_KEY = "BALL";
    private static final int VALID_NUM_LENGTH = 3;

    public Computer getComputer() {
        return computer;
    }

    private static Computer computer;
    private static HashMap<String, Integer> userResult = new HashMap<>();

    public HashMap<String, Integer> getUserResult() {
        return userResult;
    }

    public void initUserResult() {
        userResult.put(STRIKE_KEY, 0);
        userResult.put(BALL_KEY, 0);
    }

    public void createComputer() {
        computer = new Computer(RandomUtil.CreateRandomNum());
        judgeCorrectNum(computer.getComputerNum());
    }

    public ArrayList<Integer> changeStirngToList(String num) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (char x : num.toCharArray()) {
            nums.add(Integer.parseInt(String.valueOf(x)));
        }
        return nums;
    }

    public HashMap<String, Integer> judgeResult(String inputNum, String computerNum) {
        ArrayList<Integer> inputNums = changeStirngToList(inputNum);
        ArrayList<Integer> computerNums = changeStirngToList(computerNum);

        for (int i = 0; i < computerNums.size(); i++) {
            if (computerNums.contains(inputNums.get(i)) && computerNums.get(i) == inputNums.get(i)) {
                userResult.put(STRIKE_KEY, userResult.get(STRIKE_KEY) + 1);
            }
            if (computerNums.contains(inputNums.get(i)) && computerNums.get(i) != inputNums.get(i)) {
                userResult.put(BALL_KEY, userResult.get(BALL_KEY) + 1);
            }
        }
        return userResult;
    }

    public void judgeCorrectNum(String num) {
        if (checkNumDigit(num)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (checkNumLength(num)) {
            throw new IllegalArgumentException("입력한 숫자가 3자리의 수가 아닙니다.");
        }
        if (checkNumZero(num)) {
            throw new IllegalArgumentException("1~9사이의 숫자만 입력해야 합니다.");
        }
        if (checkNumDiffernt(num)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }

    public boolean checkNumDigit(String num) {
        try {
            int InputNum = Integer.parseInt(num);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public boolean checkNumLength(String num) {
        return num.length() != VALID_NUM_LENGTH;
    }

    public boolean checkNumZero(String num) {
        return num.contains("0");
    }

    public boolean checkNumDiffernt(String num) {
        HashSet<Character> inputNumSet = new HashSet<>();
        for (char x : num.toCharArray()) {
            inputNumSet.add(x);
        }
        return inputNumSet.size() < VALID_NUM_LENGTH;
    }

    public void judgeCorrectRestartNum(String num) {
        if (!num.equals("1") && !num.equals("2")) {
            throw new IllegalArgumentException("1,2 둘중 하나의 수만 입력해야 합니다.");
        }
    }

    public int StrikeCount() {
        return userResult.get(STRIKE_KEY);
    }

}
