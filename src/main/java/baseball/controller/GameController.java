package baseball.controller;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.service.GameService;
import baseball.service.MessageService;
import baseball.service.UserService;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final GameService gameService;
    private final UserService userService;
    private final MessageService messageService;
    private User user;

    public GameController() {
        this.messageService = new MessageService();
        this.gameService = new GameService();
        this.userService = new UserService();
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
                List<Integer> userNumber = setUserNumber();
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
    private List<Integer> setUserNumber(){
        messageService.inputUserNumber();
        String number = Console.readLine();

        checkInputNumber(number);

        return Arrays.stream(number.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    private void checkInputNumber(String input){
        /* 숫자 판별 */
        for (int i=0;i<3;i++) {
            try{
                Integer.parseInt(input);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException();
            }
        }
        /* 길이 판별 */
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        /* 중복 판별 */
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0;i<3;i++) {
            if (numbers.contains(Character.getNumericValue(input.charAt(i)))){
                throw new IllegalArgumentException();
            }
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        /* 0 판별 */
        if (input.contains("0")){
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> setRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private Long newGame(){
        Game game = new Game();
        game.setUserId(user.getId());

        List<Integer> computerNumber = setRandomNumber();
        game.setComputerNumber(computerNumber);
        game.setQuestionCount(0L);

       return gameService.join(game);
    }
}
