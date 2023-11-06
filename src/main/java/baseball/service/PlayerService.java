package baseball.service;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class PlayerService {

    public Player inputPlayerNumber() {   // contains setPlayerNumber()
        ArrayList<Integer> playerNumbers = new ArrayList<>();
        String inputNum = Console.readLine();
        checkInputPlayerNumber(inputNum);

        for (int i = 0; i < 3; i++) {
//            Integer.parseInt(String.valueOf(inputNum.charAt(1)));
            playerNumbers.add(Character.getNumericValue(inputNum.charAt(i)));
        }
        int firstNum = playerNumbers.get(0);
        int secondNum = playerNumbers.get(1);
        int thirdNum = playerNumbers.get(2);

        return new Player(firstNum, secondNum, thirdNum);
    }

    public ArrayList<Integer> getPlayerNumber(Player player) {
        ArrayList<Integer> playerNumberList = new ArrayList<>();
        playerNumberList.add(player.getFirstNum());
        playerNumberList.add(player.getSecondNum());
        playerNumberList.add(player.getThirdNum());

        return playerNumberList;
    }


    public void checkInputPlayerNumber(String inputPlayerNumbers) {
        checkCharacterExistence(inputPlayerNumbers);
        checkLength(inputPlayerNumbers);
        checkDuplicateNumber(inputPlayerNumbers);
        checkPresenceOfZero(inputPlayerNumbers);
    }

    public void checkCharacterExistence(String inputPlayerNumbers) {
        try {
            Integer.parseInt(inputPlayerNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void checkLength(String inputPlayerNumbers) {
        if (inputPlayerNumbers.length() != 3)
            throw new IllegalArgumentException();
    }

    public void checkDuplicateNumber(String inputPlayerNumbers) {
        ArrayList<Integer> numbers = new ArrayList<>();   // new boolean[10]
        for (int i = 0; i < 3; i++) {
            if (numbers.contains(Character.getNumericValue(inputPlayerNumbers.charAt(i))))
                throw new IllegalArgumentException();
            numbers.add(Character.getNumericValue(inputPlayerNumbers.charAt(i)));
        }
    }

    public void checkPresenceOfZero(String inputPlayerNumbers) {
        if (inputPlayerNumbers.contains("0"))
            throw new IllegalArgumentException();
    }

}
