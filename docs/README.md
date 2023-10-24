[우아한테크코스] 웹 백엔드 프리코스 1주 차 미션 - 숫자 야구

    *** 주어진 요구 사항 ***
    1. JDK 17 사용, Java 코드 컨벤션 준수

    2. 사용자 입력, 난수 생성 시 주어진 api 활용

    3. 숫자 야구 게임 구현

    4. 3스트라이크 시 사용자 입력에 따라 게입 재시작 또는 종료

    5. 사용자 입력 오류 시 IllegalArgumentException 발생 후 프로그램 종료

***

    *** 구현 상세 ***
    1. 3개의 난수 생성 시 중복 값 제외

    2. isValidInput() : 사용자 입력이 유효한 지 판별하는 함수 
        - 파리미터로 받은 String의 길이가 3인지,
        - 파리미터로 받은 String이 숫자로만 이루어져 있는지, 
        - 파리미터로 받은 String의 숫자에 중복이 없는지
        - 모두 만족 시 true 리턴 
        - 불만족 시 false 리턴, main 에서 IllegalArgumentException을 throw
    
    3. playBaseball() : 정답과 사용자 입력 숫자 비교하는 함수
        - 0s0b ~ 3s0b 에 해당하는 결과 출력 및 정수 리턴

    4. playAgain() : 3스트라이크 시 재시작 여부
        - 1, 2 이외의 입력 시 IllegalArgumentException을 throw