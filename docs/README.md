# 📌 숫자 야구게임 기능 목록

## Logic Controller
### ✔️ BaseballController

* runGame()
  * 게임 시작
  * 해당 게임 로직은 GameController에서 실행
  * state(boolean) 값으로 현재 게임을 끝낼 것인지 결정한다.
* isEndGame()
  * state 값 관리를 위해 실행한다.
  * 유저가 "1" 또는 "2"를 입력했을 때 값에 따라 게임을 진행할지 종료할지 결정
  * 이때 다른 값을 입력하면 예외처리를 진행한다.


### ✔️ GameController

* matchNumber()
  * 컴퓨터 숫자 랜덤으로 3숫자 List로 가져오기
  * 숫자를 맞추기 위해 numberExist 배열을 통해 현재 인덱스별로 자리숫자를 저장해둔다.
  * 입력을 받고, 유효한 숫자인지 검증을 받은 후 스트라이크, 볼 여부를 확인한다.
  * 해당 함수에서는 3개의 숫자를 모두 맞췄을 경우 끝이 난다.

* checkNumberResult()
  * strike, ball 개수가 몇개인지 알 수 있는 함수를 호출한다.
  * 그리고 결과를 print할 수 있는 함수를 호출한다.

* printResult()
  * strikeNumber, ballNumber 에 따라 출력방식을 다르게 제공한다.
  * 0개인 경우에는 출력하지 않으며, 둘다 0이면 '낫싱'을 출력한다.

### ✔️ checkNumberController

* checkStrike()
  * strike 개수를 알 수 있도록 한다.
  * numberExist 배열을 통해, 현재 값과 똑같고 같은 자리인 것들에 대해서 개수를 +1하여 관리한다.
  * 값은 MatchNumberModel에서 set을 통해 관리한다.
* checkBall()
  * 같은수, 같은자리는 아니고 해당 수가 존재하는 경우 number+1하여 관리한다.

* isSamePosition()
  * checkStrike, checkBall에서 같은 위치에 같은 값인지를 확인할 수 있는 함수이다.
* isExistNumber()
  * checkStrike, checkBall에서 숫자 자체가 존재하는 경우를 확인하는 함수이다.

* getStrikeNumber()
  * 현재 model에 저장된 strike 개수를 return 해준다.
* getBallNumber()
  * 현재 model에 저장된 ball 개수를 return 해준다.

### ✔️ ExceptionController

* validateInput() : 현재 입력값을 검증해준다.
  * validateSizeOfNumberLimit()
    * 입력한 값이 3자리가 아닌 경우에 대해서 검증한다.
  * validateIsNumber()
    * 해당 값이 숫자가 아닌 문자인지, 그리고 1~9 범위를 벗어난 값이 입력되었는지 검증한다.
  * validateIsDifferentNumber() 
    * 서로 다른 3개의 수가 아닌 다른 수를 입력했는지에 대해 검증한다.
  * 해당 로직 모두 잘못된 입력값이 들어간 경우, `IllegalArgumentException` 예외를 날려준다.

* validateInputOneOrTwo()
  * 게임 다시 시작 여부에 대한 입력에서 "1" or "2"가 아닌 다른 값을 입력한 경우를 검증하여 다른 값이 들어온 경우 예외를 날려준다.

## Data Model

### ✔️ MatchNumberModel

* 컴퓨터 숫자와 사용자 입력을 통해 strike 개수와 ball 개수를 저장한다.

* MatchNumberModel()
  * 기본 생성자를 통해 처음 값을 0으로 세팅한다.
* getter
  * 현재 strike, ball 개수를 가져온다.
* setter
  * 구한 값을 strike, ball 값으로 세팅한다.

## Util

### ✔️ ConstantUtil

* 출력해야할 값이나, 관리할 상수에 대해 static 변수로 관리한다.

### ✔️ FunctionUtil

* 기능 함수에 대해 static 함수로 관리한다.

* generateRandomList()
  * 컴퓨터측의 랜덤한 3자리 숫자를 생성한다.
  * 숫자 생성시 List<Integer>에 저장하여 반환한다.

* stringToInt()
  * 사용자의 입력을 받을 시에 readLine()으로 받기 때문에 string -> List<Integer>로 만들어준다.

* isNumberExist()
  * strike, ball 개수를 알기 위한 배열이다.
  * 현재 입력받은 랜덤 숫자에 대해 숫자의 index 값을 저장한다.
  * 랜덤 값을 배열의 인덱스, 배열 안에 값은 position으로 저장한다.
