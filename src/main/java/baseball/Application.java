package baseball;

import camp.nextstep.edu.missionutils.Console;

class User {
    private String userInput;
    private boolean winning = false;

    public void userWins() {
        winning = true;
    }

    public boolean didUserWin() {
        return winning;
    }

    public void readUserInput() {
        userInput = Console.readLine();
    }

    public String getUserInput() {
        return userInput;
    }

    public boolean isUserInputValidInGame() {
        // 인게임에서 사용자 입력값의 길이가 3이 아니면 false
        if (userInput.length() != 3) {
            return false;
        }

        try {
            int userNumber = Integer.parseInt(userInput);
            // userNumber가 -99와 같이 음의 정수이면 false
            if (userNumber < 0) {
                return false;
            }
            // userNumber 자릿수 중에 하나라도 0이면 false
            while (userNumber > 0) {
                if (userNumber % 10 == 0) {
                    return false;
                }
                userNumber /= 10;
            }

        } catch (NumberFormatException error) {
            // 인게임에서 사용자 입력값의 파싱 결과가 숫자가 아니면 false
            return false;
        }
        return true;
    }

    public boolean isUserInputValidAfterGame() {
        if (userInput.equals("1")) {
            return true;
        }
        if (userInput.equals("2")) {
            return true;
        }
        return false;
    }
}


public class Application {


    public static void main(String[] args) {
        // 3스트라이크가 되면, userWins가 true가 되며 게임이 종료된다.
        User user = new User();
        System.out.printf("숫자 야구 게임을 시작합니다.\n");
        while (!user.didUserWin()) {
            try {
                System.out.printf("숫자를 입력해주세요 : ");
                user.readUserInput();
                if (!user.isUserInputValidInGame()) {
                    throw new IllegalArgumentException();
                }
                System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                user.readUserInput();
                if (!user.isUserInputValidAfterGame()) {
                    throw new IllegalArgumentException();
                }
                switch (user.getUserInput()) {
                    case "1":
                        continue;
                    case "2":
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException error) {
                user.userWins();
                continue;
            }
        }
    }
}
