import com.opencsv.bean.CsvBind;

/**
 * Created by byrenx on 3/31/16.
 */
public class Employee{
    /**
     * note: remove @CsvBind when not using this class as Bean
     */
    @CsvBind
    private String employee;
    @CsvBind
    private String skills;
    @CsvBind
    private int age;
    @CsvBind
    private String position;

    public void setEmployee(String employee){
        this.employee = employee;
    }

    public void setSkills(String skills){
        this.skills = skills;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getEmployee(){
        return this.employee;
    }

    public String getSkills(){
        return this.skills;
    }

    public int getAge(){
        return this.age;
    }

    public String getPosition(){
        return this.position;
    }
}