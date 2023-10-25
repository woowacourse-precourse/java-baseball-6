package baseball;

import java.util.ArrayList;
import java.util.Iterator;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    public static final ArrayList<Integer> numToGuess = new ArrayList<>();
    public static final ArrayList<Integer> playerGuess = new ArrayList<>();
    public static boolean testMode = false;
    
    private static final String strikeOutput = "스트라이크";
    private static final String ballOutput = "볼";
    private static final String nothingOutput = "낫싱";
    private static final String inputPrompt = "숫자를 입력해주세요 : ";

    public static void rigGuess(int first, int second, int third) {
        numToGuess.clear();
        numToGuess.add(first);
        numToGuess.add(second);
        numToGuess.add(third);

        if(testMode) {
            System.out.println("<TESTMODE> numToGuess: " + numToGuess);
        }
    }

    //Returns false if not won, true if won game
    public static boolean evaluatePlayAndWinCondition() {
        if(testMode) {
            System.out.println("<TESTMODE> numToGuess: " + numToGuess);
            System.out.println("<TESTMODE> playerGuess: " + playerGuess);
        }

        int ballCount = 0;
        int strikeCount = 0;
        Iterator<Integer> computerIterator = numToGuess.iterator();
        Iterator<Integer> playerIterator = playerGuess.iterator();

        while (computerIterator.hasNext() && playerIterator.hasNext()) {
            Integer computerNum = computerIterator.next();
            Integer playerNum = playerIterator.next();
            if (playerNum == computerNum) {
                strikeCount += 1;
            }
            else if (numToGuess.contains(playerNum)) {
                ballCount += 1;
            }
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + ballOutput + " " + strikeCount + strikeOutput);
        }
        else if (ballCount != 0) {
            System.out.println(ballCount + ballOutput);
        }
        else if (strikeCount != 0) {
            System.out.println(strikeCount + strikeOutput);
        }
        else {
            System.out.println(nothingOutput);
        }

        return strikeCount == 3;
    }

    public static void generateNewNumber() {
        numToGuess.clear();
        while (numToGuess.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numToGuess.contains(randomNumber)) {
                numToGuess.add(randomNumber);
            }
        }
        
        if(testMode) {
            System.out.println("<TESTMODE> numToGuess: " + numToGuess);
        }
    }

    public static void getPlayerGuess() {
        System.out.print(inputPrompt);
        String playerInput = Console.readLine();

        //Check for length
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException("Enter three unique numbers.");
        }

        //Check for three unique number
        if (playerInput.charAt(0) == playerInput.charAt(1) || 
            playerInput.charAt(0) == playerInput.charAt(2) || 
            playerInput.charAt(1) == playerInput.charAt(2)) {
            
            throw new IllegalArgumentException("Enter three unique numbers.");
        }

        //Check for number
        try {
            Integer.parseInt(playerInput);
        } 
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Enter three unique numbers.");
        }

        //Add new correct input into playerGuess
        playerGuess.clear();
        for (char c : playerInput.toCharArray()) {
            playerGuess.add(c - '0');
        }
        
        if(testMode) {
            System.out.println("<TESTMODE> playerGuess: " + playerGuess);
        }
    }

    public static int getPlayAgainInput() {
        String playAgainInput = Console.readLine();

        //Check for number
        try {
            int playAgainNumber = Integer.parseInt(playAgainInput);

            //Check for 1 or 2
            if (playAgainNumber != 1 && playAgainNumber != 2) {
                throw new IllegalArgumentException("Enter 1 or 2.");
            }
            return playAgainNumber;
        } 
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Enter 1 or 2.");
        }
    }
}
