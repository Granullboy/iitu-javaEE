package kz.aboba.abobaservice.entity;

public class Aboba {
    private int employeeId;
    private boolean isAbobedThisMonth;
    private int AbobedLastYear;

    public Aboba() {}

    public Aboba(int employeeId, boolean isAbobedThisMonth, int AbobedLastYear) {
        this.employeeId = employeeId;
        this.isAbobedThisMonth = isAbobedThisMonth;
        this.AbobedLastYear = AbobedLastYear;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isAbobedThisMonth() {
        return isAbobedThisMonth;
    }

    public void setAbobedThisMonth(boolean abobedThisMonth) {
        isAbobedThisMonth = abobedThisMonth;
    }

    public int getAbobedLastYear() {
        return AbobedLastYear;
    }

    public void setAbobedLastYear(int abobedLastYear) {
        AbobedLastYear = abobedLastYear;
    }

    @Override
    public String toString() {
        return "Aboba{" +
                "employeeId=" + employeeId +
                ", isAbobedThisMonth=" + isAbobedThisMonth +
                ", AbobedLastYear=" + AbobedLastYear +
                '}';
    }
}
