package entities;

import java.sql.Date;

public class MonHocMo {
    private int ma_mon_hoc_mo;
    private int ma_mon_hoc;
    private int ma_giao_vien;
    private String ten_bo_mon;
    private String ten_mon_hoc;
    private int hoc_ky;
    private int so_luong;
    private Date ngay_mo;
    private Date ngay_ket_thuc;

    public int getMa_mon_hoc_mo() { return ma_mon_hoc_mo; }

    public void setMa_mon_hoc_mo(int ma_mon_hoc_mo) { this.ma_mon_hoc_mo = ma_mon_hoc_mo; }

    public int getMa_mon_hoc() { return ma_mon_hoc; }

    public void setMa_mon_hoc(int ma_mon_hoc) { this.ma_mon_hoc = ma_mon_hoc; }

    public int getMa_giao_vien() { return ma_giao_vien; }

    public void setMa_giao_vien(int ma_giao_vien) { this.ma_giao_vien = ma_giao_vien; }

    public String getTen_bo_mon() { return ten_bo_mon; }

    public void setTen_bo_mon(String ten_bo_mon) { this.ten_bo_mon = ten_bo_mon; }

    public String getTen_mon_hoc() { return ten_mon_hoc; }

    public void setTen_mon_hoc(String ten_mon_hoc) { this.ten_mon_hoc = ten_mon_hoc; }

    public int getHoc_ky() { return hoc_ky; }

    public void setHoc_ky(int hoc_ky) { this.hoc_ky = hoc_ky; }

    public int getSo_luong() { return so_luong; }

    public void setSo_luong(int so_luong) { this.so_luong = so_luong; }

    public Date getNgay_mo() { return ngay_mo; }

    public void setNgay_mo(Date ngay_mo) { this.ngay_mo = ngay_mo; }

    public Date getNgay_ket_thuc() { return ngay_ket_thuc; }

    public void setNgay_ket_thuc(Date ngay_ket_thuc) { this.ngay_ket_thuc = ngay_ket_thuc; }
}
