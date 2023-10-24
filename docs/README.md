# 프리코스 1주차 미션 - 숫자 야구 게임

## 구현 기능 목록

1. 게임 시작 시 난수 생성해주는 메소드 `generateRandomNumber`작성
     * 랜덤 값이 서로 다른 3자리의 수 생성
       
2. 유저에게 입력값 받기
     * 유저의 입력값이 올바른지 확인하는 메소드 `checkUserInput` 작성
         * 서로 다른 3자리의 수가 아닌 값을 입력했을시 `IllegalArgumentException` 발생하도록 작성
     * 유저의 입력값을 자리수마다 분리해 Integer타입의 List로 변경해주는 `userNumToList` 작성
       
3. 생성한 randomNum과 유저의 입력값을 비교해 결과를 출력해주는 메소드 `getGameResult`  작성
     * 볼, 스트라이크의 개수를 구하기
     * 볼, 스트라이크의 갯수 혹은 낫싱을 출력해주는 `printBallAndStrike` 작성
     * 3 스트라이크일시 true를, 이외의 경우에는 false를 리턴
       
4. 게임 반복 진행을 고려해 게임 플레이 메소드 play 작성
     * 게임 시작시 `generateRandomNumber` 메소드로 난수를 생성
     * 유저가 정답을 입력할 때까지 반복해서 입력값을 받아오고 올바른 값인지 판별
     * `getGameResult` 리턴값으로 유저의 승패를 판별
     * 유저가 이기면 게임종료 후 유저에게 입력값을 받아오기
     * 유저의 입력값이 1일 경우 반복해서 플레이, 2일 경우 게임 종료, 이외의 값일 경우 `IllegalArgumentException` 발생
       
