package baseball.logic;

import baseball.Game;
import baseball.service.Service;
import baseball.utils.Utils;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    static final int OUT = 3;
    static Service service = new Service();

    public static void run() {
        Computer Utils;
        List<Integer> computer = Computer.generateRandomNumber(3);
        boolean gameFinished = false;

        while (!gameFinished) {
            List<Integer> user = getUserNumber();
            playBall(computer, user, service);
            showResult(service);

            if (service.getStrikes() == OUT) {
                gameFinished = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }

    public static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        Utils.validateStringThreeDifferentDigits(userInput);
        return Utils.stringToIntegerList(userInput);
    }

    public static void playBall(List<Integer> computer, List<Integer> user, Service service) {
        int strikes = service.countStrike(computer, user);
        int balls = service.countBall(computer, user);
        service.setScore(strikes, balls);
    }

    public static void showResult(Service service) {
        Game.printGameResult(service.getStrikes(), service.getBalls());
    }

}