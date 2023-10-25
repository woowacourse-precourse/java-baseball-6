package baseball;

import baseball.StringEnums.TextProperties;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Stream;

/***
 * 야구게임
 */
public class Game {
    private static final int NUMBER_OF_BASEBALL = 3;
    private static final int START_NUMBER= 1;
    private static final int LAST_NUMBER= 9;
    private static final int RE_START_NUMBER = 1;
    private User user;
    private Computer computer;
    public Game(){
        System.out.println(TextProperties.GAME_START);
        do {
            computer = createComputer();
            gameTurn();
            System.out.println(TextProperties.GAME_OVER);
            System.out.println(TextProperties.RE_START);
        }while(reStart());
    }

    /***
     * 게임의 턴
     * 요구사항 : 유저는 턴마다 3개의 숫자를 입력할 수 있어야 한다. 3개가 전부 맞을시 게임은 종료된다.
     * 결과 : void타입으로 반환이없다.
     */
    private void gameTurn(){
        while (true) {
            System.out.print(TextProperties.INPUT_NUMBER);
            user = userSelectNumber();
            int strike = strike();
            int ball = ball();
            if(strike==NUMBER_OF_BASEBALL){
                System.out.println(strike+""+TextProperties.STRIKE);
                System.out.print(TextProperties.ANSWER);
                break;
            }
            if (ball == strike&&ball!=0) {
                System.out.println(strike+""+TextProperties.STRIKE);
                continue;
            }
            if(strike==0&&ball==0)
            {
                System.out.println(TextProperties.NOT_THING);
            }
            else if(strike==0) {
                System.out.println(ball - strike+""+TextProperties.BALL);
            }
            else{
                System.out.println(ball- strike+""+TextProperties.BALL+" "+strike+TextProperties.STRIKE);
            }
        }
    }

    /***
     * 유저는 3개의 숫자를 구한다
     * @return 새롭게 생성된 유저를 반환한다.(새롭게 선택된 숫자)
     */
    private User userSelectNumber(){
        int[] numbers = selectNumber();
        return new User(numbers[0],numbers[1],numbers[2]);
    }

    /***
     * 컴퓨터는 랜덤넘버를 사용하여 숫자를 정해준다
     * @return START_NUMBER, LAST_NUMBER 사이의 랜덤으로 생성된 숫자
     */
    private int randomNumber(){
       return Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER);
    }

    /***
     * 콘솔에서 세가지 숫자를 입력받는다
     * @return 입력받은 세가지 숫자를 array타입으로 반환한다.
     */
    private int[] selectNumber(){
        String line = Console.readLine();
        lineLengthCheck(line,NUMBER_OF_BASEBALL);
        intTypeCheck(line);
        int[] numbers = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
        equalNumberCheck(numbers);
        zeroCheck(numbers);
        return numbers;
    }

    /***
     * 야구게임은 중복된 숫자를 입력받을 수 있으면 안된다
     * @param num user가 가진 숫자목록
     */
    private void equalNumberCheck(final int[] num){
        if(num.length != Arrays.stream(num).distinct().count())
            throw new IllegalArgumentException(TextProperties.DUP_NUMBER.getValue());
    }

    /***
     * 재시작을 입력받는다
     * @return 1은 재시작, 2는 종료 이다.
     */
    private boolean reStart(){
        String line = Console.readLine();
        intTypeCheck(line);
        lineLengthCheck(line,RE_START_NUMBER);
        reStarCheck(line);
        return line.equals(String.valueOf(RE_START_NUMBER));
    }

    /***
     * 컴퓨터를 생성(게임의 종료조건)
     * @return 새로운 컴퓨터는 반환한다.(종료 조건)
     */
    private Computer createComputer(){
        int[] numbers = new int[NUMBER_OF_BASEBALL];
        for (int i=0; i<NUMBER_OF_BASEBALL; i++) {
            numbers[i]=randomNumber();
        }
        return new Computer(numbers[0],numbers[1],numbers[2]);
    }

    /***
     * 게임의 입력시 콘솔길이제한을 확인한다
     * @param line 원문
     * @param range 조건의 따른 길이 제한
     */

    private void lineLengthCheck(final String line,final int range){
        if(line.length()!=range)
            throw new IllegalArgumentException(TextProperties.NOT_THREE_BALL.getValue());
    }

    /***
     * 입력받은 문자열은 모두 int타입으로 변환가능해야한다
     * @param line 입력받은 문자열
     */
    private void intTypeCheck(final String line){
        try {
            Integer.parseInt(line);
        }catch (NumberFormatException e)
        {
            throw new IllegalArgumentException(TextProperties.NOT_NUMBER.getValue());
        }
    }

    /***
     * 재시작조건에 일치하는지 확인한다.
     * @param reStart 재시작 번호
     */
    private void reStarCheck(String reStart){
        if(!reStart.equals("1")&&!reStart.equals("2"))
            throw new IllegalArgumentException(TextProperties.NOT_RANGE.getValue());
    }

    /***
     * 모든 조건에서 0이라는 입력은 있을 수 없다.
     * @param ball 유저의 숫자 리스트
     */
    private void zeroCheck(int[] ball){
        if(containsNumber(ball,0))
            throw new IllegalArgumentException(TextProperties.NOT_RANGE.getValue());
    }

    /***
     * 배열에 target에 숫자가 있는지 확인한다.
     * @param arr 컴퓨터의 숫자목록
     * @param target 유저의 타깃숫자
     * @return 일치한다면 true를 반환한다.
     */
    private boolean containsNumber(final int[] arr,final int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    /***
     * ball은 위치만 일치하면 되기때문에 리스트에 존재하는지만 확인하면 된다.
     * @return 총 몇개의 볼이 일치했는지 카운트를 반환한다.
     */
    private int ball(){
        int ballCount = 0;
        int[] userBallList = user.getPossessionBaseBall();
        for(int i=0;i<NUMBER_OF_BASEBALL;i++)
        {
            if(containsNumber(computer.getPossessionBaseBall(),userBallList[i])){
                ballCount++;
            }
        }
        return ballCount;
    }

    /***
     * 스트라이크는 인덱스 위치까지 동일해야하기에 유저와 컴퓨터의 인덱스는 동시에 늘어난다.
     * @return 총 몇개의 스트라이크가 나왔는지 count를 반환한다.
     */
    private int strike(){
        int ballCount = 0;
        int[] computerBallList = computer.getPossessionBaseBall();

        int[] userBallList = user.getPossessionBaseBall();
        for(int i=0;i<NUMBER_OF_BASEBALL;i++)
        {
            if(computerBallList[i]==userBallList[i]){
                ballCount++;
            }
        }
        return ballCount;
    }
}
