
package project.tracking.system.entity;


public class Employee {
    
    private int eid;
    private int cid;
    private String name;
    private String profile;
    private String email;
    private String password;

    public Employee(String name, String profile, String email, String password) {
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }
    
    public Employee(String name, String profile, String email) {
        this.name = name;
        this.profile = profile;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public Employee() {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Employee{" + "eid=" + eid + ", cid=" + cid + ", name=" + name + ", profile=" + profile + ", email=" + email + ", password=" + password + '}';
    }

}
