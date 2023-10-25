package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computer = new ArrayList<>();
    User user = new User(0, 0);

    void insertInput() throws IllegalArgumentException {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            char inputOneNum = input.charAt(i);
            if (!user.testDuplicate(inputOneNum) || inputOneNum < '1' || inputOneNum > '9')
                throw new IllegalArgumentException();
            user.insertNum(Character.getNumericValue(inputOneNum));
        }
    }

    void computerClear() {
        computer.clear();
    }

    void userClear() {
        user.clear();
    }

    void makeRandomNum() {
        while (computer.size() < 3) { //computer 랜덤 숫자 생성
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    String returnCount() {
        for (int i = 0; i < 3; i++) { //strike,ball 판정
            List<Integer> temList = user.getList();
            int Num = temList.get(i);
            if (computer.get(i) == Num) user.strike++;
            else if (computer.contains(Num)) user.ball++;
        }

        return user.getResult();
    }

    boolean isEndGame() {
        return user.strike == 3;
    }

    boolean oneMoreGame(String NewGame) throws IllegalArgumentException {
        int inputNum = Integer.parseInt(NewGame);
        if (inputNum != 1 && inputNum != 2) throw new IllegalArgumentException();

        return inputNum == 2;
    }

    boolean playOneGame(Game game) {
        while (true) {
            try {//게임 사용자 숫자 입력
                game.insertInput();
            } catch (IllegalArgumentException e) {//예외처리 구분지어서 나중에 해줄것.
                throw e;
            }

            System.out.println(game.returnCount());

            if (game.isEndGame()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            game.userClear();
        }
        game.userClear();
        return true;
    }

    void start(Game game) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            game.makeRandomNum();
            if(!game.playOneGame(game)) break;
            if(!returnGameEnd(game)) break;
        }
    }

    boolean returnGameEnd(Game game){
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String NewGame = Console.readLine();
            if (game.oneMoreGame(NewGame)) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
        game.computerClear();
        return true;
    }
}
