package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        final String[] computerNumbers = new String[3];
        String[] playerNumbers;
        boolean isAnswer = false;

        // [기능 1] 컴퓨터가 1 - 9 서로 다른 임의의 수 3개 선택하는 기능
        for (int i = 0; i < 3; i++) {
            computerNumbers[i] = String.valueOf(Randoms.pickNumberInRange(1, 9));
        }

        // [기능 4] 1 - 3 과정을 계속 반복하고 컴퓨터가 선택한 숫자 3개를 모두 맞히면 게임이 종료되는 기능
        while(!isAnswer) {
            playerNumbers = getValidatedInput();
            isAnswer = playGame(computerNumbers, playerNumbers);
        }
        // [기능 5] 게임 종료 후 플레이어가 게임을 다시 시작하거나 완전히 종료시킬 수 있는 기능 (1: 재시작, 2: 종료)
    }

    // [기능 2] 플레이어에게 컴퓨터가 생각한 서로 다른 3개의 숫자를 입력받는 기능
    // [기능 6] 플레이어가 잘못된 값(범위 밖, 중복된 숫자, 빈 입력, 다른 개수)을 입력하면 IllegalArgumentException 발생시킨 후 종료하는 기능
    private static String[] getValidatedInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        // 숫자 이외 값을 입력한 경우 & 빈 입력인 경우
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException exception){
            throw new IllegalArgumentException("입력한 값이 숫자가 아니거나 빈 입력입니다.");
        }
        // 3자리 숫자를 입력하지 않은 경우
        if(input.length() != 3){
            throw new IllegalArgumentException("입력 값이 3자리가 아닙니다.");
        }
        // 중복된 숫자를 입력한 경우
        String[] letters = input.split("");
        if(letters[0].equals(letters[1]) || letters[0].equals(letters[2]) || letters[1].equals(letters[2])){
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
        }
        return letters;
    }

    // [기능 3] 컴퓨터가 플레이어가 입력한 숫자에 대한 숫자야구 게임 결과를 출력하는 기능
    private static boolean playGame(String[] computerNumbers, String[] playerNumbers){
        
        return false;
    }
}
