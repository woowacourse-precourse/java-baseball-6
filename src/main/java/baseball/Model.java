package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model{
    private static final int NUM_SIZE = 3;
    private static final String BALL_SENTENCE = "볼 ";
    private static final String STRIKE_SENTENCE = "스트라이크 ";
    private static final String NOTING_SENTENCE = "낫싱 ";
    private static final String ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다 ! 게임 종료";
    View view = new View();
    public List<Integer> initComputerNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> initPlayerNum(){
        view.inputText();
        String inputNum = Console.readLine();

        return stringToArrayList(inputNum);
    }

    public List<Integer> stringToArrayList(String input){
        List<Integer> numList = new ArrayList<>();

        for(int i = 0; i < input.length(); i++){
            char numChar = input.charAt(i);
            int number = Character.getNumericValue(numChar);
            numList.add(number);
        }

        return numList;
    }




}