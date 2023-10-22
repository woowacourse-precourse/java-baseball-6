package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
public class Player {
    private ArrayList<Integer> inputNumbers;
    private final int digitCount;
    public Player(int digitCount){
        this.digitCount = digitCount;
    }

    public void takeThreeNumberInput(){
        this.inputNumbers = new ArrayList<Integer>();

        String userInputNumber = readLine();
        if (userInputNumber.length() != this.digitCount){
            throw new IllegalArgumentException();
        }
        for (int inputNumberIndex = 0; inputNumberIndex < userInputNumber.length(); inputNumberIndex++){
            char characterNumber = userInputNumber.charAt(inputNumberIndex);
            char characterOne = '1';
            char characterNine = '9';
            if (characterNumber < characterOne || characterNumber > characterNine){
                throw new IllegalArgumentException();
            }

            int intNumber = characterNumber - '0';
            if (this.inputNumbers.contains(intNumber)){
                throw new IllegalArgumentException();
            }
            this.inputNumbers.add(intNumber);
        }
        assert this.inputNumbers.size() == this.digitCount : "the size of inputNumbers must be same as digitCount";
    }

    public int getInputCount(){
        return this.inputNumbers.size();
    }

    public int getNumberAt(int idx){
        return this.inputNumbers.get(idx);
    }



    public GameAction takeGameAction(){
        String gameAction = readLine();
        if (gameAction.length() != 1){
            throw new IllegalArgumentException();
        }
        if (gameAction.equals("1")){
            return GameAction.CONTINUE;
        }
        if (gameAction.equals("2")){
            return GameAction.QUIT;
        }
        throw new IllegalArgumentException();

    }
}
