package bean;

import java.sql.Blob;

public class UserBean {

    private int id;
    private String name;
    private String pwd;
    private String email;
    private int tele;
    private Blob profile;
    private String signature;
    private String job;
    private String company;
    private String school;
    private String address;
    private int collection_id;
    private int history_id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public int getTele() {
        return tele;
    }

    public void setProfile(Blob profile) {
        this.profile = profile;
    }

    public Blob getProfile() {
        return profile;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCollectionId(int collection_id) {
        this.collection_id = collection_id;
    }

    public int getCollectionId() {
        return collection_id;
    }

    public void setHistoryId(int history_id) {
        this.history_id = history_id;
    }

    public int getHistoryId() {
        return history_id;
    }
}
