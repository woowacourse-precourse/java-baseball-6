# 숫자 야구 기능 목록 🚀
## Computer
* 랜덤 숫자를 생성하고 return
* randomNumberGenerate() : 랜덤 숫자 생성
* getRandomNumber() : 생성된 랜덤 숫자를 return
 
## Player 
* playerNumber를 입력 받고 Strike와 Ball의 값을 가지고 있는 int[] return
* inputPlayerNumber() : 플레이어의 수을 입력을 받아 저장 
* checkStrikeAndBall(List\<Integer\> computerNumber) : Computer가 생성한 숫자의 값을 받아서 Strike와 Ball 계산

## BaseBallGame 
* player 와 computer 의 정보를 받아서 게임을 실행 
* gameStart() : 게임을 진행하는 함수
* isGameComplete() : 3 스트라이크에 대한 결과를 출력하고 askForRestart()를 리턴 
* askForRestart() : 숫자 1 또는 2를 입력받아 게임 재시작을 판단한다.

## Validator 
* 검증을 담당
* validateInputLength(String input) : input 길이가 3이 아니면 Exception
* validateInputRegex(String input) : input이 1~9 사이 길이가 아니라면 Exception
* validateInputRepeat(String input) : input에 같은 숫자가 있으면 Exception

## ConsolPrinter 
* console의 출력을 담당하는 클래스
