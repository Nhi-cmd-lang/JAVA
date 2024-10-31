//import Mylib.*;
import Mylib.PhepTinh;
import Mylib.PhepTinhKhac;
import java.util.Scanner;
class TestPackage
{
    public static void main(String args[])
    { int a,b;
        PhepTinh pheptinh = new PhepTinh();
        PhepTinhKhac ptkhac = new PhepTinhKhac();
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen a: ");
        a = nhap.nextInt();
        System.out.print("Nhap vao so nguyen b: ");
        b = nhap.nextInt();
        System.out.println("Tong cua "+a+"+"+b+"="+pheptinh.cong(a,b));
        System.out.println("Ket qua "+a+"^"+b+" = "+ ptkhac.luyThua(a,b));
    }
}