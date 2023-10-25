package baseball.Controller;

import baseball.Model.BaseballGameModel;
import baseball.View.BaseballGameView;

import java.util.HashSet;
import java.util.Set;

public class BaseballGameController {

    private final static BaseballGameModel model = new BaseballGameModel();
    private final static BaseballGameView view = new BaseballGameView();
    private static final String SINGLE_GAME_END = "3스트라이크";

    public void play(){
        do{
            playSingleGame();
        }while (choiceStartNewGame());
    }

    private void playSingleGame(){
        view.gameStart();
        model.createRandomNumbers();
        String gameResult;
        do {
            String userInput = view.getUserInput();
            validateUserInput(userInput);
            gameResult = model.calculateResult(userInput);
            view.print(gameResult);
        } while (!gameResult.equals(SINGLE_GAME_END));
        view.endPrint();
    }

    private boolean choiceStartNewGame(){
        try {
            String endUserInput = view.endUserInput();
            if(endUserInput.equals("1")){
                return true;
            }else if(endUserInput.equals("2")){
                return false;
            }else {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void validateUserInput(String userInput){
        try{
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("세자리 수를 입력해야합니다.");
            }
            Set<Character> digit = new HashSet<>();
            for(char c : userInput.toCharArray()){
                if(!Character.isDigit(c)){
                    throw new IllegalArgumentException("각 자리는 숫자로 입력해야합니다.");
                }
                digit.add(c);
            }

            if(digit.size()!=3){
                throw new IllegalArgumentException("세 개의 다른 숫자로 입력해야합니다.");
            }

        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
    }
}
