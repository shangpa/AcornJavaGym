import manager.GymManager;
import model.Member;
import model.MembershipType;
import model.Trainer;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static GymManager gm = new GymManager();

    public static void main(String[] args) {

        System.out.println("=== 헬스장 회원 관리 시스템 ===");

        while (true) {
            System.out.println("\n1. 회원 메뉴  2. 트레이너 메뉴  3. 운동기구 안내  0. 종료");
            System.out.print("선택 >> ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: memberMenu(); break;
                case 2: trainerMenu(); break;
                case 3: equipmentMenu(); break;
                case 0:
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }

        }
    }

    static void memberMenu() {
        String mName;
        Member m;
        System.out.println("=== 회원 메뉴 ==");
        System.out.println("1.회원 등록 2. 결제 3. 출석 0. 뒤로");
        System.out.print("선택 >> ");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice < 0 || choice > 3) {
                System.out.println("잘못된 선택입니다.");
                memberMenu();
                return;
            }

            switch (choice){
                case 1:
                    System.out.print("이름: ");      String name  = sc.nextLine();
                    System.out.print("번호: ");      String phone = sc.nextLine();
                    System.out.print("나이: ");      int age      = Integer.parseInt(sc.nextLine());
                    System.out.print("키(cm): ");    double height = Double.parseDouble(sc.nextLine());
                    System.out.print("몸무게(kg): "); double weight = Double.parseDouble(sc.nextLine());
                    m = new Member(name, phone, age, height, weight);
                    m.register();
                    System.out.println("회원권 선택 (1: 1개월 / 3: 3개월 / 6: 6개월 / 12: 12개월): ");
                    System.out.print("선택 >> ");
                    int membershipChoice = Integer.parseInt(sc.nextLine());
                    switch (membershipChoice) {
                        case 1:  m.setMembership(MembershipType.ONE_MONTH);    break;
                        case 3:  m.setMembership(MembershipType.THREE_MONTH);  break;
                        case 6:  m.setMembership(MembershipType.SIX_MONTH);    break;
                        case 12: m.setMembership(MembershipType.TWELVE_MONTHS); break;
                        default:
                            System.out.println("올바른 개월 수가 아닙니다. 멤버십 없이 등록됩니다.");
                            membershipChoice = 0;
                    }
                    if (membershipChoice != 0) {
                        m.pay(membershipChoice);
                    }
                    gm.addMember(m);
                    System.out.println(name + "님이 등록되었습니다.");
                    break;
                case 2:
                    System.out.print("회원 이름: ");      mName = sc.nextLine();
                    m = gm.findMember(mName);
                    if (m == null) { System.out.println("회원을 찾을 수 없습니다."); return; }
                    System.out.print("개월 수 (1/3/6/12): ");
                    m.pay(Integer.parseInt(sc.nextLine()));
                    break;
                case 3:
                    System.out.print("회원 이름: ");      mName = sc.nextLine();
                    m = gm.findMember(mName);
                    if (m == null) { System.out.println("회원을 찾을 수 없습니다."); return; }
                    m.checkIn();
                    break;
                case 0:
                    return;
            }

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            memberMenu();
            return;
        }

    }
    static void trainerMenu(){
        String tName;
        String mName;
        Trainer t;
        Member m;
        System.out.println("=== 트레이너 메뉴 ==");
        System.out.println("1.트레이너 등록 2.회원 추가 3.회원 조회 4.회원 식단 관리 5.출석 회원 조회 0. 뒤로");
        System.out.print("선택 >> ");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice < 0 || choice > 5) {
                System.out.println("잘못된 선택입니다.");
                trainerMenu();
                return;
            }

            switch (choice){
                case 1:
                    System.out.print("이름: ");      String name  = sc.nextLine();
                    System.out.print("번호: ");      String phone = sc.nextLine();
                    System.out.print("나이: ");      int age      = Integer.parseInt(sc.nextLine());
                    System.out.print("키(cm): ");    double height = Double.parseDouble(sc.nextLine());
                    System.out.print("몸무게(kg): "); double weight = Double.parseDouble(sc.nextLine());
                    t = new Trainer(name, phone, age, height, weight);
                    t.register();
                    gm.addTrainer(t);
                    break;
                case 2:
                    System.out.print("트레이너 이름: "); tName = sc.nextLine();
                    System.out.print("회원 이름: ");      mName = sc.nextLine();
                    t = gm.findTrainer(tName);
                    m = gm.findMember(mName);
                    if (t == null || m == null) { System.out.println("이름을 확인해 주세요."); return; }
                    t.addManagedMember(m);
                    break;
                case 3:
                    gm.printAllTrainers();
                    break;
                case 4:
                    System.out.print("트레이너 이름: "); tName = sc.nextLine();
                    System.out.print("회원 이름: "); mName = sc.nextLine();
                    t = gm.findTrainer(tName);
                    m = gm.findMember(mName);
                    if (t == null || m == null) { System.out.println("이름을 확인해 주세요."); return; }
                    t.manageDiet(m);
                    break;
                case 5:
                    System.out.print("트레이너 이름: "); tName = sc.nextLine();
                    t = gm.findTrainer(tName);
                    if (t == null) { System.out.println("이름을 확인해 주세요."); return; }
                    t.printAttendance();
                    break;
                case 0:
                    return;
            }

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            trainerMenu();
            return;
        }

    }

    static void equipmentMenu() {
        List<String> validParts = List.of("상체", "하체", "유산소");
        String mName;


        System.out.print("회원 이름: ");      mName = sc.nextLine();
        System.out.println("상체"+ "하체"+ "유산소");
        String bodyPart = sc.nextLine();

        if (!validParts.contains(bodyPart)) {
            System.out.println("잘못된 입력입니다.");
            equipmentMenu();
            return;
        }

        Member  m = gm.findMember(mName);
        if (m == null) { System.out.println("이름을 확인해 주세요.");
            equipmentMenu();
            return; }
        m.explainEquipment(bodyPart);
    }

}