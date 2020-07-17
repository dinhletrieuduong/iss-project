import gui.dialogs.SignInDialog;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        var dl = new SignInDialog();
        dl.showAndWait();
        var root = dl.routeMainPage();
        if (root == null) {
            return;
        }
        
        primaryStage.setTitle("Courses Enrollment");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/*
- Login / Logout
- Đăng ký
- CRUD thông tin môn học (trưởng phó khoa)
- Xem lịch dạy của giáo viên (trưởng bộ môn)
- CRUD số lượng sinh viên được đăng ký trong 1 môn học (trưởng bộ môn)
- Nhập thông tin cho biết môn học nào được mở ra trong một học kỳ cụ thể (Giáo vụ)
- Xem thông tin: môn học, dssv đăng ký môn học, lịch dạy của gv, điểm số (Giáo vụ)
- Thay đổi thông tin cá nhân chính mình (Giáo vụ, giáo viên, sinh viên)
- Xem thông tin danh sách môn học mở trong 1 học kì (Giáo viên)
- Xem danh sách môn học có thể dạy (Giáo viên)
- Xem danh sách lớp phụ trách (Giáo viên)
- Xem lịch dạy (Giáo viên)
- CRU điểm của sinh viên học môn của mình (Giáo viên)
- Đăng ký môn học (Sinh viên)
- Xoá, sửa thông tin đăng ký (Sinh viên)
- Xem danh sách môn học đc mở trong 1 năm và 1 học kỳ (gồm tên, mail giáo viên) (xem trước hay xem những môn đã học rồi?) (Sinh viên)
- Xem danh sách các môn đã đăng ký (Sinh viên)
- Xem điểm các môn học (Sinh viên)
 */