import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvBind;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by byrenx on 3/31/16.
 */

public class CSVJson {

    public CSVJson() throws IOException{
        parseUsingBean();
        // parseManual();
    }


    public void parseUsingBean() throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        final File file = new File(classLoader.getResource("employee.csv").getFile());
        HeaderColumnNameMappingStrategy<Employee> strat = new HeaderColumnNameMappingStrategy();
        strat.setType(Employee.class);

        CsvToBean<Employee> csv = new CsvToBean();
        List list = csv.parse(strat, new InputStreamReader(new FileInputStream(file)));
        System.out.println(new ObjectMapper().writeValueAsString(list));
    }

    public void parseManual() throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        final File file = new File(classLoader.getResource("employee.csv").getFile());
        CSVReader reader = new CSVReader(new FileReader(file));
        String [] nextLine;
        EmployeeList emplist = new EmployeeList();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        while ((nextLine = reader.readNext()) != null) {
            Employee emp = new Employee();
            //System.out.println(nextLine[0] + nextLine[1] + "etc...");
            emp.setEmployee(nextLine[0]);
            emp.setSkills(nextLine[1]);
            emp.setAge(Integer.parseInt(nextLine[2]));
            emp.setPosition(nextLine[3]);
            employees.add(emp);
        }

        emplist.setEmployee_list(employees);
        JSONObject emp_json_list = new JSONObject(emplist);
        System.out.println(emp_json_list.toString());
    }

    public static void main(String[] args) throws IOException{
        new CSVJson();
    }
}
