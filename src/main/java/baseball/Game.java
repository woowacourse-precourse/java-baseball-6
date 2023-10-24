package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game{

        private final Input input = new Input();
        private final InputValidator inputValidator = new InputValidator();
        private final Output output = new Output();
        private String computerNumber;
        private GameState gameState = GameState.INIT;
        private static final String RESTART = "1";


        public void playGame() {

                while (!gameState.equals(GameState.END))
                {
                        initGame();

                        if (isAnswer(getUserInput()))
                        {
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

        private boolean isAnswer(String clientNumber) {

                int[] matchList = getMatchList(clientNumber);

                output.printResult(matchList);

                return matchList[MatchState.STRIKE.getValue()] == 3;
        }

        private int[] getMatchList(String clientNumber) {

                int[] matchList = new int[3];
                HashMap<Character, Integer> serverHash = stringToHashMap(computerNumber);
                HashMap<Character, Integer> clientHash = stringToHashMap(clientNumber);

                for (Character serverNum : serverHash.keySet()) {
                        if (clientHash.containsKey(serverNum) &&
                                clientHash.get(serverNum).equals(serverHash.get(serverNum))) {
                                matchList[MatchState.STRIKE.getValue()] += 1;
                        } else if (clientHash.containsKey(serverNum)) {
                                matchList[MatchState.BALL.getValue()] += 1;
                        }
                }

                if (matchList[MatchState.STRIKE.getValue()] +
                        matchList[MatchState.BALL.getValue()] == 0)
                {
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
