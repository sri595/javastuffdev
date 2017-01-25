package Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springdo.Employee1;
import dao.EmployeeDao;

public class TestSpring {

	public static void main(String[] args) {
		
	    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
	      
	    EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
	    int status=dao.saveEmployee(new Employee1(102,"Amit",35000));  
	    
	    
	    //for updation
	   /* int status=   dao.updateEmployee(new Employee1(102,"sri",35000));
	    
	    
	    Employee1 employee1=new Employee1();
	    employee1.setId(102);
	    int status=  dao.deleteEmployee(employee1);*/
	  System.out.println(status);

	}

}
