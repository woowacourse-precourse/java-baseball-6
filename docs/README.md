# 숫자 야구 게임

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한
  숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

#### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
``` 

#### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

<br></br>

## < 클래스 다이어그램 >

게임의 전체 진행을 맡은 Controller 에서, <br>
게임 기능들을 실제로 수행하는 GameService 를 호출하고, 호출된 GameService 는 <br>
각 메서드에서 필요한 ComputerService, PlayerService, MessageService 를 호출하여 기능을 수행한다.

![img.png](img.png)

<br></br>

## < 기능 목록 정의 >

### 💻 Domain 정의

------------------

### Player

#### : 플레이어의 숫자에 대한 클래스

| 이름        | 설명                      | 구분 (타입)    | I / O                                    |
|:----------|:------------------------|:-----------|:-----------------------------------------|
| firstNum  | 플레이어의 첫 번째 숫자           | 필드 (int)   |                                          |
| secondNum | 플레이어의 두 번째 숫자           | 필드 (int)   |                                          |
| thirdNum  | 플레이어의 세 번째 숫자           | 필드 (int)   |                                          |
| Player    | AllArgumentsConstructor | 생성자        | firstNum, secondNum, thirdNum / －        |
| Getter    | 플레이어의 각 숫자를 가져온다.       | Getter 메서드 |                                          |
| Setter    | 플레이어의 각 숫자를 설정한다.       | Setter 메서드 | firstNum / －, secondNum/ －, thirdNum / － |
| setAllNum | 플레이어의 모든 숫자를 설정한다.      | 메서드        | firstNum, secondNum, thirdNum / －        |

### Computer

#### : 컴퓨터의 숫자에 대한 클래스

| 이름        | 설명                      | 구분 (타입)    | I / O                                    |
|:----------|:------------------------|:-----------|:-----------------------------------------|
| firstNum  | 컴퓨터의 첫 번째 숫자            | 필드 (int)   |                                          |
| secondNum | 컴퓨터의 두 번째 숫자            | 필드 (int)   |                                          |
| thirdNum  | 컴퓨터의 세 번째 숫자            | 필드 (int)   |                                          |
| Computer  | AllArgumentsConstructor | 생성자        | firstNum, secondNum, thirdNum / －        |
| Getter    | 컴퓨터의 각 숫자를 가져온다.        | Getter 메서드 |                                          |
| Setter    | 컴퓨터의 각 숫자를 설정한다.        | Setter 메서드 | firstNum / －, secondNum/ －, thirdNum / － |
| setAllNum | 컴퓨터의 모든 숫자를 설정한다.       | 메서드        | firstNum, secondNum, thirdNum / －        |

<br></br>

### 💻 Service 정의

------------------

### PlayerService

#### : 플레이어가 주체가 되는 서비스

| 이름                      | 설명                                                   | 구분 (타입) | I / O                        |
|:------------------------|:-----------------------------------------------------|:--------|:-----------------------------|
| inputPlayerNumber       | 플레이어에게 숫자 3개를 입력 받아, 유효성 검사 후 리턴한다.                  | 메서드     | － / Player                   |
| getPlayerNumber         | 플레이어의 숫자 리스트를 리턴한다.                                  | 메서드     | Player / ArrayList\<Integer> |
| checkInputPlayerNumber  | 플레이어가 입력한 숫자가 유효한지 확인하는 메서드를 호출한다.                   | 메서드     | String / －                   |
| checkCharacterExistence | 문자를 포함하지 않는지 확인한다. (throws IllegalArgumentException) | 메서드     | String /                     |
| checkLength             | 숫자의 개수를 확인한다. (throws IllegalArgumentException)      | 메서드     | String / －                   |
| checkDuplicateNumber    | 중복된 숫자가 없는지 확인한다. (throws IllegalArgumentException)  | 메서드     | String / －                   |
| checkPresenceOfZero     | 0을 포함하지 않는지 확인한다. (throws IllegalArgumentException)  | 메서드     | String / －                   |

### ComputerService

#### : 컴퓨터가 주체가 되는 서비스

| 이름                | 설명                  | 구분 (타입) | I / O                          |
|:------------------|:--------------------|:--------|:-------------------------------|
| setComputerNumber | 컴퓨터의 숫자를 랜덤으로 설정한다. | 메서드     | － / Computer                   |
| getComputerNumber | 컴퓨터의 숫자를 리스트로 반환한다. | 메서드     | Computer / ArrayList\<Integer> |

### MessageService

#### : 메세지를 보여주는 서비스

| 이름             | 설명                            | 구분 (타입) | I / O                   |
|:---------------|:------------------------------|:--------|:------------------------|
| startMessage   | 게임을 시작할 때 메세지를 출력한다.          | 메서드     |                         |
| inputMessage   | 플레이어의 숫자를 입력받는 메세지를 출력한다.     | 메서드     |                         |
| endMessage     | 게임을 종료하는 메시지를 출력한다.           | 메서드     |                         |
| restartMessage | 게임 재시작 여부를 묻는 메세지를 출력한다.      | 메서드     |                         |
| resultMessage  | 게임 결과를 받아서, 결과 메세지를 만들어 출력한다. | 메서드     | ArrayList\<Integer> / － |

### GameService

#### : 서비스를 통합하는 서비스이자 게임을 수행하는 서비스

| 이름                 | 설명                                                  | 구분 (타입)              | I / O                                                            |
|:-------------------|:----------------------------------------------------|:---------------------|:-----------------------------------------------------------------|
| computerService    | ComputerService 객체                                  | 필드 (ComputerService) |                                                                  |
| playerService      | PlayerService 객체                                    | 필드 (PlayerService)   |                                                                  |
| messageService     | MessageService 객체                                   | 필드 (MessageService)  |                                                                  |
| initComputer       | 게임 시작 메세지를 출력하고 setComputer() 을 호출한다.               | 메서드                  | － / Computer                                                     |
| setComputer        | 컴퓨터의 숫자를 설정한다.                                      | 메서드                  | － / Computer                                                     |
| initPlayer         | 플레이어의 숫자를 설정한다.                                     | 메서드                  | － / Player                                                       |
| getResult          | checkBallCount() 에 맞는 인자를 계산해서 넣어주어 호출하고 결과를 리턴한다.  | 메서드                  | (Computer, Player) / ArrayList\<Integer>                         |
| checkBallCount     | 컴퓨터와 플레이어의 숫자를 비교해 게임 결과를 리스트로 리턴한다.                | 메서드                  | (ArrayList\<Integer>, ArrayList\<Integer>) / ArrayList\<Integer> |
| showResult         | 게임 결과 메세지를 출력한다.                                    | 메서드                  | ArrayList\<Integer> / －                                          |
| confirmGameRestart | 정답을 맞췄을 때 메세지를 출력하고, inputRestartAnswer() 를 호출한다.   | 메서드                  | － / Boolean                                                      |
| inputRestartAnswer | 게임 재시작 여부를 입력받는다. (throws IllegalArgumentException) | 메서드                  | － / Boolean                                                      |

<br></br>

### 💻 Controller 정의

------------------

### Controller

#### : 숫자 야구 게임 전체 로직 클래스

| 이름          | 설명                         | 구분 (타입)          | I / O |
|:------------|:---------------------------|:-----------------|:------|
| gameService | 게임을 실제 수행하는 GameService 객체 | 필드 (GameService) |       |
| playGame    | 게임 메인 로직                   | 메서드              |       |

<br></br>
