/**
* @Package_name   : gamer 
* @Class_name     : ManageGamer 
*
* Create Date : 2023-10-21 
* Create User : 정은채 
*/
package gamer;

import display.ConsoleDisplay;
import utility.Const;

public class ManageGamer implements Gamer{

	/**
	* Description : ManageGamer의 게임 플레이
	*
	* @Method : play()
	*/  
	@Override
	public void play() {
		startGame();
	}

	
	/**
	* Description : 게임 시작 알림
	*
	* @Method : gameStarting()
	*/  
	public void startGame() {
		ConsoleDisplay display = new ConsoleDisplay();
		display.output(Const.STARTGAME);
	}
	
	
	/**
	* Description : 게임 종료 알림 및 게임 지속 여부 반환
	*
	* @Method : gameEnding()
    * @return : Boolean
	*/  
	public Boolean endGame() {
		ConsoleDisplay display = new ConsoleDisplay();
	
		display.output(Const.ENDGAME);
		
		int restart = Integer.parseInt(display.input());
		return (restart == 1) ? true : false;
	}
	

	/**
	* Description : 게임 에러 (사용자 입력 오류) 여부 반환
	*
	* @Method : errorGame()
    * @param  : String userString
	*/  
	public void errorGame(String userString) throws IllegalArgumentException {
		if (userString.length() != 3 || !isInteger(userString)) {
			throw new IllegalArgumentException();
		}
	}
	/**
	* Description : 숫자가 아닐 때 에러 여부 반환
	*
	* @Method : errorGame()
    * @return : Boolean
    * @param  : String userString
	*/ 
	public static boolean isInteger(String userString) {
	    try {
	      Integer.parseInt(userString);
	    } catch (NumberFormatException ex) {
	      return false;
	    }
	    return true;
	 }

}
