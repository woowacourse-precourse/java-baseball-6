package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private List<Integer> computer;
    private List<Integer> user;

    public Game() {
        computer = new ArrayList<>();
        user = new ArrayList<>();
    }

    private void createComputerNumber(){
        int randomNumber;

        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void inputUserNumber(){
        String[] userInput = readLine().split("");

        for(int index = 0; index < 3; index++){
            user.add(Integer.parseInt(userInput[index]));
        }
    }

    public void play(){
        Script script = new Script();
        Judgment judgment = new Judgment(computer, user);

        createComputerNumber();
        script.startGame();

        script.inputNumber();
        inputUserNumber();

        judgment.judge();

        if(judgment.isUserWin()){
            script.endGame();
        }
    }
}
