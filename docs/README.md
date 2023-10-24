
* 패키지
    * user
        * User인터페이스
    * game
        * Game인터페이스
    * gameMarchine
        * GameMarchine인터페이스

* User클래스
    * 기능
        * 게임 삽입
        * 랜덤 수 넣기
        * 다시 시작하는 입력 넣기
    * 메서드
        * String InputUserNumber()
            * 변수
                * String userInput
            * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

* Game클래스
    * 기능
        * 게임 시작하기
        * 1.인사하기
        * 2.컴퓨터 랜덤 수 생성하기
        * 3.사용자에게 입력 요구하기
            * 예외 확인
        * 4.볼 스트라이크 개수 확인하기
            * != 3스트라이크
                * 게임 머신에게 출력할 것 넘기기 
                * 3.으로 돌아가기
            * 3스트라이크
                * 사용자에게 다시 게임할지 입력 요구 게임머신에게 출력 넘기기
                * 입력 받기
                    * 예외처리
    * 변수
        * 텍스트 변수들
            *  숫자를 입력해주세요 : (개행x)
            * 
        * private static List\<Integer> gameNumList
        * 
            * 
    * 메소드
        * public void startGame()
            * 게임 로직
                * forwardText("")
        * private String fowardText(String text)
            * game에게 텍스트를 받아서 gameMarchine으로 넘긴다.
        * private String askForInput(String case)
            * 입력을 gameMarchine에게 요구하여 받아온다.
        * private void handleException(case, input)
            * 예외처리한다.
            *  input 예외처리
            * 숫자가 1<= x <= 9가 아닐 
            * 숫자인지
            * 3글자인지
            * 서로 다른지
            * 입력을 안했을 경우
            * 이를 위해 정규 표현식을 사용하자
            * 규칙에 어긋나면 `IllegalArgumentException`을 발생시킨다.
        * private List\<Integer> generateGameNumber()
            * 컴퓨터가 랜덤 숫자 3개를 골라서 저장하는 메소드
              
            * computerNumList
                * 컴퓨터 숫자를 저장하는 리스트가 선언된다
                * List\<Integer>
            * 결과는 List에 저장된다.
            * 저장된 배열을 리턴한다.
        * private Boolean compare()
            * 사용자 입력 숫자를 컴퓨터 숫자와 비교하는 함수
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
        * private Boolean checkResult(List\<Integer>)
            * 스트라이크 개수를 확인하여 결과를 반환하는 함수
            * 매개변수로 배열을 받는다.
            * 배열의 인덱스가 3이면a
                * 출력
                    * 3개의 숫자를 모두 맞히셨습니다! 게임 종료
                * true리턴
            * 아니면 false리턴
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
* GameMarchine클래스
    * 변수
        * private static askingRegame
            *  = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    * 기능
        * 게임 받기
        * 게임 시작하기
        * 입력 받아서 넘기기
        * 출력 받아서 띄우기

    * 변수
        * static final game
    * 메소드
        * recognizeGame(game)
            * 게임을 세팅한다.
        * runGame(game)
            * 게임을 시작하고
            * 게임이 끝나면 다시할지 묻는다.
                * 1.이면 끝내기
                * 2.이면 게임 다시시작
        * askForRegame
            * 게임을 다시 할지 확인하는 함수
            * 변수
                * String userInput
                    * 유저한테 받은 입력을 저장한다.
                * Int checkInt 
                    * 숫자로 변환된 문자열을 저장한다.
            * 
            * printText(askingRegame)
                * 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 을 출력한다.
            * userInput = getInput()
            * handleException(askingRegame)
            * if문
                * 1이면  재시작이므로 true 리턴
                * 2이면 종료이므로 false 리턴
        * printText(String text)
            * text를 출력한다.
        * getInput
            * return InputUserNumber()
        * private void handleException(case, input)
            * 종료, 재시작에 대한 입력에 대해 예외 처리하는 함수
            * 매개변수로는 사용자 입력 스트링을 받는다.
                * String userInput
            * 정규 표현식으로 1, 2이외의 것들은 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
* 메인 메소드
    * 기능
        * user 객체를 만든다.
        * game객체를 만든다.
        * gamemarchine 객체를 만든다. 그리고 game객체를 주입한다.
        * 게임을 시작한다.
