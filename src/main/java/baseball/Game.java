package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int gameRestart = 1;
    private int strike = 0;
    private int ball = 0;

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameRestart == 1) {
            List<Integer> computer = getComputerNumber();
            while (true) {
                System.out.printf("숫자를 입력해주세요 : ");
                String userNumber = Console.readLine();
                List<Integer> user = getUserInput(userNumber);
            }
        }
    }

    public List<Integer> getComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getUserInput(String userNumber){
        List<Integer> user = new ArrayList<>();

        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        }
        if (userNumber.charAt(0) == userNumber.charAt(1) ||
                userNumber.charAt(1) == userNumber.charAt(2) ||
                userNumber.charAt(2) == userNumber.charAt(0)) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
        }

        String[] splitList = userNumber.split("");
        for (int i = 0; i < splitList.length; i++) {
            try {
                int digit = Integer.parseInt(splitList[i]);
                user.add(digit);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
            }
        }
        return user;
    }
}
