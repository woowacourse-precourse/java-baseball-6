# 기능목록

1. 컴퓨터 값 (랜덤) 생성하는 함수
2. 유저 값 입력하는 함수
    1) 입력 유효성 체크
        * 숫자
        * 1~9, 서로 다른 세 자리
        * 잘못 입력 시: IllegalArgumentException 발생 후 애플리케이션 종료
    2) 입력받은 값 숫자 리스트로 변경
3. 컴퓨터 - 유저 값 비교하는 함수
4. 비교 결과 출력하는 함수
5. 정답 여부에 따른 처리입력
    * 정답일 경우 : 반복 종료, 6번으로 이동
    * 정답이 아닐 경우 : 2번부터 반복
6. 재시작, 종료 입력받기
    1. 입력 유효성 체크
        * 1 or 2
        * 잘못 입력: IllegalArgumentException 발생 후 애플리케이션 종료
    2. 재시작 or 종료
        * 1 : 1번부터 반복
        * 2 : 애플리케이션 종료

✅ 랜덤 값 생성 : camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()

✅ 사용자 입력 : camp.nextstep.edu.missionutils.Console.readLine()