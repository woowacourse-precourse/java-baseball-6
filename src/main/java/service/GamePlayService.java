package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Computer;
import model.User;
import view.GameView;

public class GamePlayService {

    private Computer computer = new Computer();
    private User user = new User();
    private GameView gameView = new GameView();

    public void playGame() {
        gameView.startGameView(); // 1. 게임 시작 메시지
        computer.setComputerNumbers(); // 2. 컴퓨터 숫자 입력
        String userInput = gameView.userInput(); // 3. 사용자 숫자 입력
        validationCheckOfUserInput(userInput); // 4. 사용자 숫자 유효성 체크

        List<Integer> userNumList = StringToArrayList(userInput); // 5. 사용자 입력 값 List로 변환


    }

    public void validationCheckOfUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("숫자는 3개까지만 입력할 수 있습니다.");
        }

        for (int i = 0; i < userInput.length(); i++) {
            if (!userInput.matches("[1-9]+")) {
                throw new IllegalArgumentException("1~9 범위 내의 '숫자'만 입력할 수 있습니다.");
            }
        }

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            numSet.add(userInput.charAt(i) - '0');
        }
        if (numSet.size() != 3) {
            throw new IllegalArgumentException("같은 숫자는 입력할 수 없습니다.");
        }
    }

    public static List<Integer> StringToArrayList(String userInput) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            numList.add(userInput.charAt(i) - '0');
        }
        return numList;
    }
}
