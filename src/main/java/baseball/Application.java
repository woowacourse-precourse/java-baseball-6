package baseball;

import java.security.PrivateKey;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game A = new Game();

    }
}

class Game {
    static private String INSERT_BLOCK = "숫자를 입력해주세요 : ";
    int[] answer = new int[3];

    Game() {
        Game.start();
        int numberCount =0;
        while (numberCount<3) {
            int randomNumber = pickNumberInRange(1, 9);

            if (Game.checkNum(randomNumber, answer)) {
                answer[numberCount] = randomNumber;
                numberCount++;
            }


        }
        for (int j = 0; j < 3; j++) {
            System.out.println(answer[j]);
        }

    }

    Game(String answer) {

    }

    static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game.insert();
    }

    static Game insert() {

        System.out.print(INSERT_BLOCK);
        String input = readLine();
        Game.checkRightInput(input);
        return new Game(input);
    }

    static boolean checkNum(int a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] == a) {
                return false;
            }

        }
        return true;
    }
    static void checkRightInput(String a) {
        try{

                int value=Integer.parseInt(a);


        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

    }

    static boolean checkNoZero(String a){
        for (int i = 0; i <a.length() ; i++) {
            if(a.contains("0")){
                return false;
            }
        }
        return true;
    }
}


