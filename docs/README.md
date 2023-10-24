# 요구사항 분석

---

- 게임의 참여자는 Player이다.
- 상대방은 Computer이다.
- Computer는 1~9까지 서로 다른 숫자 3개를 선택한다.
- Player는 자신이 생각한 정답으로 서로 다른 숫자 3개를 입력한다.
- Computer는 해당 입력을 바탕으로 결과를 알려준다.
    - Computer의 숫자와 같은 값, 같은 자리에 있다 → 스트라이크
    - Computer의 숫자와 같은 값이지만, 다른 위치에 있다 → 볼
- 3스트라이크가 나오면 정답을 맞추게 되고 게임을 종료한다.
- 게임이 종료된 후에 Player는 게임을 재시작하거나, 완전히 종료할 지 선택할 수 있다.

# 도메인(Domain)

---

### Game Controller

역할: 게임의 진행 여부를 Controller 하는 클래스, 게임의 시작과 재시작을 관리한다.

- [ ]  `initNumberBaseBallGame()` : 게임 시작 요청을 받으면 안내 메시지를 출력하고 게임 시작을 한다.
- [ ]  `initGame()` : 게임 시작 전 게임에 참여 Player와 Computer를 생성하고 두 참가자로 게임을 시작한다.
- [ ]  `restartGame()` : Player의 요청을 전달 받아 재시작 여부를 판단한다. 요청 값이 1이면 재시작한다.
    - 재시작 → `initGame()`;
        - game → player.askRestart → Controller.restart
    - 종료 → 아무것도 안함.

### NumberBaseballGame

역할: 메인 게임, 참가자인 Player와 Computer를 상대로 숫자 야구 게임을 진행함. (이하 숫자 야구 게임은 ‘게임’이라 칭함.)

- [ ]  `gameStart()` : 게임이 시작되면 game에 필요한 세팅을 하고 게임을 진행한다.
- [ ]  `gameSetting()` : 게임 세팅 단계에는 참가한 Computer의 정답을 setting한다.
- [ ]  게임 진행 `game()`
    - Player에게 Player가 생각하는 Input을 입력받는다.
    - 전달 받은 Input을 Computer에게 전달해 결과를 물어본다.
    - 전달 받은 결과를 출력한다.
    - 결과가 정답이면 게임 재시작 여부를 Player에게 물어본다.
    - 결과가 정답이 아니면, 게임을 계속 진행하기 위해 Player에게 결과를 알려주고 다음 입력을 받는다.

- [ ]  `isFinish()`  : 결과를 확인한다. 결과가 ‘3스트라이크’면 true를 그 외면 false를 반환한다.
- [ ]  `handleGame()` : 결과를 바탕으로 게임 재시작 또는 계속 진행을 결정한다.
- [ ]  `printResult()` : Computer로 부터 전달받은 결과를 출력한다.

### Player

역할: 게임의 참가자

- [ ]  `getPlayerInput()` : 자신이 정답으로 생각하는 서로 다른 3개의 숫자를 반환한다.
- [ ]  `setPlayerInput()` : 자신이 정답으로 생각하는 서로 다른 3개의 숫자를 결정한다.
- [ ]  `getRestartMessage()` : 자신의 재시작 의사를 반환한다.
- [ ]  `setRestartMessage()` : 자신의 재시작 의사를 결정한다.

### Computer

역할: Player와 게임을 하는 상대방.

- [ ]  `setAnswer()` : 게임의 정답 1~9사이의 서로 다른 3개의 숫자인 answer를 결정한다.
- [ ]  `getResult()` : Player의 Input을 보고 결과를 판단 후 결과를 String으로 반환해준다.
- [ ]  `countBall()` : player의 Input에서 ball이 몇 개인지 판단 후 반환한다.
- [ ]  `coutnStrike()` : player의 Input에서 strike의 개수를 판단 후 반환한다.

# 프로그램에 진행에 필요한 클래스(Utils)

---

### Input

역할: 프로그램의 입력 처리를 하는 클래스

- [ ]  `askRestart()` : 사용자에게 재시작 여부를 물어본다.
- [ ]  `askPlayerInput()` : 사용자에게 Input을 List<Integer> 형태로 반환한다.
- [ ]  `getInputList()` : String으로 받은 사용자의 Input을 검증 후 List의 형태로 반환한다.
- [ ]  `stringToInteger()` : String으로 온 사용자의 입력을 List<Integer>의 형태로 변환한다.

### OutputMessage

역할: 프로그램의 출력과 출력문을 관리하는 클래스

- [ ]  `introMessage()` : 게임을 시작하는 인트로 메세지 ‘숫자 야구 게임을 시작합니다!’를 출력한다.
- [ ]  `askRestartMessage()` : 재시작 여부를 물어보는 '게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.’ 를 출력한다.
- [ ]  `askNumberMessage()` : 입력할 숫자를 물어보는 ‘숫자를 입력해주세요 : ‘를 출력한다.
- [ ]  `successMessage()` : 성공 여부를 알려주는 ‘3개의 숫자를 모두 맞히셨습니다! 게임 종료’를 출력한다.
- [ ]  `printResult()` : 결과 값 result를 전달받고 이를 출력한다.
- [ ]  `getResultMessage()` : ball과 strike의 개수를 전달 받고 이에 적합한 결과를 출력한다.
    - ball과 strike가 없다 → ‘낫싱’
    - ball만 있다 → ‘n볼’
    - strike만 있다 → ‘n스트라이크’
    - 둘 다 있다 → ‘n볼 m스트라이크’
- [ ]  `getBallMessage()` : ball 개수를 받아 ball의 개수를 String으로 반환한다. 존재하지 않으면 비어있는 String을 반환한다.
- [ ]  `getStrikeMessage()` : strike 개수를 받고 strike의 개수를 String으로 반환한다. 존재하지 않으면 비어있는 String을 반환한다.

# 예외 처리(Validate)

---

### checkInput

역할: 사용자의 Input이 게임 진행에 적합한지 확인한다. 적합하지 않으면 `llegalArgumentException()` 을 발생시킨다.

- [ ]  `validateUserInput()` : player의 Input이 아래의 요구사항들을 만족하는지 확인한다.
    - [ ]  `checkLength()` : 입력 값의 길이가 3인지 확인한다.
    - [ ]  `checkInteger()` : 입력 값이 정수 형태로 변환이 가능한지 확인한다.
    - [ ]  `checkHasZero()` : 입력 값에 0이 존재하는지 확인한다.
    - [ ]  `checkDuplicate()` : 입력 값에 중복된 값이 있는지 확인해야한다.