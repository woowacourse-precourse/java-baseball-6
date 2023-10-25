구현할 기능 목록

1. Game Manager
    1. 게임 시작 / 재시작 기능
    2. 정답 설정 기능
    3. 게임 진행 순서에 따라 각 Manager 호출 및 method 실행
2. Input Manager
    1. 사용자의 입력을 받는 기능
    2. 해당 입력이 1에서 9까지 서로 다른 수로 이루어진 세자리 수인지 검증 -> IllegalArgumentException
3. Judgement Manager
    1. 사용자 입력에 대한 정답 판별 기능
    2. 결과 출력 및 게임 종료 조건 확인 기능
4. Game
   1. 숫자 야구 게임에 대한 데이터 저장