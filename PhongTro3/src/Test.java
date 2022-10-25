import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static List<PhongTro> phongs = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("Menu quản lý phòng trọ");
            System.out.println("1. Nhập phòng trọ mới");
            System.out.println("2. Tìm phòng trọ chưa được thuê");
            System.out.println("3. Tìm kiếm phòng trọ đang được thuê" );
            System.out.println("4. Đăng kí thủ tục thuê phòng");
            System.out.println("5. Xóa phòng trọ");
            System.out.println("6 .Xem danh sách phòng trọ");
            System.out.println("7 .Thoát");
            int so = Integer.parseInt(sc.nextLine());
            if (!checkValidPhong() && so != 1) {
                System.out.println("Hiện tại chưa có phòng trọ nào trong danh sách quản lý");
            } else {
                switch (so) {
                    case 1:
                        nhapPhong();
                        menu();
                        break;
                    case 2:
                        timPhong("checkPhongChuaDuocThue");
                        menu();
                        break;
                    case 3:
                        timPhong("checkPhongDaDuocThueTheoNgay");
                        menu();
                        break;
                    case 4:
                        dangKyPhong();
                        menu();
                        break;
                    case 5:
                        xoaPhong();
                        menu();
                        break;
                    case 6:
                        timPhong("");
                        menu();
                        break;
                    case 7:
                        return;
                    default:
                        return;
                }
            }

        }
    }

    public static void nhapPhong() {
        System.out.println("Mời bạn nhập số lượng phòng cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Mời bạn nhập tên phòng " + (i + 1));
            String name = sc.nextLine();
            System.out.println("Mời nhập giá phòng " + (i + 1));
            int price = Integer.parseInt(sc.nextLine());
            PhongTro pt = new PhongTro(name, price);
            phongs.add(pt);
        }
    }

    public static void timPhong(String keySearch) {
        switch (keySearch) {
            case "checkPhongChuaDuocThue":
                System.out.println("Những phòng trọ chưa có người thuê là: ");
                for (PhongTro phong : phongs
                ) {
                    if ((phong.getNgayBatDauThue() == null && phong.getNgayHetHanHopDong() == null && phong.getNguoiThue() == null)) {
                        phong.inThongTinPhong();
                    }
                }
                break;
            case "checkPhongDaDuocThueTheoNgay":
                LocalDate date = nhapDate("");
                for (PhongTro phong : phongs
                ) {
                    if (phong.getNgayHetHanHopDong() != null && phong.getNgayBatDauThue() != null && phong.getNgayHetHanHopDong().isAfter(date) && phong.getNgayBatDauThue().isBefore(date)) {
                        phong.inThongTinPhong();
                    }
                }
                break;
            default:
                System.out.println("Thông tin phòng: ");
                for (PhongTro phong : phongs
                ) {
                    phong.inThongTinPhong();
                }
                break;
        }
    }

    private static LocalDate nhapDate(String keyDate) {
        while (true) {
            try {
                System.out.println("Mời bạn nhập ngày " + keyDate);
                String a = sc.nextLine();
                return LocalDate.parse(a, dinhDang);
            } catch (Exception e) {
                System.out.println("Mời bạn nhập lại đúng định dạng " + "dd/MM/yyyy");
            }
        }
    }

    public static void dangKyPhong() {
        System.out.print("Các phòng còn trống: ");
        for (PhongTro phong : phongs) {
            if ((phong.getNgayBatDauThue() == null && phong.getNgayHetHanHopDong() == null && phong.getNguoiThue() == null)) {
                phong.inSoPhong();
            }
        }
        System.out.println("Mời bạn nhập vào mã phòng cần làm hợp đồng");
        String tenPhong = sc.nextLine();
        Boolean check = true;

                for (PhongTro phong : phongs) {
                    if (phong.getTenPhong().equals(tenPhong)) {
                        System.out.println("Mời bạn nhập người thuê phòng: ");
                        phong.setNguoiThue(sc.nextLine());
                        phong.setNgayBatDauThue(nhapDate("ngày bắt đầu"));
                        phong.setNgayHetHanHopDong(nhapDate("Ngày hết hạn hợp đồng"));
                        phong.setCheckPhong(true);
                        check = true;
                    } else {
                        check=false;
                        System.out.println("Bạn vừa nhập sai số phòng, vui lòng nhập đúng số phòng theo danh sách trên");
                        break;


                }
            }
        }
    public static boolean checkValidPhong() {
        return phongs.size() > 0;
    }
    public static void xoaPhong() {
        System.out.println("Mời bạn nhập vào tên phòng cần xoá");
        String tenPhong = sc.nextLine();
        phongs.removeIf(phong -> phong.getTenPhong().equals(tenPhong));
    }
}