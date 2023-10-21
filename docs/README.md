1. computer의 Random Number 생성
    Computer class 생성, 생성자를 통해 랜덤 숫자 결정

2. 사용자의 입력
    int 값이 아니면 IllegalArgumentException 발생

3. IllegalArgumentException 체크
    4자리 이상 숫자를 입력했거나 2자리 이하 숫자를 입력했을 경우에도 IllegalArgumentException 발생

4. 정답 여부 체크(볼, 스크라이크)
    Computer 클래스 내의 함수를 통해 ball과 strike 개수 체크
    strike가 3개일 경우 정답으로 인식
    정답입니다 알림 후 재시작 여부 메세지 출력

5. 정답일 경우, 재시작할지 종료할지 체크
    입력값이 1일 경우 재시작, 2일 경우 종료
    그 외의 값일 경우 오류 발생
    

