package baseball;

public class Runner { //게임 전체 진행자. 즉 게임의 흐름도를 나타내는 클래스
    private static String GAME_RESTART;
    private static String GAME_END;
    private static CheckForm checkForm;
    private static IO io;
    private Game game;

    public Runner(GameConfiguration gameConfig, IO io) {
        this.game = gameConfig.getGame();
        this.checkForm = gameConfig.getCheckForm();
        this.GAME_RESTART = gameConfig.getConstant().getGAME_RESTART(); //상수 가독성을 위해 메서드 호출을 통한 접근법을 사용했습니다.
        this.GAME_END = gameConfig.getConstant().getGAME_END();
        this.io = io;
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다."); //IO 클래스로 관리할 이유는 없는 것 같아 해당 출력문을 함수로 만들지 않았습니다.
        String judge = "firstStart"; //게임 진행상태를 판단해줄 변수

        game.createAnswer(); // 랜덤의 답 생성
        while(!judge.equals(GAME_END)){
            try {
                String input = io.input();
                CheckForm.Input(input);

                int number = Integer.parseInt(input);
                judge = game.judgeGame(number);

                if(judge.equals("SUCCESS")){
                    judge = io.success();
                    checkForm.Restart_Input(judge); //사용자가 1,2 가 아닌 다른 수나 문자를 입력했을 때 예외처리
                    if(judge.equals(GAME_RESTART)) game.createAnswer(); //새로운 답안 생성
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }

}
