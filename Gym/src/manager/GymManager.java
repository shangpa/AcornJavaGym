package manager;

import model.Member;
import model.Trainer;

import java.util.ArrayList;

public class GymManager {
    private ArrayList<Member> memberList  = new ArrayList<>();
    private ArrayList<Trainer> trainerList = new ArrayList<>();



    public void addMember(Member member)    { memberList.add(member); }
    public void addTrainer(Trainer trainer) { trainerList.add(trainer); }

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

    public void printAllMembers() {
        if (memberList.isEmpty()) { System.out.println("등록된 회원이 없습니다."); return; }
        System.out.println("=== 회원 목록 (" + memberList.size() + "명) ===");
        for (Member m : memberList) m.printInfo();
    }

    public void printAllTrainers() {
        if (trainerList.isEmpty()) { System.out.println("등록된 트레이너가 없습니다."); return; }
        System.out.println("=== 트레이너 목록 (" + trainerList.size() + "명) ===");
        for (Trainer t : trainerList) t.printInfo();
    }

    public ArrayList<Member>  getMemberList()  { return memberList; }
    public ArrayList<Trainer> getTrainerList() { return trainerList; }

}
