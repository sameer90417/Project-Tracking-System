/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.entity;

public class Coder {
    
    private int cdid;
    private int eid;
    private int pid;

    public int getCdid() {
        return cdid;
    }

    public void setCdid(int cdid) {
        this.cdid = cdid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Coder{" + "cdid=" + cdid + ", eid=" + eid + ", pid=" + pid + '}';
    }

    public Coder() {
    }

    public Coder(int cdid, int eid, int pid) {
        this.cdid = cdid;
        this.eid = eid;
        this.pid = pid;
    }
    
    
    
}
