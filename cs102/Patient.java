package app;
import java.util.Scanner;
public class Patient extends User {
	
	Scanner std=new Scanner(System.in);
	
	int n=0;
	
	
	
	public Patient(String Name, String LastName, String email, String Number,String username,String password)
	{
		super(Name,LastName,email,Number,username,password);
	
	}
	
	public void change_info(){
		int answer=0;
		
		System.out.println("Enter password");
		String password_confirm=std.nextLine();
		
		if (password_confirm==password)
		{
		do {
			System.out.println("what would you like to change?");
			System.out.println("1) Phone Number : ");
			System.out.println("2) Email : ");
			System.out.println("3) Password : ");
		
		
			answer=std.nextInt();
			}while(answer<1||answer>3);
		
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
			
				
		}
		}
			else {
				System.out.println("wrong password.");
			 	}

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

	public void Doc_search(Doctor[] doctors) {


		do {
		System.out.println("please choose speciality : (leave empty not important)");
		String look_spec=std.nextLine();
		System.out.println("preferred adress : (leave empty if not important)");
		String look_adress=std.nextLine();
		}while(look_adress==""&&look_spec=="");

		for (int i=0; i<doctors.length;i++)
		{
			if (doctors[i].getSpec()==look_spec)
			{System.out.println(doctors[i].toString());}

			if (doctors[i].getOffice_adress==look_adress)
			{System.out.println(doctors[i].toString());}

		}



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
	
	public String FiletoString() 
	{
		return "Patient#"+super.FiletoString();	
	}	

	public String toString() 
	{
		return "Patient : "+super.toString();	
	}
}
