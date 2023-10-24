## 플로우차트
```mermaid
flowchart TD
    A[게임 시작] --> B[컴퓨터 숫자 생성]
    B --> C[사용자 입력]  
    C --> D{컴퓨터와 사용자 입력이 일치?}
    D --> |Yes|E[3스트라이크]
    D --> |NO|F{겹치는 숫자 존재?}
    F --> |YES|G{현재 자릿수 일치?}
    F --> |NO|L[낫싱]
    G --> |YES|H[스트라이크+1]
    G --> |NO|I[볼+1]
    H & I --> J{3번 반복함?}
    J --> |YES|K[출력]
    J --> |NO|G
    E & L --> K
```

<br>

## 클래스 다이어그램
```mermaid
    classDiagram

    class Player {
        <<abstract>>
        #List~int~[3] numbers
        +getNumberPosition(int) int
    }
    
    class User {
        +create(List~int~[3]) User
    }

    class Computer {
        -createRandomNumber() void
        +create(List~int~[3]) Computer
    }

    Player <|-- User
    Player <|-- Computer

    class Referee {
        -Player user
        -Player Computer
        -Referee(User user, Computer computer)
        +judgeBaseballGame() GameScoreboard
    }

    class GameScoreboard {
        -int strike
        -int ball
        ~incrementStrike() GameScoreboard
        ~incrementBall() GameScoreboard
        +isThreeStrike() bool
        +getStrike() int
        +getBall() int
    }

    class NumberBaseballController {
        -GameController gameController
        -InputView inputView
        -OutputView outputView
        +NumberBaseballController(GameController, InputView, OutputView)
        +run() void
        -playGame(Computer) void
        -isUserWantToQuit() bool
        -getUserBaseballNumber() List~int~
        -setupGame() Computer
    }

    class GameController {
        -GameStarter gameStarter
        -GameTerminator gameTerminator
        +run(User, Computer) GameScoreboard
        +isRunning(GameScoreboard) bool
    }

    class GameStarter {
        +start(Computer, User) GameScoreboard
    }

    class GameTerminator {
        +isGameStillRunning(GameScoreboard) bool
    }

    class InputView {
        -Convertor Convertor
        -Validator Validator
        -InputView(Convertor, Validator)
        +readInput() String
        +readInputNumbers() List~int~
    }

    class OutputView {
        -Convertor Convertor
        -Validator Validator
        -OutputView(Convertor, Validator)
        -write() void
        +printGameStartConsole() void
        +printMissionClearConsole() void
        +printHintConsole() void
        +inputPrompt() void
    }

    class Convertor {
        +inputToBaseballNumber(String) List~int~
        +ballCountToHint(int, int) String
    }

    class Validator {
        +validateBaseballNumber(String) void
        +totalCountsNotExceedingLimit(int, int) void
    }

    GameController -- GameStarter
    GameController -- GameTerminator
    
    Referee -- User
    Referee -- Computer

    NumberBaseballController -- GameController
    NumberBaseballController -- InputView
    NumberBaseballController -- OutputView
        
    InputView -- Convertor
    InputView -- Validator 
    OutputView -- Convertor
    OutputView -- Validator 
```

<br>

## 기능 목록

### 플레이어 `Player`
- [x] 지정된 위치의 숫자를 가져오기

#### 플레이어[컴퓨터] `Computer`
- [x] 주어진 숫자 리스트로 컴퓨터 객체를 생성
- [x] 해당 숫자가 컴퓨터의 숫자 리스트에 포함되어 있는지 확인

#### 플레이어[사용자] `User`
- [x] 주어진 숫자 리스트로 사용자 객체를 생성

<br>

### 판정
#### 게임 점수판 `GameScoreboard`
- [x] 스트라이크와 볼 수 증가 
- [x] 3스트라이크 확인
- [x] 스트라이크와 볼의 현재 값 조회

#### 심판 `Referee`
- [x] 사용자와 컴퓨터의 숫자를 바탕으로 게임 결과 판단
- [x] 스트라이크와 볼 판정


<br>

### 시스템
#### 게임 컨트롤러 `GameController`
- [x] 게임 시작 종료 컨트롤
- [x] 게임 진행 중 여부 판단

#### 게임 시작 담당 `GameStarter`
- [x] 숫자 야구 게임 시작하여 결과 반환

#### 게임 종료 판단 `GameTerminator`
- [x] 게임 종료 여부 판단

<br>

### 입출력
#### 입력 담당 `InputView`
- [x] 사용자 메시지 입력

#### 출력 담당 `OutputView`
- [x] 시작,종료 등 메시지 출력

<br>

### 데이터
#### 데이터 검증 `Validator`
- [x] 숫자 야구 번호 검증
- [x] 스트라이크, 볼 합계 검증

#### 데이터 변환 `Convertor`
- [x] 문자열 입력을 숫자 야구 번호로 변환
- [x] 스트라이크, 볼 카운트를 힌트 메시지로 변환


<br>

### 유틸리티
#### 랜덤한 숫자 생성 `BaseballNumberUtils`
- [x] 1~9 사이의 서로 다른 수 3개를 생성

<br>

### 목표
- [x] 객체지향적인 개발
- [x] SOLID 최대한 지키기
- [x] MVC 패턴 적용

