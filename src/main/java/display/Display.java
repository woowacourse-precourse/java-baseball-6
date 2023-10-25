/**
* @Package_name   : display
* @Interface_name : Display 
*
* Create Date : 2023-10-21 
* Create User : 정은채
*/
package display;

public interface Display {
	/**
	* Description : String 입력
	*
	* @Method : input()
    * @return : String
	*/  
	public String input();
	
	/**
	* Description : String 출력 
	*
	* @Method : output()
	* @param  : String print
	*/  
	public void output(String print);

}