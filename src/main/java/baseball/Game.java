package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Player user;
    Player computer;

    public void startGame() {
        this.user = new Player();
        this.computer = new Player();
        initComputerNumbers();
        inputUser();
        System.out.println(computer.getPlayerNumbers());
        System.out.println(user.getPlayerNumbers());
    }

    public void inputUser() {
        String inputData = Console.readLine();
        String[] inputNumbers = inputData.split("");
        List<Integer> userNumbers = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            int tempNumber = Integer.parseInt(inputNumbers[i]); //
            userNumbers.add(tempNumber);
        }
        this.user.setPlayerNumbers(userNumbers);
    }

    public void initComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>(3);
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        this.computer.setPlayerNumbers(computerNumbers);
    }
}
