최대한 기능별로 class를 나누도록 한다.
1. 랜덤 값을 생성해 주는 Answer class만들기
2. 입력값을 받는 Input class만들기
3. 랜덤값과 입력값을 비교하는 Match class만들기
4. 결과값으로 볼과 스트라이크를 출력해주는 Result class만들기
5. 다시 시작할지 판별하는 Re class만들기


contains함수를 쓰기 위해 입력값을 List로 받도록 함 (랜덤값은 List로 고정되있기 때문)
do-while을 사용하여 반복하도록 처리함

예외 처리 하는 부분을 빼먹어서 Input class에 예외 처리 기능 추가
(예외 처리시 조건을 input.lenth == ans.lenth로 하려 했으나 기존 조건에 3자리 숫자이므로 그냥 3을 넣음)