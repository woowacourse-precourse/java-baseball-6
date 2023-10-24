package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private final Validation validation = new Validation();
    private final Processing processing = new Processing();
    List<Integer> computer;

    public Game(){
        RandomNumber randomNumber = new RandomNumber();
        computer = randomNumber.getRandomNumbers();
//        System.out.println("컴퓨터 랜덤숫자: " + computerNumbers);
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameStart() {
        int strikes = 0;
        int balls = 0;
        System.out.print("숫자를 입력해주세요 : ");
        String userInputValue = Console.readLine();
        System.out.println(userInputValue);
        validation.isUserInputValidate(userInputValue);
        List<Integer> userInputNumbers = processing.convertStringToInteger(userInputValue);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (userInputNumbers.get(i).equals(computer.get(i))){
                    strikes++;
                    break;
                }
                if (userInputNumbers.get(i).equals(computer.get(j))){
                    balls++;
                    break;
                }
            }
        }
        String gameResult = getGameResult(strikes, balls);
        if (gameResult.equals("3스트라이크")){
            System.out.println(gameResult);
            restartOrExit();
        } else {
            System.out.println(gameResult);
            replay();
        }
    }

    public void restartOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String choice = Console.readLine();
        if (choice.equals("1")){
            restart();
        } else if (choice.equals("2")){
            System.out.println("게임 종료");
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public void replay(){
        gameStart();
    }

    public void restart(){
        Game game = new Game();
        game.gameStart();
    }

    public String getGameResult(int strikes, int balls) {
        String result = "";
        if (strikes == 3){
            result = strikes + "스트라이크";
        } else if (strikes == 0 && balls == 0){
            result = "낫싱";
        } else if (balls == 0){
            result = strikes + "스트라이크";
        } else if (strikes == 0){
            result = balls + "볼";
        } else {
            result = balls + "볼 " + strikes + "스트라이크";
        }
        return result;
    }
}