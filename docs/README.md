# ⚾️ 숫자 야구 게임

***

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

## 기능 요구사항

***

### 서로 다른 숫자 3개를 랜덤하게 구하는 기능

*[x] `pickNumberInRange`를 활용하여 random number을 저장 - [Computer](#computer)

### 사용자가 게임에 숫자를 입력하는 기능

*[x] player의 시도를 저장하는 `PlayerContoller`생성 - [PlayerAttempt](#PlayerAttempt)
* [x] 시도를 `Player` 객체에 저장 - [Player](#Player)

### 입력받은 숫자를 컴퓨터의 숫자와 비교하는 기능

*[x] `ScoreHandler`로 player와 computer의 값을 불러와 한 자리씩 비교 - [ScoreHandler](#ScoreHandler)
* [x] `isThreeStrikes`함수를 작성하여, 정답 확인 - [BaseballGame](#BaseballGame)

### 잘못된  잘못된 값을 입력할 경우 `IllegalArgumentException`

*[x] `PlayerAttempt`에서 입력 값이 3자리가 아닐 경우 `IllegalArgumentException` 발생 - [PlayerAttempt](#PlayerAttempt)

### 게임의 재시작/종료를 선택하는 기능

*[x] 매직넘버 `STOP`와 입력값이 같을 때(2) 게임을 종료 - [BaseballGame](#BaseballGame)
* [x] 1일 경우 게임 재시작

### 게임 결과 출력

-[x] `ScoreViewer`에서 `ScoreHandler`에서 받은 strike수와 ball수를 바탕으로 결과 출력 - [ScoreViewer](#Scoreviewer)

## 프로젝트 구조

***

### Model

1. `Player`: 게임을 플래이하는 객체
    - 점수를 저장하고 있는 객체
2. `Computer`: 컴퓨터
    - 정답을 가지고 있는 객체

### Domain

1. `BaseballGame`: 게임을 진행
    - 게임의 재시작과 종료를 관리함

### Controller

> 앱의 사용자로부터의 입력에 대한 응답으로 모델 및/또는 뷰를 업데이트하는 로직

1. `ScoreHandler`: `Player`과 `Computer`값을 비교하여 점수를 채점함
2. `SpanPlayers`: `Player`과 `Computer`를 생성함

### Viewer

1. `ScoreViewer`: `ScoreHandler`에서 넘어온 값을 바탕으로 결과 출력