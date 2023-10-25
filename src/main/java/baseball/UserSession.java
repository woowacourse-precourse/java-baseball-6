package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserSession {
    private Game game;

    public UserSession() {}

    public void run() throws IllegalArgumentException {
        if (game == null) game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            String input = promptForRound();
            int[] result = game.playRound(input);
            showRoundResult(result);
            if (game.isWin(result)) {
                System.out.println(new StringBuilder()
                        .append(game.getNumberSize())
                        .append("개의 숫자를 모두 맞히셨습니다! 게임 종료")
                );
                if (!promptForNewGame()) break;
                game.setNewGame();
            }
        }
    }

    private void showRoundResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }
        else if (result[0] > 0 && result[1] > 0) {
            System.out.println(new StringBuilder()
                    .append(result[1])
                    .append("볼 ")
                    .append(result[0])
                    .append("스트라이크")
            );
        } else if (result[0] > 0 && result[1] == 0) {
            System.out.println(new StringBuilder()
                    .append(result[0])
                    .append("스트라이크")
            );
        }
        else if (result[0] == 0 && result[1] > 0) {
            System.out.println(new StringBuilder()
                    .append(result[1])
                    .append("볼")
            );
        }
    }

    private String promptForRound() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private boolean promptForNewGame() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) return true;
        else if (input.equals("2")) return false;
        else throw new IllegalArgumentException("Invalid user input in prompt for new game");
    }
}
