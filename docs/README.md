Class baseball
변수
private List<Integer> checkNumber : 랜덤한 값이 저장 되는 변수
private List<Integer> inputNumber : 입력한 값이 저장 되는 변수

메서드
startBaseball : 중복 되지 않는 3가지 숫자를 checkNumber 저장 후 다음 단계인 setInputNumber 호출
setInputNumber : 유저 입력값 예외 처리(문자, 3자리 숫자가 아닌 경우), inputNumber 저장 checkNumber 호출
checkNumber : checkNumber 와 inputNumber 비교 하여 결과 출력 후 결과에 따라 반복 혹은 종료
endGame : 게임 종료 후 재시작 혹은 종료를 위한 코드 1,2 가 아닌 값들은 예외 처리 