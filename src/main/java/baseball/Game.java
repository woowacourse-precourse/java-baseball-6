package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    public Game() {

    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Balls com = Balls.makeRandomBalls();
        Result result;
        do {
            System.out.println("숫자를 입력해 주세요 : ");

            Balls user = makeUserBalls();
            result = Result.checkBalls(com, user);

            System.out.println( result.getMessage() );
        } while( !result.isAllStrike() );
    }


    public boolean restartGame() {
        String input = "";

        while( input == "1" || input == "2") {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            input = readLine();
        }

        return input.equals("1");
    }

    private Balls makeUserBalls() {
        Balls user = null;

        while (user == null) {
            String userInput = readLine();

            validateUserInput(userInput);

            try {
                user = new Balls(userInput);
            } catch (NumberFormatException e) { System.out.println("3개의 1~9 사이의 중복되지 않는 수만 입력할 수 있습니다."); }
            catch (Exception e) { e.printStackTrace(); }
        }

        return user;
    }

    private void validateUserInput(String userInput) {
        if ( userInput.length() != Balls.BALLS_COUNT ) { throw new IllegalArgumentException("입력 값의 길이가 잘못 되었습니다."); }
    }

    public void play() {
        do {
            startGame();
        } while ( restartGame() );
    }
}