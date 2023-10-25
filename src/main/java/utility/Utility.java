/**
* @Package_name   : utility
* @Class_name     : Utility 
*
* Create Date : 2023-10-21 
* Create User : 정은채
*/
package utility;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Utility {
	
	/**
	* Description : camp.nextstep.edu.missionutils.Console에서 제공하는 Console API 사용
	*
	* @Method : campReadline()
    * @return : String
	*/ 
	public static String campReadline() {
		String string = Console.readLine();
		return string;
	}
	
	/**
	* Description : camp.nextstep.edu.missionutils.Randoms에서 제공하는 pickNumberInRange API 사용
	*
	* @Method : campPickNumberInRange()
    * @return : Integer
	*/ 
	public static Integer campPickNumberInRange() {
		int num = Randoms.pickNumberInRange(1, 9); // Integer 반환
		return num;
	}

}