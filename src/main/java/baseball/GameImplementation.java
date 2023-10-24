package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameImplementation implements Game{

    private String playerAnswer;
    private List<Integer> computerAnswer;
    private int ballCount;
    private int strikeCount;

    private List<Integer> playerAnswerList = new ArrayList<>();

    public GameImplementation(){
    }

    public void setPlayerAnswer(String playerAnswer) {
        this.playerAnswer = playerAnswer;
    }
    public List<Integer> getPlayerAnswerList() {
        return playerAnswerList;
    }


    @Override
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gamePlay();
    }

    @Override
    public List<Integer> makeAnswer() {
        return Computer.getInstance().makeNewAnswer();
    }

    @Override
    public void gamePlay() {
        computerAnswer=makeAnswer();
        boolean isAnswer=false;

        while (!isAnswer) {
            System.out.print("숫자를 입력해주세요: ");
            playerAnswer = Console.readLine();

            if (playerAnswer.length() != 3 || !playerAnswer.matches("\\d{3}")) {
                throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
            }
            makePlayerAnswerToList();
            isAnswer = validateAnswer();
        }

        gameEnd();
    }

    public void makePlayerAnswerToList(){
        playerAnswerList.clear();
        for (int i = 0; i < playerAnswer.length(); i++) {
            char c = playerAnswer.charAt(i);
            int digit = Character.getNumericValue(c);
            playerAnswerList.add(digit);
        }
    }

    private boolean validateAnswer(){
        ballCount=0;
        strikeCount=0;

        try {
            for (int i = 0; i < playerAnswerList.size(); i++) {
                int curNum = playerAnswerList.get(i);
                if (computerAnswer.get(i) == curNum) {
                    strikeCount++;
                } else {
                    if (computerAnswer.contains(curNum)) {
                        ballCount++;
                    }
                }
            }
        }catch (NullPointerException e) {
        }

        printAnswer();

        if(strikeCount==3)
            return true;
        else{
            return false;
        }
    }

    private void printAnswer(){
        if(ballCount!=0){
            System.out.printf("%d볼 ",ballCount);
        }
        if(strikeCount!=0){
            System.out.printf("%d스트라이크",strikeCount);
        }
        if(ballCount==0 && strikeCount==0){
            System.out.printf("낫싱");
        }
        System.out.printf("\n");
    }

    @Override
    public void gameEnd() {
        System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String key=Console.readLine();
        if("1".equals(key)) {
            gamePlay();
        }
        else if("2".equals(key)) {
            return;
        }
        else{
            throw new IllegalArgumentException("올바르지 않은 값입니다.");
        }
    }

}
