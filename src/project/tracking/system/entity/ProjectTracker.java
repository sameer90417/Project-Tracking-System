/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.entity;


public class ProjectTracker {
    
    private int sid;
    private int pid;
    private int designersTask;
    private int coderesTask;
    private int testersTask;
    
    private int completedDesignersTask;
    private int completedCodersTask;
    private int completedTestersTask;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getDesignersTask() {
        return designersTask;
    }

    public void setDesignersTask(int designersTask) {
        this.designersTask = designersTask;
    }

    public int getCoderesTask() {
        return coderesTask;
    }

    public void setCoderesTask(int coderesTask) {
        this.coderesTask = coderesTask;
    }

    public int getTestersTask() {
        return testersTask;
    }

    public void setTestersTask(int testersTask) {
        this.testersTask = testersTask;
    }

    public int getCompletedDesignersTask() {
        return completedDesignersTask;
    }

    public void setCompletedDesignersTask(int completedDesignersTask) {
        this.completedDesignersTask = completedDesignersTask;
    }

    public int getCompletedCodersTask() {
        return completedCodersTask;
    }

    public void setCompletedCodersTask(int completedCodersTask) {
        this.completedCodersTask = completedCodersTask;
    }

    public int getCompletedTestersTask() {
        return completedTestersTask;
    }

    public void setCompletedTestersTask(int completedTestersTask) {
        this.completedTestersTask = completedTestersTask;
    }

    public ProjectTracker() {
    }

    public ProjectTracker(int pid, int designersTask, int coderesTask, int testersTask, int completedDesignersTask, int completedCodersTask, int completedTestersTask) {
        this.pid = pid;
        this.designersTask = designersTask;
        this.coderesTask = coderesTask;
        this.testersTask = testersTask;
        this.completedDesignersTask = completedDesignersTask;
        this.completedCodersTask = completedCodersTask;
        this.completedTestersTask = completedTestersTask;
    }

    @Override
    public String toString() {
        return "ProjectTracker{" + "sid=" + sid + ", pid=" + pid + ", designersTask=" + designersTask + ", coderesTask=" + coderesTask + ", testersTask=" + testersTask + ", completedDesignersTask=" + completedDesignersTask + ", completedCodersTask=" + completedCodersTask + ", completedTestersTask=" + completedTestersTask + '}';
    }
    
    
    
    
}
