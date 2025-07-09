package Control_Statement;
import java.util.Scanner;

public class control_statement {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap diem cua ban (0 - 100): ");
        int score = scanner.nextInt();

        // Su dung if-else de phan loai hoc luc
        if (score >= 90) {
            System.out.println("Xep loai: Xuat sac");
        } else if (score >= 80) {
            System.out.println("Xep loai: Gioi");
        } else if (score >= 70) {
            System.out.println("Xep loai: Kha");
        } else if (score >= 50) {
            System.out.println("Xep loai: Trung binh");
        } else {
            System.out.println("Xep loai: Yeu");
        }

        // Su dung switch-case de dua ra phan thuong
        switch (score / 10) {
            case 10:
            case 9:
                System.out.println("Thuong: Hoc bong toan phan");
                break;
            case 8:
                System.out.println("Thuong: Hoc bong ban phan");
                break;
            case 7:
                System.out.println("Thuong: Giay khen");
                break;
            default:
                System.out.println("Khong co thuong");
        }

        // Vong lap for de in tu 0 den score voi buoc nhay 20
        System.out.println("In cac moc diem:");
        for (int i = 0; i <= score; i += 20) {
            System.out.println("Moc: " + i);
        }
    }
}
