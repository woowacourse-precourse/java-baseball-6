# 0. 사용할 변수 및 메소드
  - answer : 야구게임의 정답
  - userInput : 사용자가 입력한 값
  - newGameCommand : 사용자가 3스트라이크 성공 시 게임을 계속할지 여부를 입력
  - strike : 스트라이크를 계산한 값
  - ball : 볼을 계산한 값
  - usedAnsNumChecker : 볼카운트 계산 시 정답에서 어떤 값들이 이미 계산되었는지 저장
  - usedInputNumChecker : 볼카운트 계산 시 사용자 입력에서 어떤 값들이 이미 계산되었는지 저장
  - NEWGAME : 새로운 게임 시작을 의미하는 상수
  - EXITGAME : 게임 종료를 의미하는 상수
  - initGame() : 게임 플레이에 필요한 변수 및 배열 값을 초기화하거나 생성하는 메소드
  - playGame() : 게임을 플레이하는 메소드
  - getInput() : 사용자 입력을 받는 메소드
  - countStrikes() : 스트라이크 값을 계산하는 메소드
  - countBalls() : 볼 값을 계산하는 메소드
  - printStart() : 게임 시작 메시지를 출력하는 메소드
  - printResult() : 결과를 출력하는 메소드
  - (구현 뒤 추가) initChecker() : usedAnsNumChecker와 usedInputNumChecker 배열의 값들을 false로 초기화하는 메소드
  - (구현 뒤 추가) initBallcount() : strike와 ball 변수를 0으로 초기화하는 메소드
  - (구현 뒤 추가) printSuccess() : 성공 시 성공 메시지를 출력하는 메소드


# 1. 클래스의 생성자 및 변수 초기화
  - initGame 메소드에서 answer, usedAnsNumChecker, usedInputChecker를 초기화한다. 이 때, answer는 야구게임의 정답, usedAnsNumChecker와 usedInputNumChecker는 스트라이크 및 볼 계산시 쓰이는 배열이다. answer는 pickNumberInRange 함수를 이용하여 난수를 생성한다.
  - 클래스의 생성자는 initGame 메소드를 호출하여 게임 시작시 필요한 멤버변수를 초기화한다.
  - (구현 뒤 추가) initBallcount 메소드는 볼카운트를 계산한 결과를 저장하는 strike, ball 변수를 0으로 초기화한다.
  - (구현 뒤 추가) initChecker 메소드는 usedAnsNumChecker, usedInputChecker의 값들을 모두 false로 초기화한다.


# 2. 입출력
  - printStart 메소드는 야구게임 시작 문구를 출력한다.
  - getInput 메소드는 사용자 입력인 userInput을 입력받는다.
  - printResult 메소드는 사용자 입력과 정답을 비교하여 볼카운트를 계산한 뒤 결과를 출력한다.
  - (구현 뒤 추가) printSuccess 메소드는 사용자가 정답을 맞췄을 때 성공 결과를 출력한다.


# 3. 게임 플레이
  - 게임 플레이 시 playGame 메소드를 호출한다.
  - countStrikes 메소드는 playGame 메소드 내에서 스트라이크를 계산하는 기능을 수행한다.
  - countBalls 메소드는 playGame 메소드 내에서 볼을 계산하는 기능을 수행한다.
  - (구현 뒤 수정) playGame 메소드는 printStart 메소드를 호출하여 게임 시작 메시지를 출력한 뒤 반복문에서 initBallcount 메소드를 호출하여 볼카운트를 초기화하고, getInput 메소드를 호출하여 사용자의 입력을 받는다. 만약 유저가 3스트라이크에 성공하면 성공 메시지를 출력하고 게임을 계속할지 여부를 입력받는다. 실패할 경우 initChecker 메소드를 호출하여 usedAnsNumChecker 및 usedInputNumChecker 배열을 초기화하고 countStrikes, countBalls 메소드를 호출하여 볼카운트를 계산한 뒤 printResult 메소드를 호출하여 결과를 출력한다.


# 4. 테스트 후 리팩토링
  - 클래스 하나에 인스턴스 변수가 9개 존재, 클래스가 지나치게 큼
    - 클래스를 더 작은 형태로 분해한다.
    - 기존의 BaseballGame 클래스에서 기존 클래스, 출력 역할을 수행하는 printGameMessage 클래스, 볼카운트를 관리하는 Ballcount 클래스로 분리한다.
    - NEWGAME, EXITGAME 상수를 static으로 선언한다.
    - START, EXIT 상수를 추가한다.
  - 불필요한 깊이의 depth를 가진 메소드가 3개 존재
    - countStrikes, countBalls 메소드 반복문에서 각 depth에 해당하는 계산을 수행하는 메소드를 추가하여 depth를 줄인다.
    - playGame 메소드에서 사용자가 3스트라이크에 성공했을 때의 로직을 관리하는 메소드를 추가한다.
  - else문 2개 존재
    - 사용자가 3스트라이크에 성공했을 경우 exception을 발생시키는 코드의 else를 없앤다.
    - playGame 메소드에서 사용자가 3스트라이크에 실패했을 경우의 명령어들을 감싼 else를 없앤다.