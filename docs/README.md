Application.java에서 BaseballGame.play()로 게임 실행

### BaseballGame.play()
1. 시작 메세지 출력
2. while문 - 새 게임
    1. Computer 객체 생성 - 생성 시 3가지 숫자 랜덤 뽑기 후 객체 내부에 List로 저장
    2. while문 - 컴퓨터의 숫자를 맞추기 위한 Player의 숫자 입력 받기
        1. 입력 메세지 출력
        2. 입력받은 String을 숫자 리스트로 변환하여 Player 객체 생성
            - 입력받은 String 검증 필요
        3. Result 객체 생성하여 Computer와 Player 객체 비교
            - Result 객체 생성 시 값을 비교하여 내부에 이번 회차의 결과 저장
        4. Result에 저장된 값으로 힌트 출력
        5. 정답인 경우(3 STRIKE) -> break;(숫자 입력 받기 종료)
    3. 1 입력 시 한 번 더 플레이, 2 입력 시 break;(게임 종료)
        - 입력받은 String 검증 필요

   