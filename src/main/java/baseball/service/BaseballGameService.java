package baseball.service;

import baseball.model.Computer;
import baseball.util.Randomutil;
import baseball.view.InputView;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public HashMap<String, Integer> judgeResult(String num) {
        System.out.println("컴퓨터 숫자 : "+computer.getComputerNum());
        ArrayList<Integer> nums = new ArrayList<>();
        for (char x : num.toCharArray()) {
            nums.add(Integer.parseInt(String.valueOf(x)));
        }
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


    public int StrikeCount() {
        return userResult.get("STRIKE");
    }

}
