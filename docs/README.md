## 구현 기능

### Input 객체
- inputString()
    - 메시지를 받아 출력 후 콘솔에서 입력 값을 받아오는 메소드


### InputValidator 객체
- validateCheckRestartGameInput
    - 게임 재시작 여부 확인에서 Player에게 받은 입력값이 유효한 지 검사하는 함수
    - 유효하지 않을 시 IllegalArgumentException 호출


- validatePlayerInput
    - 숫자 야구 게임 내에서 Player에게 받은 입력값이 유효한 지 검사하는 함수
    - 유효하지 않을 시 IllegalArgumentException 호출


### ComputerNumber 객체
- setNumber
    - Player가 맞출 Number를 지정하는 함수


- getNumber
    - Player가 맞출 Number를 반환하는 함수


### PlayerNumber 객체
- setNumber
    - Player에게 입력 받아 저장하는 함수


- getNumber
    - Player에게 입력 받은 값을 반환하는 함수


### BaseballGame 객체
- run
    - 게임을 처음 실행할 때 쓰는 함수


- play
    - 숫자 게임을 시작하는 함수

### GameUtil 객체
- showHint
    - ball 카운트 및 strike 카운트를 보여주는 함수


- computeCount
    - ball 카운트 및 strike 카운트를 하는 함수


- checkGameOver
    - 게임오버가 되었는지 확인해주는 함수

## 진행 사항
- [X] Input 객체
- [X] InputValidator 객체
- [X] ComputerNumber 객체
- [X] PlayerNumber 객체
- [X] BaseballGame 객체
- [X] GameUtil 객체


## Refactor 목록
- Number 객체 상속
  - ComputerNumber 및 PlayerNumber가 Number 객체 상속받도록 변경