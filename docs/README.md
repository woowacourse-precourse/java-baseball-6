# Week01 : 숫자 야구 게임

## 기능 구현

### 1. 난수 생성기
> - 자연수 (1 ~ 9)
> - 3자리
> - 각 자리는 중복 불가

### 2. 사용자 입력
### IllegalArgumentException
> 1. 중복된 값이 있는 경우
> 2. 자연수가 아닌 경우
> 3. 자리수가 올바르지 않은 경우

### 3. ComputerNum vs UserNum
> - total = strike + ball : 포함 여부
> - strike : 자리 + 숫자 일치

### 4. 심판(Referee)
> total = 0 : 낫싱
> strike = 0  : 볼 출력
> ball = 0 : 스트라이크 출력
> 나머지 : 볼 + 스트라이크 출력

### 5. Replay
> 1 : 다시 시작  
> 2 : 게임 종료