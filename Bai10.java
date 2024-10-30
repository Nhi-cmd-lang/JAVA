import java.util.ArrayList;
import java.util.Scanner;

class Nguoi {
    private String hoTen;
    private int namSinh;
    private String gioiTinh;
    private String diaChi;
    private String soCCCD;

    // Hàm khởi tạo mặc định
    public Nguoi() {
        this.hoTen = "Nguyen Van A";
        this.namSinh = 2000;
        this.gioiTinh = "Nam";
        this.diaChi = "Ha Noi";
        this.soCCCD = "123456789";
    }

    // Hàm khởi tạo với tham số
    public Nguoi(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soCCCD = soCCCD;
    }

    // Phương thức nhập thông tin
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho va ten: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhap nam sinh: ");
        namSinh = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhap gioi tinh: ");
        gioiTinh = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = scanner.nextLine();
        System.out.print("Nhap so CCCD: ");
        soCCCD = scanner.nextLine();
    }

    // Phương thức xuất thông tin
    public void xuat() {
        System.out.printf("Ho va ten: %s, Nam sinh: %d, Gioi tinh: %s, Dia chi: %s, So CCCD: %s\n",
                hoTen, namSinh, gioiTinh, diaChi, soCCCD);
    }
}

class SinhVien extends Nguoi {
    private String maSoSV;
    private String lop;
    private double tbTK;

    // Hàm khởi tạo mặc định
    public SinhVien() {
        super();
        this.maSoSV = "SV001";
        this.lop = "CNTT1";
        this.tbTK = 6.5;
    }

    // Hàm khởi tạo với tham số
    public SinhVien(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD,
                    String maSoSV, String lop, double tbTK) {
        super(hoTen, namSinh, gioiTinh, diaChi, soCCCD);
        this.maSoSV = maSoSV;
        this.lop = lop;
        this.tbTK = tbTK;
    }

    // Phương thức nhập thông tin
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma so sinh vien: ");
        maSoSV = scanner.nextLine();
        System.out.print("Nhap lop: ");
        lop = scanner.nextLine();
        System.out.print("Nhap diem trung binh toan khoa: ");
        tbTK = scanner.nextDouble();
    }

    // Phương thức xuất thông tin
    public void xuat() {
        super.xuat();
        System.out.printf("Ma so SV: %s, Lop: %s, TBTK: %.2f, Xep loai: %s\n",
                maSoSV, lop, tbTK, xepLoai());
    }

    // Phương thức xếp loại tốt nghiệp
    public String xepLoai() {
        if (tbTK >= 9.0) return "Xuat sac";
        else if (tbTK >= 8.0) return "Gioi";
        else if (tbTK >= 7.0) return "Kha";
        else if (tbTK >= 5.5) return "Trung binh";
        else return "Yeu";
    }

    public String getMaSoSV() {
        return maSoSV;
    }
}

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SinhVien> danhSach = new ArrayList<>();
        int n;

        System.out.print("Nhap so luong sinh vien: ");
        n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Nhập danh sách sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin cho sinh vien " + (i + 1) + ":");
            SinhVien sv = new SinhVien();
            sv.nhap();
            danhSach.add(sv);
        }

        // In danh sách xếp loại tốt nghiệp
        System.out.println("\nDanh sach sinh vien va xep loai:");
        for (SinhVien sv : danhSach) {
            sv.xuat();
        }

        // Tìm sinh viên theo mã số
        System.out.print("Nhap ma so sinh vien de tim kiem: ");
        String maSoSVTimKiem = scanner.nextLine();
        boolean found = false;

        for (SinhVien sv : danhSach) {
            if (sv.getMaSoSV().equals(maSoSVTimKiem)) {
                System.out.println("Thong tin sinh vien co ma so " + maSoSVTimKiem + ":");
                sv.xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien voi ma so: " + maSoSVTimKiem);
        }
    }
}
