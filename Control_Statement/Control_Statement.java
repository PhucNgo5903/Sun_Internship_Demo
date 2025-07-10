package Control_Statement;

import java.util.Scanner;

public class Control_Statement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap tuoi cua ban: ");
        int age = scanner.nextInt();

        // Su dung if-else de phan loai nhom tuoi
        if (age >= 60) {
            System.out.println("Ban thuoc nhom: Nguoi cao tuoi");
        } else if (age >= 40) {
            System.out.println("Ban thuoc nhom: Trung nien");
        } else if (age >= 18) {
            System.out.println("Ban thuoc nhom: Thanh nien");
        } else if (age >= 6) {
            System.out.println("Ban thuoc nhom: Tre em");
        } else {
            System.out.println("Ban thuoc nhom: Nhi dong");
        }

        // Su dung switch-case de dua ra goi y nghe nghiep
        switch (age / 10) {
            case 0:
                System.out.println("Goi y: Choi va hoc mam non");
                break;
            case 1:
                System.out.println("Goi y: Di hoc tieu hoc / THCS");
                break;
            case 2:
                System.out.println("Goi y: Sinh vien / Hoc nghe");
                break;
            case 3:
            case 4:
                System.out.println("Goi y: Lam viec, phat trien su nghiep");
                break;
            case 5:
            case 6:
                System.out.println("Goi y: Huong thu cuoc song / Co the nghi huu");
                break;
            default:
                System.out.println("Goi y: Cham soc suc khoe, Nghi Ngoi");
        }

        
        System.out.println("Cac moc tuoi quan trong:");
        for (int i = 0; i <= age; i += 5) {
            System.out.println("Tuoi: " + i);
        }
        scanner.close();
    }
}
