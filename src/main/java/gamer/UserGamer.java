/**
* @Package_name   : gamer 
* @Class_name     : UserGamer 
*
* Create Date : 2023-10-21 
* Create User : 정은채 
*/
package gamer;

import java.util.ArrayList;
import display.ConsoleDisplay;
import utility.Const;

public class UserGamer implements Gamer{
	//생성자
	public UserGamer() {
		this.userNumberArr = new ArrayList<>();
	}
	
	/**
	* Description : UserGamer의 게임 플레이
	*
    * @Method : play
    */
	@Override
	public void play() {
		tryingUserNumber();
	}
	
	// 사용자 입력 정답 숫자리스트 (검사 완료)
	private ArrayList<Integer> userNumberArr;
	// 사용자 입력 정답 문자열리스트 (검사 전)
	public String userNumbers;
	
	/**
	* Description : 사용자 입력 숫자리스트 반환
	*
    * @Method : getUserNumberArr
    * @return : ArrayList
    */ 
	public ArrayList<Integer> getUserNumberArr() {
		return this.userNumberArr;
	}
	
	/**
	* Description : 사용자 입력 숫자 입력받기 (검사 전)
	*
    * @Method : tryingUserNumber
    */ 
	private void tryingUserNumber() {
		ConsoleDisplay display = new ConsoleDisplay(); 
		display.output(Const.USERNUMINPUT);
		userNumbers = display.input(); 
	}
	
	/**
	* Description : 사용자 입력 숫자리스트 저장 (검사 완료)
	*
    * @Method : setUserNumberArr
    */ 
	public void setUserNumberArr() {
		String[] userStringlist = userNumbers.split("");//한 자씩 쪼갠 사용자 입력 문자열리스트
		userNumberArr.clear();
		for (int i = 0 ; i < 3 ; i++) {
			userNumberArr.add(Integer.parseInt(userStringlist[i]));
		}
	}
}