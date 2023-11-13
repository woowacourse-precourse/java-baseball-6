# ⚾ BaseBall Game
## 요구 사항 분석
### 게임 규칙
>같은 수가 같은 자리에 있으면 Strike
><br>
>같은 수가 다른 자리에 있으면 Ball
><br>
>같은 수가 하나도 없으면 Nothing
><br>
>Strike, Ball, Nothing의 힌트를 가지고 Computer의 수를 맞추면 승리
><br>
> 예시)Compuer의 수 : 829일때
><br>
> 123을 제시 : 1스트라이크
> <br>
> 456을 제시 : 낫싱
> <br>
> 189을 제시 : 1볼 1스트라이크

<br>

### 게임 진행 과정
> 게임 플레이어는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과물 출력

<br>

### 게임 종료 조건
> 컴퓨터의 숫자 3개를 모두 맞추면 게임 종료

<br>

### 게임 종료 후 처리 방법
> 게임을 다시 시작하거나 종료



<br>

### 예외 조건
1. 입력값이 길이가 3이 초과가 되는지
2. 입력값이 정수형이 아닌지
3. 입력값이 서로 다른 수가 아니라 중복되는 수인지
4. 사용자가 잘못된 값을 입력할 경우 <b>IllegalArgumentException()</b>을 발생시킨 후 애플리케이션 종료

<br>

## 구현 목록

### Controller
- GameController
    - 시작 기능



### Model
- Game
    - 컴퓨터 정답 생성
    - 결과값 생성
    - 현재 상태 (이겼는지 / 재시작 할건지 / 종료할건지)

- GameResult
    - 컴퓨터 vs 유저 값 판단하여 스트라이크, 볼 개수 판단
    - 결과를 string형으로 변환

### View
- GameView
    - 출력 인터페이스

### Service
- CheckUserNumber
    - 예외 처리 기능 
      - 입력 길이 3 이상인지
      - 입력 값이 정수인지
      - 입력 값이 중복되는지

<br>

## 커밋 방법 [깃 배쉬]
1. git clone --bare [forked한 레포지 주소]
2. cd [forked한 레포지 주소]
3. git push --mirror [새 레포지 주소]
4. cd ..
5. rm -rf [forked한 레포지 주소]

<br>
