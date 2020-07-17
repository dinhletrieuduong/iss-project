package entities;

public class DangKy {
    private String subjectName;
    private float practice;
    private float midterm;
    private float bonus;
    private float other;
    private float finalG;
    private float avg;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public float getPractice() {
        return practice;
    }

    public void setPractice(float practice) {
        this.practice = practice;
    }

    public float getMidterm() {
        return midterm;
    }

    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getOther() {
        return other;
    }

    public void setOther(float other) {
        this.other = other;
    }

    public float getFinalG() {
        return finalG;
    }

    public void setFinalG(float finalG) {
        this.finalG = finalG;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }
}
