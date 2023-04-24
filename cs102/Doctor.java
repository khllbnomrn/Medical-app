package app;
import java.util.Scanner;
import java.util.ArrayList;
public class Doctor extends User 
{	
		private String office_adress;
		

		int n=0;
		private  ArrayList<Patient> Patients=new ArrayList<Patient>();
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




		public void change_info(){
		int answer=0;
		
		System.out.println("Enter password");
		String password_confirm=std.nextLine();
		
		if (password_confirm.equals(password))
		{
		do {
			System.out.println("what would you like to change?");
			System.out.println("1) Phone Number : ");
			System.out.println("2) Email : ");
			System.out.println("3) Password : ");
			System.out.println("4) office adress: ");
			answer=std.nextInt();
			
			}while(answer<1||answer>4);
	
		switch(answer)
		{
			case 1 : 
				System.out.println("New number : ");
				Number=std.nextLine();
				break;
			case 2 :
				System.out.println("New email : ");
				email=std.nextLine();
				break;	
			case 3 : 
				System.out.println("New password : ");
				password=std.nextLine();
				break;	
			case 4	: System.out.println("New office adress : ");
			office_adress=std.nextLine();
			break;	
				
		}
		}
			else {
				System.out.println("wrong password.");
			 	}

		}

		public void appointment_debrief(Appointment a)
		{
			System.out.println("Diagnosis/Notes :");
			a.setDiagnosis=std.nextLine();
			System.out.println("Prescription and instructions : ");
			a.setPrescription=std.nextLine();

		}
		


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
	
		public String getOffice_adress() {
			return office_adress;
		}

		public void add_patient(Patient P)
		{
			Patients.add(P);	
		}
	
		public void patientslist() {
		
		for (int i=0; i<n; i++)
			{
			System.out.println(Patients.get(i).toString());	
			
		
		}
	}
		public String FiletoString() 
		{
		return "Doctor#"+super.FiletoString()+"#"+office_adress+"#"+Spec;
		}

		public String toString() 
		{
		return "Doctor : "+super.toString()+" "+office_adress+" "+Spec;
		}	
}