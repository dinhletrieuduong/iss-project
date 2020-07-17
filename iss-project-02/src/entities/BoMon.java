package entities;

public class BoMon {
    public int getMa_bo_mon() {
        return ma_bo_mon;
    }

    public void setMa_bo_mon(int ma_bo_mon) {
        this.ma_bo_mon = ma_bo_mon;
    }

    public int getMa_khoa() {
        return ma_khoa;
    }

    public void setMa_khoa(int ma_khoa) {
        this.ma_khoa = ma_khoa;
    }

    public int getMa_tbm() {
        return ma_tbm;
    }

    public void setMa_tbm(int ma_tbm) {
        this.ma_tbm = ma_tbm;
    }

    public String getTenBoMon() {
        return tenBoMon;
    }

    public void setTenBoMon(String tenBoMon) {
        this.tenBoMon = tenBoMon;
    }

    private int ma_bo_mon;
    private int ma_khoa;
    private int ma_tbm;
    private String tenBoMon;

}
