package baseball;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Number-Baseball Game
public class Application {

    private final static Scanner sc = new Scanner(System.in);    // scanner for input
    private static boolean correct;
    private static ArrayList<String> inputStr;
    private static String answerStr;


    public static void main(String[] args) {

        // TODO: 프로그램 구현
        // start game
        System.out.println("숫자 야구 게임을 시작합니다.");

        // setting for new game
        setNewGame();

        // game
        while (true) {

            // input
            inputStr.add(makeRandomThreeNumber());

            // print result
            if (inputStr.get(inputStr.lastIndexOf(inputStr)).equals(answerStr)) {
                correct = true;
            } else {
                // TODO: Algorithm for Strike-Ball-Nothing

            }

            // if correct, ask continuous
            if (correct) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int cont = sc.nextInt();
                if (cont == 1) {            // if 1, set the new game
                    setNewGame();
                } else if (cont == 2) {     // if 2, break the loop
                    break;
                } else {                    // else, IllegalArgumentException
                    throw new IllegalArgumentException();
                }
            }
        }

    }

    private static void setNewGame(){
        correct = false;
        inputStr = new ArrayList<String>();
        answerStr = makeRandomThreeNumber();
    }

    private static String makeRandomThreeNumber(){
        Random random = new Random();
        String first = Integer.toString(random.nextInt(9));
        String second = Integer.toString(random.nextInt(9));
        String third = Integer.toString(random.nextInt(9));

        // TODO: make the all Three Number Different

        return first + second + third;
    }

}
