package baseball.service;

import baseball.entity.BallCount;
import baseball.utils.UserInputUtils;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {
    static BaseballService baseballService = new BaseballService();
    static BallCount ballCount = new BallCount();

    public static void initBallCount() {
        ballCount.setStrikes(0);
        ballCount.setBalls(0);
    }

    public List<Integer> setComputerNum(int size) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public String setUserNum(int size) {
        System.out.print("숫자를 입력해주세요 : ");
        String user = Console.readLine();
        return user;
    }

    public void run(int size) {
        UserInputUtils.setSize(size);
        List<Integer> computer = setComputerNum(size);
        initBallCount();
        while (ballCount.getStrikes() != size) {
            String user = setUserNum(size);
            UserInputUtils.checkSize(user);
            UserInputUtils.checkDuplication(user);
            UserInputUtils.checkRangeAndDigit(user);
            List<Integer> userList = UserInputUtils.convertStringToInteger(user);
            playGame(computer, userList);
            baseballService.printBaseball(ballCount.getStrikes(), ballCount.getBalls());
        }
        System.out.println("게임 종료");

    }

    public void playGame(List<Integer> computer, List<Integer> user) {
        ballCount.setBalls(baseballService.countBall(computer, user));
        ballCount.setStrikes(baseballService.countStrike(computer, user));

    }

    public boolean replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String user = Console.readLine();
        if (user.equals("1")) {
            return true;
        } else if (user.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("replay 설정 값인 1, 2가 아닙니다. 프로그램을 종료합니다.");
        }

    }

}
