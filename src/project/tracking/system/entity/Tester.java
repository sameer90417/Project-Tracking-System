/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.entity;


public class Tester {
    
    private int tid;
    private int eid;
    private int pid;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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

    public Tester(int tid, int eid, int pid) {
        this.tid = tid;
        this.eid = eid;
        this.pid = pid;
    }

    public Tester() {
    }

    @Override
    public String toString() {
        return "Tester{" + "tid=" + tid + ", eid=" + eid + ", pid=" + pid + '}';
    }
    
    
    
}
