/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.entity;

/**
 *
 * @author hp
 */
public class Project {
    
    private int pid;
    private String name;
    private String description;
    private int numberOfDesigner;
    private int numberOfCoder;
    private int numberOfTester;
    private String assignDate;
    private String endDate;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfDesigner() {
        return numberOfDesigner;
    }

    public void setNumberOfDesigner(int numberOfDesigner) {
        this.numberOfDesigner = numberOfDesigner;
    }

    public int getNumberOfCoder() {
        return numberOfCoder;
    }

    public void setNumberOfCoder(int numberOfCoder) {
        this.numberOfCoder = numberOfCoder;
    }

    public int getNumberOfTester() {
        return numberOfTester;
    }

    public void setNumberOfTester(int numberOfTester) {
        this.numberOfTester = numberOfTester;
    }

    public String getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(String assignDate) {
        this.assignDate = assignDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Project(int pid, String name, String description, int numberOfDesigner, int numberOfCoder, int numberOfTester, String assignDate, String endDate) {
        this.pid = pid;
        this.name = name;
        this.description = description;
        this.numberOfDesigner = numberOfDesigner;
        this.numberOfCoder = numberOfCoder;
        this.numberOfTester = numberOfTester;
        this.assignDate = assignDate;
        this.endDate = endDate;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" + "pid=" + pid + ", name=" + name + ", description=" + description + ", numberOfDesigner=" + numberOfDesigner + ", numberOfCoder=" + numberOfCoder + ", numberOfTester=" + numberOfTester + ", assignDate=" + assignDate + ", endDate=" + endDate + '}';
    }
    
    
    
}
