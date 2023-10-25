package baseball;

import baseball.constants.GameConstants;

public class Controller {
    public Service service = new Service();

    //게임 전체
    public void playGame(){
        while(service.reStart) {
            int[] answerNums = startGame();
            while(!service.isThisGameOver) {
                runGame(answerNums);
            }
            endGame();
        }
    }

    // 게임 시작 후 랜덤 숫자 생성
    public int[] startGame(){
        System.out.println(GameConstants.START_GAME);
        return service.creRandomNums();
    }

    //게임숫자 입력받음
    public void runGame(int[] answerNums){
        System.out.print(GameConstants.REQUEST_NUMS);
        int[] userNums = service.inputNums();
        service.calcResult(userNums, answerNums);
        String result = service.generateGameResult();
        System.out.println(result);
    }

    //게임 종료 후 재시작 여부
    public void endGame(){
        System.out.println(GameConstants.END_GAME);
        System.out.println(GameConstants.ASK_RESTART);
        service.askReStart();
    }
}
