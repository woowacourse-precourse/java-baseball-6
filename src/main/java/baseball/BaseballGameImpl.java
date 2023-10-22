package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameImpl implements BaseballGame {
    
    static GameItemImpl gameItem = new GameItemImpl();
    
    private final int RESTART = 1;
    private final int END = 2;
    
    @Override
    public void startGame() {
        List<Integer> computer = gameItem.computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> numList = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            
            
            if (gameItem.validateLength(input)) {
                throw new IllegalArgumentException("Only 3 digits are allowed.");
            }
            
            //charAt으로 각 자리를 int형으로 변환 후 numList에 add
            for (int i = 0; i < input.length(); i++) {
                numList.add(Character.getNumericValue(input.charAt(i)));
            }
            
            if (gameItem.isDuplicated(numList)) {
                throw new IllegalArgumentException("Duplicate number entered.");
            }
            
            if(gameItem.checkForStrikes(numList,computer)) {
                break;
            }
        }
        
    }
    
    @Override
    public boolean endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int scannerInput = Integer.parseInt(Console.readLine());
        
        if (scannerInput != RESTART && scannerInput != END) {
            throw new IllegalArgumentException("Invalid number entered.");
        }      
        
        return scannerInput == END;
    }


}
