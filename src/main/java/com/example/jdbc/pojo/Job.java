package com.example.jdbc.pojo;

public class Job {
    private String  jobid;
    private String  coid;
    private String name;
    private String money;
    private String workarea;
    private String coname;
    private String cotype;
    private String cosize;
    private String jobwelf;
    private String experience;
    private String degreefrom;
    private String num;
    private String content;
    private String updatedate;
    private int coled;
    private int deled;

    public Job() {}

    public Job(String jobid, String coid, String name, String money, String workarea, String coname, String cotype, String cosize, String jobwelf, String experience, String degreefrom, String num, String content, String updatedate, int coled, int deled) {
        this.jobid = jobid;
        this.coid = coid;
        this.name = name;
        this.money = money;
        this.workarea = workarea;
        this.coname = coname;
        this.cotype = cotype;
        this.cosize = cosize;
        this.jobwelf = jobwelf;
        this.experience = experience;
        this.degreefrom = degreefrom;
        this.num = num;
        this.content = content;
        this.updatedate = updatedate;
        this.coled = coled;
        this.deled = deled;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWorkarea() {
        return workarea;
    }

    public void setWorkarea(String workarea) {
        this.workarea = workarea;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public String getCotype() {
        return cotype;
    }

    public void setCotype(String cotype) {
        this.cotype = cotype;
    }

    public String getCosize() {
        return cosize;
    }

    public void setCosize(String cosize) {
        this.cosize = cosize;
    }

    public String getJobwelf() {
        return jobwelf;
    }

    public void setJobwelf(String jobwelf) {
        this.jobwelf = jobwelf;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDegreefrom() {
        return degreefrom;
    }

    public void setDegreefrom(String degreefrom) {
        this.degreefrom = degreefrom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public int getColed() {
        return coled;
    }

    public void setColed(int coled) {
        this.coled = coled;
    }

    public int getDeled() {
        return deled;
    }

    public void setDeled(int deled) {
        this.deled = deled;
    }

}
