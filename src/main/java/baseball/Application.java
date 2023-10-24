package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {
    private final static int MAX_LENGTH = 3;

    public static void main(String[] args) {
        String str = readLine();
        RandomNumbers randomNumbers = new RandomNumbers();

        for (int j = 0; j < MAX_LENGTH; j++) {
            System.out.print(randomNumbers.getNumsArray()[j]);
        }
        System.out.println("\n" + str);
    }
}
