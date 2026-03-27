package model;

public class Locker {

    //변수: 락커번호, 사용가능여부, 사물함주인이름
   private int lockerNumber;
   private boolean isOccupied;
   private Member assignedMember;

    public Locker(int lockerNumber){
        this.lockerNumber=lockerNumber;
        this.isOccupied=false; //처음에는 항상 비어있음
        this.assignedMember=null; //처음에는 배정된 회원 없음
    }

    //라커 배정 매서드 ( 맴버 이름을 매개변수로 받기)
    public void assign(Member member) {
        if (isOccupied) {
            System.out.println("이미 사용중인 락커입니다.");
        } else {
            assignedMember=member; //회원 객체 저장
            isOccupied = true; // 사용 중으로 변경
            System.out.println(lockerNumber + "번 락커가 " + assignedMember.getName() + "님께 배정되었습니다.");
        }
    }
    // isOccupied가 미이 true이면 배정을 막기 때문에 중복 배정 방지됨

    //라커 반납 매서드
    public void release(){
        //배정된 회원 이름을 지우고 null값으로 바꾸기
       // isOccupied를 false로
        if(isOccupied==false){
            System.out.println(lockerNumber + "번 락커는 사용가능합니다.");
        }else{
            assignedMember=null; //락커에 있는 회원 정보 지우기
            isOccupied=false; // 락커를 빈 상태로 변경
            System.out.println(lockerNumber + "번 락커가 반납되었습니다.");
        }
    }

    // 락커 1개 그리기
    // 그리드 한 칸 상태 반환 (GymManager에서 전체 그리드 출력 시 사용)
    public String toGridCell() {
        return isOccupied ? "  ■  │" : "  □  │";  // 라커가 배정되어 있으면 ■, 라커가 비어있으면 □ 표시
    }

    //정보 출력 매서드
    public void printInfo(){
        System.out.println("락커 번호: " + lockerNumber);
        System.out.println("사용 여부: " + (isOccupied? "이미 사용중인 락커입니다." : "사용 가능합니다."));
        System.out.println("배정 회원: " + (assignedMember != null? assignedMember.getName(): "없음"));

    }


    //getter추가
    //main이나 다른 클래스에서 락커 정보를 읽게 하기 위해서

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Member getAssignedMember() {
        return assignedMember;
    }
}

