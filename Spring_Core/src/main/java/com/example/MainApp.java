package com.example;

import com.example.config.AppConfig;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // 1. Khởi tạo context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        // 2. Xoá sạch dữ liệu cũ (nếu có)
        List<User> oldUsers = userService.getAllUsers();
        for (User u : oldUsers) {
            userService.deleteUser(u.getId());
        }

        // 3. Thêm 2 user hợp lệ
        userService.createUser("Ronaldo", "ronaldo@gmail.com");
        userService.createUser("Messi", "messi@example.com");

        // 4. Lấy tất cả user
        System.out.println("Danh sach nguoi dung:");
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.getId() + " | " + user.getName() + " | " + user.getEmail());
        }

        // 5. Tìm user theo ID
        User found = userService.getUserById(1L);
        System.out.println("\nTim theo ID 1: " + found.getName());

        // 6. Xoá user ID 2
        userService.deleteUser(2L);
        System.out.println("\nDa xoa user co ID 2");

        // 7. In lại danh sách sau khi xoá
        System.out.println("\nDanh sach sau khi xoa:");
        users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.getId() + " | " + user.getName() + " | " + user.getEmail());
        }

        // 8. Test rollback: thêm 1 user hợp lệ + 1 user lỗi
        try {
            userService.createUser("Minh", "minh@example.com");
            userService.createUser("ERROR", "error@example.com"); // tên này gây lỗi
        } catch (Exception e) {
            System.out.println("Xuat hien loi :" + e.getMessage());
        }

        // 9. In lại danh sách để xác nhận rollback
        System.out.println("\nDanh sach sau khi rollback:");
        users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.getId() + " | " + user.getName() + " | " + user.getEmail());
        }

        context.close();
    }
}
