package manager;

import model.Locker;
import model.Member;
import model.Trainer;

import java.util.ArrayList;

public class GymManager {
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Trainer> trainerList = new ArrayList<>();
    private ArrayList<Locker> lockerList = new ArrayList<>();


    public void addMember(Member member) {
        memberList.add(member);
    }

    public void addTrainer(Trainer trainer) {
        trainerList.add(trainer);
    }

    public void addLocker(Locker locker) {
        lockerList.add(locker);
    }

    public Member findMember(String name) {
        for (Member m : memberList) {
            if (m.getName().equals(name)) return m;
        }
        return null;
    }

    public Trainer findTrainer(String name) {
        for (Trainer t : trainerList) {
            if (t.getName().equals(name)) return t;
        }
        return null;
    }

    //번호로 락커 찾기
    public Locker findLocker(int lockerNumber) {
        for (Locker locker : lockerList) {
            if (locker.getLockerNumber() == lockerNumber) {
                return locker; // 찾으면 바로 반환
            }
        }
        return null; // 못 찾으면 null 반환
    }

    public void printAllMembers() {
        if (memberList.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        System.out.println("=== 회원 목록 (" + memberList.size() + "명) ===");
        for (Member m : memberList) m.printInfo();
    }

    public void printAllTrainers() {
        if (trainerList.isEmpty()) {
            System.out.println("등록된 트레이너가 없습니다.");
            return;
        }
        System.out.println("=== 트레이너 목록 (" + trainerList.size() + "명) ===");
        for (Trainer t : trainerList) t.printInfo();
    }

    public void printAllLocker(){
        if (lockerList.isEmpty()) {
            System.out.println("등록된 라커가 없습니다.");
            return;
        }
        System.out.println("=== 락커 목록 (" + lockerList.size() + "개) ===");
        for (Locker l : lockerList) l.printInfo();
    }

    //락커 100칸 모양 표시하는 그리드
    public void printLockerGrid() {
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                    [ 락커 현황 ]                           │");
        System.out.println("│  ■ 사용중   □ 사용가능                                     │");
        System.out.println("├─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┤");

        for (int row = 0; row < 10; row++) { //0~9행 (총 10줄)
            StringBuilder numLine    = new StringBuilder("│"); //번호 줄
                                                               //반복문 안에서 수월하게 문자열을 계속 이어 붙이기 위해 StringBuilder사용
            StringBuilder statusLine = new StringBuilder("│"); // 상태 줄

            for (int col = 1; col <= 10; col++) { // 1~10열(10칸)
                int lockerNum = row * 10 + col;  // 실제 랔커 번호 계산
                                                 // 계산 예시)
                                                 // row=0, col=10 →  0*10+10 = 10번
                                                 // row=1, col=1  →  1*10+1  = 11번
                Locker l = findLocker(lockerNum);

                numLine.append(String.format("%3d  │", lockerNum)); // 번호 추가
                                                                    // 숫자를 3자리로 오른쪽 정렬하기 위해서 %3d사용
                                                                    // 1→  1, 10→ 10, 100→100 : 결과적으로 1~100까지 모든 번호가 같은 너비로 정렬됨
                statusLine.append(l.toGridCell()); // 상태 추가
            }

            System.out.println(numLine);
            System.out.println(statusLine);

            if (row < 9) {
                System.out.println("├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤");
            }
        }
        System.out.println("└─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘");
    }


    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Trainer> getTrainerList() {
        return trainerList;
    }

    public ArrayList<Locker> getLockerList() {
        return lockerList;
    }

    public void setLockerList(ArrayList<Locker> lockerList) {
        this.lockerList = lockerList;
    }
}
