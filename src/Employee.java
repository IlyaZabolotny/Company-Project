/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilya
 */
public class Employee {
    private int EID;
    private String name;
    private String surname;
    private String project;
    private int salary;
    public Employee(int EID, String name, String surname,String project,int salary)
    {
    this.EID=EID;
    this.name=name;
    this.surname=surname;
    this.project=project;
    this.salary=salary;
    }
    public int getEID()
    {
        return EID;
    }
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public String getProject()
    {
        return project;
    }
    public int getSalary()
    {
        return salary;
    }
}
