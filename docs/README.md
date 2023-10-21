## 기능 명세서

### Computer
숫자 야구 게임에서 문제를 출제하는 `Computer` 클래스

#### 메서드
- `generateRandomNumber()`
  
    랜덤하게 1~9까지 서로 다른 수로 이뤄진 크기 3의 `int` 타입 배열을 생성하는 메서드


- `getBallCount()`

    유저가 입력한 세 자리수의 볼 개수를 판별하는 메서드

    
- `getStrikeCount()`

    유저가 입력한 세 자리수의 스트라이크 개수를 판별하는 메서드
    
---

### Game

#### 필드
- `computer`

#### 메서드
- `printGameStart`

    게임 시작 안내 문구 출력 메서드


- `getNumberInput`

    플레이어 수 입력 처리 메서드

    
- `printGameEnd`

    게임 끝 안내 문구 출력 메서드


- `getGameContinueInput`

    게임 지속 입력 처리 메서드


- `printResult`

    결과 출력 메서드