/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.entity;


public class Designer {
    
    private int did;
    private int eid;
    private int pid;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
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
        return "Designer{" + "did=" + did + ", eid=" + eid + ", pid=" + pid + '}';
    }

    public Designer(int did, int eid, int pid) {
        this.did = did;
        this.eid = eid;
        this.pid = pid;
    }

    public Designer() {
    }
    
    
    
}
