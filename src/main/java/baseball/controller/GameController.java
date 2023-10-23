package baseball.controller;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.repository.MemoryGameRepository;
import baseball.repository.MemoryUserRepository;
import baseball.service.GameService;
import baseball.service.MessageService;
import baseball.service.NumberService;
import baseball.service.UserService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    private final GameService gameService;
    private final UserService userService;
    private final MessageService messageService;
    private final NumberService numberService;
    private User user;

    public GameController(MemoryGameRepository gameRepository, MemoryUserRepository userRepository) {
        this.messageService = new MessageService();
        this.numberService = new NumberService();
        this.gameService = new GameService(gameRepository);
        this.userService = new UserService(userRepository);
    }

    public void startProgram(){
        /* 로그인 */
        login();

        /* 인트로 */
        messageService.intro();

        Boolean flag = true;
        while(flag){
            /* 게임 시작 */
            Long gameId = newGame();
            List<Integer> computerNumber = gameService.findOne(gameId).get().getComputerNumber();
            Boolean isCorrect = false;

            while(!isCorrect){
                /* 정답을 맞출때 까지 반복 */
                gameService.addQestionCount(gameService.findOne(gameId).get());

                messageService.inputUserNumber();
                List<Integer> userNumber = numberService.setUserNumber();

                isCorrect = checkCorrect(computerNumber, userNumber);
            }
            /* 메뉴 표출*/
            flag = showMenu();
        }
    }

    private void login(){
        user = new User();
        user.setName("user1");
        userService.join(user);
    }

    private Boolean showMenu(){
        messageService.menu();

        String answer = Console.readLine();
        if (answer.equals("1")) {
            return true;
        }else if (answer.equals("2")){
            return false;
        }else {
            throw new IllegalArgumentException();
        }
    }

    private Boolean checkCorrect(List<Integer> computerNumber, List<Integer> userNumber){
        List<Integer> count = checkBall(computerNumber, userNumber);
        messageService.result(count);

        if (count.get(1) == 3){
            messageService.gameOver();
            return true;
        } else{
            return false;
        }
    }

    private List<Integer> checkBall(List<Integer> computerNumber, List<Integer> userNumber){
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if (computerNumber.contains(userNumber.get(i))){
                ball += 1;
            }
            if (computerNumber.get(i) == userNumber.get(i)){
                strike += 1;
                ball -= 1;
            }
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(ball, strike));
        return list;
    }

    private Long newGame(){
        Game game = new Game();
        game.setUserId(user.getId());

        List<Integer> computerNumber = numberService.setRandomNumber();
        game.setComputerNumber(computerNumber);
        game.setQuestionCount(0L);

       return gameService.join(game);
    }
}
