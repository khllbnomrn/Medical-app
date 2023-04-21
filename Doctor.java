package app;
import java.util.Scanner;
public class Doctor extends User {
	
	private String office_adress;
	int n=0;
	private Patient[] Patients=new Patient[n];
	private String Spec;
	
	Scanner std=new Scanner(System.in);
	public Doctor(String Name, String LastName, String email, String Number,String username,String password, String office_adress,String Spec)
	{
		super(Name,LastName,email,Number,username,password);
		this.office_adress=office_adress;
		this.Spec=Spec;
	}
	
	public void setAdress(String office_adress)
	{
		
		this.office_adress=office_adress;
	}

	public String getSpec()
	{
		return Spec;
	}
	
	public Doctor() {super();}

	
	public int menu() {
		int answer=0;
		do {
			
		System.out.println("1) patient database");
		System.out.println("2) appointment debrief");
		System.out.println("3) check appointments list");
		System.out.println("4) change profile info");
			answer=std.nextInt();
			
			
			}while(answer<1||answer>4);
			
			return answer;
		
	}
	
	
	public void add_patient(Patient P)
	{
		
		Patient[] Patients_aux=new Patient[n+1];
		for (int i=0; i<n ;i++)
		{
			Patients_aux[i]=Patients[i];
			Patients_aux[n]=P;					
		}
		for (int i=0; i<=n ;i++)
		{
			Patients[i]=Patients_aux[i];
		}
		n++;
	}
	
	public void patientslist() {
		
		for (int i=0; i<n; i++)
		{
			System.out.println(Patients[i].toString());	
		}
		
	}
	
	public String toString() 
	{
		return "Doctor : "+super.toString()+"\nOffice Adress : "+office_adress+"\nSpeciality : "+Spec;
	}	
}
