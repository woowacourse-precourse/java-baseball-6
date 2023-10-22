* 메인 메소드
    * 프로그램이 시작되면 숫자 야구 게임을 시작합니다. 출력
    * computerNumList
        * 컴퓨터 입력을 저장하는 리스트가 선언된다.
        * List\<Integer>
    * userNumList
        * 사용자 입력을 저장하는 리스트가 선언된다.
        * List\<Integer>
    * resultArray
        * 스트라이크 개수와 볼개수를 저장하는 배열
	* do while문을 사용하여 아래의 있는 것을 한번 실행 후
		* do
			* generateComputerNumber를 통해 받은 배열을 computerNumList에 넣는다.
			* 다시 이 안에 do while을통해
				* do문에
					* receiveUserNumber를 통해 userNumList에 리스트를 넣는다.
					* compare(userNumList,computerNumList) 를 통해 결과를 resultArray에 저장한다.
				* while문 조건에 checkResult를 통해 확인한다.
					* 3스트라이크면 true를 리턴해 빠져나온다.
					* 아니면 반복한다.
		* while
			* AskForRegame함수를 통해 다시 진행할 것인지 확인한다.
* generateComputerNumber
    * 컴퓨터가 랜덤 숫자 3개를 골라서 저장하는 메소드

    * computerNumList
        * 컴퓨터 숫자를 저장하는 리스트가 선언된다
        * List\<Integer>
    * 결과는 에 저장된다.
    * 저장된 배열을 리턴한다.
* receiveUserNumber
    * 사용자 입력을 받는 메소드이다.
    * 변수
        * userNumList
            * 사용자 숫자를 저장하는 리스트가 선언된다
            * List\<Integer>
        * userInput
            * 사용자 입력을 받아 저장하는 변수
    * 출력한다
        *  숫자를 입력해주세요 :
        * 줄바꿈 하지 않는다.

    * input을 받는다.
        * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

    * 숫자는 userNumList에 저장된다.

    * userNumList을 리턴한다.
    *
    *  input 예외처리
        * 숫자가 1<= x <= 9가 아닐
        * 숫자인지
        * 3글자인지
        * 서로 다른지
        * 입력을 안했을 경우
        * 이를 위해 정규 표현식을 사용하자
        * 규칙에 어긋나면 `IllegalArgumentException`을 발생시킨 후 애플리케이
* compare
    * 사용자 입력 숫자를 컴퓨터 숫자와 비교하는 함수
    *
    * 변수선언
        * int[] resultArray 선언
            * 스트라이크와 볼개수를 저장하는 배열을 선언한다.
            * 크기는 2이다.

        * int [] resultArray을 선언한다.
            * index 개수가 2인 배열
            * index 0은 스트라이크 개수
            * index 1은 볼 개수
        * int strikeNum
        * int ballNum
        * userNumberCheckArray
            * 인덱스는 0<= x <= 9이다.
            * 숫자가 1부터 9까지이므로 인덱스 0은 무시한다.
            *
        * computerNumberCheckArray
            * 인덱스는 0<= x <= 9이다.
            * 숫자가 1부터 9까지이므로 인덱스 0은 무시한다.

    * 매개변수로 사용자 숫자 배열, 컴퓨터 숫자 배열을 받는다.

    * 스트라이크랑 볼개수를 체크한다.
        * 1. 스트라이크 개수를 체크한다.
            * 두 리스트 for문으로 체크하여 같을 때 , strikeNum++
            * 이 때 숫자에 해당하는 CheckArray를 +1해준다.
        * 2. 볼개수를 체크한다.
            * 두 checkArray를 for문을 돌린다
                * 같은 인덱스의 값이
                * 0이 아니면서
                * 같으면
                * ballNum++
    * strikeNum과 ballNum을 resultArray에 넣고
    * resultArray를 리턴한다.


* checkResult
    * 스트라이크 개수를 확인하여 결과를 반환하는 함수
    * 매개변수로 배열을 받는다.
    * 배열의 인덱스가 3이면
        * 출력
            * 3개의 숫자를 모두 맞히셨습니다! 게임 종료
        * true리턴
    * 아니면 false리턴
    *

* printResult
    * 결과를 사용자에게 출력하는 함수
    * 매개변수로 배열을 받는다.
        * 인덱스 0 :
            * 스트라이크 개수 strikeNum
        * 인덱스  1:
            * 볼 개수 ballNum
    * int strikeNum
        * 스트라이크 개수
    * int ballNum
        * 볼 개수
    * 스트라이크 개수와 볼 개수에 따라 if문으로 분기하여 출력한다
        * strikeNum != 0 and ballNum != 0
        *  strikeNum == 0 and ballNum != 0
        *  strikeNum != 0 and ballNum == 0
        *  strikeNum == 0 and ballNum == 0
* askForRegame
    * 게임을 다시 할지 확인하는 함수
    * 변수
        * String userInput
            * 유저한테 받은 입력을 저장한다.
        * Int checkInt
            * 문자열 입력을 숫자로 변환한다.
    * 출력한다
        * 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

    * input을 받아서 userInput이라는 String 변수에 저장한다.
        * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
        * 예외 처리
            * 입력을 하지 않았을 경우
            * 1, 2이외의 다른 문자, 숫자를 입력하였을 경우
            * 규칙에 어긋나면 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
    * 1이면  재시작이므로 true 리턴
    * 2이면 종료이므로 false 리턴
* exceptionHandlingForRegame
    *  종료, 재시작에 대한 입력에 대해 예외 처리하는 함수
    * 매개변수로는 사용자 입력 스트링을 받는다.
        * String userInput
    * 정규 표현식으로 1, 2이외의 것들은 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
* exceptionHandlingForUserInput
    * 숫자가 1<= x <= 9가 아닐
    * 숫자인지
    * 3글자인지
    * 서로 다른지
    * 입력을 안했을 경우
    * 이를 위해 정규 표현식을 사용하자
    * 규칙에 어긋나면 `IllegalArgumentException`을 발생시킨 후 애플리케이션

    * 정규표현식
        * String regularExpForUserNumber = "^\[1-9]{3}"
* 자바 try catch
* 
