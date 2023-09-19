package emp.salary.cal;

public class SalaryCalculator {
	 
	
	 public static void main(String[] args) {
		 Employee emp = new Employee();
			emp.setHr_reg(100);
			int  over1= (int)(100*1.5);
			emp.setHr_over(over1);
			
			int reg =emp.getHr_reg();
			int over=emp.getHr_over();
			int reg_hr_worked=40;
			int over_hr_worked=10;
			
			System.out.println("Hourly regular salary="+reg);
			System.out.println("Hourly overtime salary="+over);
			System.out.println("Regular time in week="+reg_hr_worked);
			System.out.println("overtime time in week="+over_hr_worked);
	
			SalaryCalculator cs=new SalaryCalculator();
			float res=cs.calculateSalary(reg, over, reg_hr_worked, over_hr_worked);
			cs.Display(res);
			
}
	 public int calculateSalary(int reg,int over, int reg_hr_worked,int over_hr_worked)
	 {
	 	int pay=(reg * reg_hr_worked)+(over*over_hr_worked);
	 	return pay;
	 }
	 public void Display(float pay)
	 {
		 System.out.println("Weekly salary of employee="+pay);
	 }
}
