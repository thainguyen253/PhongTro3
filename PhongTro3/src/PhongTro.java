import java.time.LocalDate;

public class PhongTro {
    private LocalDate ngayBatDauThue;
    private LocalDate ngayHetHanHopDong;
    private String tenPhong;

    private int giaPhong;
    private boolean checkPhong = false;

    private String nguoiThue;


    public PhongTro(String tenPhong, int giaPhong) {
        this.tenPhong = tenPhong;
        this.giaPhong = giaPhong;
    }


    public String getTenPhong() {
        return tenPhong;
    }

    public String getNguoiThue() {
        return nguoiThue;
    }

    public void setNguoiThue(String nguoiThue) {
        this.nguoiThue = nguoiThue;
    }

    public LocalDate getNgayBatDauThue() {
        return ngayBatDauThue;
    }

    public void setNgayBatDauThue(LocalDate ngayBatDauThue) {
        this.ngayBatDauThue = ngayBatDauThue;
    }

    public LocalDate getNgayHetHanHopDong() {
        return ngayHetHanHopDong;
    }

    public void setNgayHetHanHopDong(LocalDate ngayHetHanHopDong) {
        this.ngayHetHanHopDong = ngayHetHanHopDong;
    }

    public boolean isCheckPhong() {
        return checkPhong;
    }

    public void setCheckPhong(boolean checkPhong) {
        this.checkPhong = checkPhong;
    }

    public void inThongTinPhong(){
        System.out.println("Thông tin phòng trọ: ");
        System.out.println("Tên phòng: "+this.tenPhong);
        System.out.println("Giá: "+this.giaPhong);
        System.out.println("Ngày bắt đầu thuê: "+this.ngayBatDauThue);
        System.out.println("Ngày hết hạn hợp đồng: "+this.ngayHetHanHopDong);
        System.out.println("-----------------------------------");
        if(this.nguoiThue != null){
            System.out.println("Người thuê: " + this.nguoiThue);
        }
    }
    public void inSoPhong() {
        System.out.println("Các phòng còn trống: ");
        System.out.println("Tên phòng: "+this.tenPhong);
        System.out.println("-----------------------------------");
        }
}