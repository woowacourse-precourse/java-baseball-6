package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game{
        private static final String RESTART = "1";

        private final Input input = new Input();
        private final InputValidator inputValidator = new InputValidator();
        private final Output output = new Output();
        private String computerNumber;
        private GameState gameState = GameState.INIT;


        public void playGame() {
                while (!gameState.equals(GameState.END))
                {
                        initGame();
                        if (isAnswer(getUserInput())) {
                                output.printGameEndMessage();
                                gameState = getGameState();
                        }
                }
        }

        private void initGame() {
                if (gameState.equals(GameState.INIT)) {
                        output.printStartMessage();
                        computerNumber = generateNumber();
                        gameState = GameState.START;
                }
        }

        private String getUserInput() {
                String userInput = input.readInput();

                output.printInputMessage(userInput);
                inputValidator.isValidInput(userInput);
                return userInput;
        }

        private boolean isAnswer(String userNumber) {
                int[] matchList = getMatchList(userNumber);

                output.printResult(matchList);
                return matchList[MatchState.STRIKE.getValue()] == 3;
        }

        private int[] getMatchList(String userNumber) {
                int[] matchList = new int[3];

                HashMap<Character, Integer> computerHash = stringToHashMap(computerNumber);
                HashMap<Character, Integer> userHash = stringToHashMap(userNumber);
                for (Character computerNum : computerHash.keySet()) {
                        if (userHash.containsKey(computerNum) &&
                                userHash.get(computerNum).equals(computerHash.get(computerNum))) {
                                matchList[MatchState.STRIKE.getValue()] += 1;
                        } else if (userHash.containsKey(computerNum)) {
                                matchList[MatchState.BALL.getValue()] += 1;
                        }
                }
                if (matchList[MatchState.STRIKE.getValue()] +
                        matchList[MatchState.BALL.getValue()] == 0) {
                        matchList[MatchState.NOTHING.getValue()] = 1;
                }
                return matchList;
        }


        private HashMap<Character, Integer> stringToHashMap(String number) {
                HashMap<Character, Integer> numberHash = new HashMap<>();

                for (int i = 0; i < number.length(); i++) {
                        numberHash.put(number.charAt(i), i);
                }
                return numberHash;
        }

        private GameState getGameState() {
                String restartChoice = input.readInput();

                inputValidator.isValidChoice(restartChoice);
                if (restartChoice.equals(RESTART)) {
                        return GameState.INIT;
                } else {
                        return GameState.END;
                }
        }

        private String generateNumber() {
                List<Integer> computer = new ArrayList<>();

                while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                                computer.add(randomNumber);
                        }
                }
                return computer.toString().replaceAll("\\D","");
        }
}
