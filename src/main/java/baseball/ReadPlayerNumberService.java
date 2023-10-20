package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ReadPlayerNumberService {
    private PlayerNumbers playerNumbers;

    public ReadPlayerNumberService(PlayerNumbers playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void readPlayerNumber(int numOfNumbers) {
        System.out.print("숫자를 입력해주세요 : ");
        int scanPlayerNumber = Integer.parseInt(Console.readLine());
        if (verify(scanPlayerNumber)) {
            addPlayerNumbers(scanPlayerNumber, numOfNumbers);
        }
    }

    private boolean verify(int scanPlayerNumber) {
        return true;
    }

    private void addPlayerNumbers(int scanPlayerNumber, int numOfNumbers) {
        while (playerNumbers.size() < numOfNumbers) {
            playerNumbers.add((int) (scanPlayerNumber / Math.pow(10, numOfNumbers - playerNumbers.size() - 1)));
            scanPlayerNumber %= (int) Math.pow(10, numOfNumbers - playerNumbers.size());
        }
    }

}
