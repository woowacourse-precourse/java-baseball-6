package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private String userInput;
    private List<Integer> playerNums;
    private UserController userController;

    public Player(int size) throws IllegalArgumentException {
        userController = new UserController();

        userInput = userController.receiveUserInput();
        userController.checkStringLength(userInput, size);
        userController.checkInt(userInput);
        playerNums = parseNums();
        userController.checkDuplicated(playerNums, size);
    }

    private List<Integer> parseNums() throws IllegalArgumentException {
        try {
            List<Integer> playerNums = new ArrayList<>();
            for (int i = 0; i < userInput.length(); i++) {
                playerNums.add(userInput.charAt(i) - '0');
            }
            return playerNums;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Integer> getPlayerNums() {
        return Collections.unmodifiableList(playerNums);
    }
}
