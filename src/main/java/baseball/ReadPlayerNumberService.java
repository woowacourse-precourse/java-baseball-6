package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class ReadPlayerNumberService {
    private NumbersObjects playerNumbers;

    public ReadPlayerNumberService(NumbersObjects playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void readPlayerNumber(int numOfNumbers) {
        System.out.print("숫자를 입력해주세요 : ");
        String scanPlayerNumber = Console.readLine();
        if (playerReadLineVerify(scanPlayerNumber)) {
            addPlayerNumbers(readLineToInt(scanPlayerNumber), numOfNumbers);
        }
    }

    private int readLineToInt(String readLine) {
        return Integer.parseInt(readLine);
    }

    private boolean playerReadLineVerify(String scanPlayerNumber) {
        if (!Pattern.matches("^\\d{3}$", scanPlayerNumber)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private void addPlayerNumbers(int scanPlayerNumber, int numOfNumbers) {
        while (playerNumbers.size() < numOfNumbers) {
            playerNumbers.add((int) (scanPlayerNumber / Math.pow(10, numOfNumbers - playerNumbers.size() - 1)));
            scanPlayerNumber %= (int) Math.pow(10, numOfNumbers - playerNumbers.size());
        }
    }

}
