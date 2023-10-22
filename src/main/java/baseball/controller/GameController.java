package baseball.controller;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.service.GameService;
import baseball.service.UserService;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final GameService gameService;
    private final UserService userService;
    private User user;

    public GameController() {
        this.gameService = new GameService();
        this.userService = new UserService();
    }

    public void startProgram(){
        /* 로그인 */
        user = new User();
        user.setName("user1");
        userService.join(user);

        /* 인트로 */
        System.out.println("숫자 야구 게임을 시작합니다.");

        Boolean flag = true;

        /* 게임 시작 */
        while(flag){
            Long gameId = newGame();
            List<Integer> computerNumber = gameService.findOne(gameId).get().getComputerNumber();
            Boolean isCorrect = false;

            while(!isCorrect){
                List<Integer> userNumber = setUserNumber();
                isCorrect = checkCorrect(computerNumber, userNumber);
            }

            /* 메뉴 표출*/
            flag = showMenu();
        }
    }

    private Boolean showMenu(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
        String message = "";

        if (count.get(0) + count.get(1) == 0){
            message += "낫싱";
        } else if (count.get(0) > 0 && count.get(1) == 0) {
            message += count.get(0) + "볼";
        } else if (count.get(1) > 0 && count.get(0) == 0){
            message += count.get(1) + "스트라이크";
        }else{
            message += count.get(0) + "볼 " + count.get(1) + "스트라이크";
        }
        System.out.println(message);

        if (count.get(1) == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        checkInputNumber(number);
        return Arrays.stream(number.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    private void checkInputNumber(String input){
        for (int i=0;i<3;i++) {
            try{
                Integer.parseInt(input);
            }catch (IllegalArgumentException e){
                throw  new IllegalArgumentException();
            }
        }
        if (input.length() != 3) {
            throw  new IllegalArgumentException();
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0;i<3;i++) {
            if (numbers.contains(Character.getNumericValue(input.charAt(i)))){
                throw  new IllegalArgumentException();
            }
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        if (input.contains("0")){
            throw  new IllegalArgumentException();
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
