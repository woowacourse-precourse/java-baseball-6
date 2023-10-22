package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;


/**
 * BaseballGame 인터페이스를 구현한 게임 클래스입니다.
 * 게임을 시작하고 종료하는 메서드를 제공합니다.
 * 
 * @author 김지환
 */
public class BaseballGameImpl implements BaseballGame {
    
    static GameItemImpl gameItem = new GameItemImpl();
    
    private final int RESTART = 1;
    private final int END = 2;
    
    /**
     * 숫자 야구를 시작하는 메서드입니다.
     */
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
    
    /**
     * 게임을 종료하거나 새로 시작할지를 결정하는 메서드입니다.
     * 
     * @return 게임을 종료할 경우 true, 새로 시작할 경우 false
     */
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
