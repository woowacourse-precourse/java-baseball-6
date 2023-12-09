package baseball;

import java.util.ArrayList;

import static baseball.Constants.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    ArrayList<Integer> num = new ArrayList<>();

    public Game() {
        setRandomNum();
    }

    private Game(String str){
        for(int i = 0; i < NUM_SIZE;  i++){
            num.add(Integer.parseInt(str.charAt(i) + ""));
        }
    }

    private void setRandomNum() {
        int numIdx = 0;
        while(numIdx < NUM_SIZE){
            int randNum = getRandomNum();
            if(!Array.checkArrayContains(num, randNum)){
                num.add(randNum);
                numIdx++;
            }
        }
    }
    private int getRandomNum() {
        return pickNumberInRange(NUM_START, NUM_END);
    }

    public static void init(Game correctAnswer){
        Game answer = new Game(getAnswer());
        Hint hint = new Hint();
        hint.compareAns(answer, correctAnswer);
        hint.printResult();

        if(hint.strike != NUM_SIZE){
            Game.init(correctAnswer);
            return;
        }

        int newGameAnswer = checkNewGameStart();
        if(newGameAnswer == GAME_RESTART) {
            correctAnswer = new Game();
            Game.init(correctAnswer);
        }
    }

    private static String getAnswer() {
        System.out.print(GET_NUM_MESSAGE);
        String input = readLine();
        checkException(input);

        return input;
    }

    private static int checkNewGameStart() {
        System.out.println(ALL_CORRECT + CORRECT_MESSAGE);
        System.out.println(RETRY_MESSAGE);

        return getNewGameAnswer(readLine());
    }

    private static int getNewGameAnswer(String str){
        int intVal;
        try {
            intVal = Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return intVal;
    }

    static void checkException(final String str){
        if(str.length() != NUM_SIZE){
            throw new IllegalArgumentException();
        }
        if(!checkInput(str)){
            throw new IllegalArgumentException();
        }
        if(!equalInput(str)){
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInput(String str){
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e){
            return false;
        }

        ArrayList<Character> charArray = Array.getArrayFromStr(str);
        return !Array.checkArrayContains(charArray, '0');


    }

    static boolean equalInput(String str){
        ArrayList<Character> checkEqual = new ArrayList<>();
        ArrayList<Character> word = Array.getArrayFromStr(str);

        for(int i = 0; i < str.length(); i++) {
            if (Array.checkArrayContains(checkEqual, word.get(i))) {
                return false;
            }
            checkEqual.add(word.get(i));
        }
        return true;
    }
}
