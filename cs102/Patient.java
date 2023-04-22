package app;
import java.util.Scanner;
public class Patient extends User {
	
	Scanner std=new Scanner(System.in);
	
	int n=0;
	
	
	
	public Patient(String Name, String LastName, String email, String Number,String username,String password)
	{
		super(Name,LastName,email,Number,username,password);
	
	}
	
	
	
	public void book_appointment(Doctor Doc) {
		

		System.out.println("Choose date : ");
		String date =std.nextLine();
		System.out.println("Describe your medical case : ");
		String medical_case =std.nextLine();
		System.out.println("Is your case urgent ? (Y/N)");
		String urg =std.nextLine();
		
		
		Appointment appointment=new Appointment(Doc,date,medical_case,this);
		if (urg=="Y")
		{
			appointment.setUrgency(true);
		}
		
		appointment.setP_confirm(true);
		super.add_appointmentlist(appointment);
		Doc.add_appointmentlist(appointment);
		
	}

	public int menu() {
		int answer=0;
		System.out.println("1) book appointment");
		System.out.println("2) look for doctor");
		System.out.println("3) check appointments list");
		System.out.println("4) change profile info");
		do {
		answer =std.nextInt();
		}while(answer<1||answer>4);
		
		return answer;
		
	}
	
	
	public Patient() {super();}
	
		
	public String toString() 
	{
		return "Patient : "+super.toString();	
	}
}
