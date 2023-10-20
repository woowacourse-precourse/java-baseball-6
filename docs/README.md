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
    
    class Player{
        <<interface>>
        #List~int~[3] numbers
    }
    Player <|-- User
    Player <|-- Computer
    RandomNumber <|-- Computer
    
    class User {
        +create(List~int~[3] numbers, ValidNumberChecker validNumberChecker) User
    }
    class Computer{
        -createRandomNumber() void
        +create(ValidNumberChecker validNumberChecker) Computer
    }

    class RandomNumber {
        <<interface>>
        #createRandomNumber() List~int~[3]
    }

    class Referee {
        - Player user
        - Player Computer
        +judgeBaseballGame() bool isUserVictory
        -userVictory() void
        -computerVictory() void
    }

    ValidNumberChecker <|-- DefaultValidNumberChecker
    class ValidNumberChecker {
        <<interface>>
        #isValid(List~int~ numbers) bool
    }

    class DefaultValidNumberChecker {
        - VALID_SIZE
        #isValid(List~int~ numbers) bool
    }
```

<br>

## 기능 목록

### 플레이어 `Player`
#### 플레이어[컴퓨터] `Computer`
- [ ] 1~9 사이의 서로 다른 랜덤한 숫자 3개를 가진 새로운 컴퓨터 객체 생성

#### 플레이어[사용자] `User`
- [ ] 1~9 사이의 서로 다른 수 3개를 입력 받아서 새로운 사용자 객체 생성

<br>

### 심판 `Referee`
- [ ] 플레이어가 컴퓨터의 숫자를 맞췄는지 판단, 아무것도 포함되지 않다면 낫싱
- [ ] 두 숫자가 같다면 스트라이크 +1, 다르다면 볼 + 1

<br>

### 시스템 `GameSystem`
#### 게임시작 담당 `BaseballGameStarter`
- [ ] 숫자 야구를 시작

#### 게임종료 판단 `BaseballGameTerminator`
- [ ] 숫자 야구가 끝났는지 판단

#### 게임의 흐름을 관리 `GmaeController`
- [ ] 전체적인 게임의 흐름을 담당

<br>

### 부가 기능
#### 랜덤한 숫자 생성 `RandomNumber`
- [ ] 1~9 사이의 서로 다른 수 3개를 생성

#### 올바른 숫자인지 판단 `ValidNumberChecker`
- [ ] 숫자의 길이가 올바른지 확인

#### 입력 담당 `Writer`
- [ ] 입력받은 값을 전달

#### 출력 담당 `Printer`
- [ ] 입력받은 값을 출력

<br>

### 목표
- [ ] 객체지향적인 개발
- [ ] SOLID 적용
- [ ] MVC 패턴 적용
