package baseball;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    public void play() {
        do {
            playGame();
        } while ( restart() );
    }

    private void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Balls com = Balls.makeRandomBalls();
        BallChecker result;
        do {
            System.out.print("숫자를 입력해 주세요 : ");

            Balls user = makeUserBalls();
            result = BallChecker.checkBalls(com, user);

            System.out.println( result.getMessage() );
        } while( !result.isAllStrike() );
    }

    private Balls makeUserBalls() {
        Balls user = null;

        while (user == null) {
            try {
                String userInput = readLine();

                validateUserInput(userInput);

                user = new Balls(userInput);
            } catch (Exception e) { System.out.println(e.toString()); }
        }

        return user;
    }

    private void validateUserInput(String userInput) {
        if ( userInput.length() != Balls.BALLS_COUNT ) { throw new IllegalArgumentException("입력 값의 길이가 잘못 되었습니다."); }
    }

    private boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = "";

        while(validateRestart(input)) {
            try {
                input = readLine();

                if (validateRestart(input)) throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            } catch (Exception e) { System.out.println(e.toString()); }
        }

        return Objects.equals(input, "1");
    }

    private boolean validateRestart(String input) {
        return (!Objects.equals(input, "1") && !Objects.equals(input, "2"));
    }
}
