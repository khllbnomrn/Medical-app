package app;
import java.util.ArrayList;
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
		String aux;
		
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
			do {
				System.out.println("New number : ");
				aux=std.nextLine();
			}while(aux.equals(""));	
				Number=aux;
				break;
			case 2 : 
			do {
				System.out.println("New email : ");
				aux=std.nextLine();
			}while(aux.equals(""));	
				email=aux;
				break;	
			case 3 : 
			do {
				System.out.println("New password : ");
				aux=std.nextLine();
			}while(aux.equals(""));	
				password=aux;
				break;	
			
				
		}
			System.out.println("personal info updated");
		}

		





	public void book_appointment(ArrayList<User> users,ArrayList<Appointment> appointments ) {
		
		int id;
		String date;
		String medical_case;
		String urg;
	
		
		System.out.println("Doctor id : ");
		 id=std.nextInt();do{
		System.out.println("Choose date : ");
		date =std.nextLine();
		
		}while(date.equals(""));
		do{
			System.out.println("Describe your medical case : ");
			 medical_case =std.nextLine();
		}while(medical_case.equals(""));
		do{
		
		System.out.println("Is your case urgent ? (Y/N)");
		 urg =std.nextLine();
		}while(urg.equals(""));


		

		boolean found=false;
		int i=0;
		while(i<users.size()&&found==false)
		{
		if(users.get(i).getId()==id)
		{
			found=true;
		}
		else {i++;}
		}
		if (found==false|| (users.get(i) instanceof Patient))
		{System.out.println("Doctor id invalid.");}
		else {
		Appointment appointment=new Appointment(((Doctor)users.get(i)),date,medical_case,this);
		if (urg.equals("Y"))
		{
			appointment.setUrgency(true);
		}
		
		appointments.add(appointment);
		appointment.setP_confirm(true);
		super.add_appointmentlist(appointment);
		users.get(i).add_appointmentlist(appointment);
		System.out.println("Appointemnt booked");
		System.out.println(appointment.toString());
	}
			
	}

	public void Doc_search(ArrayList<User> users) {

		String look_spec;
		String look_adress;
		do {
		
		System.out.println("please choose speciality : (leave empty not important)");
		 look_spec=std.nextLine();
		System.out.println("preferred adress : (leave empty if not important)");
		 look_adress=std.nextLine();

		}while(look_adress.equals("")&&look_spec.equals(""));

		int matches=0;
		System.out.println("Matches found : ");
		for (int i=0; i<users.size();i++)
		{
			if (users.get(i) instanceof Doctor)
			{
				if (((Doctor)users.get(i)).getSpec().equals(look_spec)||((Doctor)users.get(i)).getOffice_adress().equals(look_adress))
					{System.out.println(((Doctor)users.get(i)).toString());matches++;}			
			}
		}
		if (matches==0)
		{System.out.println("no matches found, please try again.");}


	}


	public int menu() {
		int answer=0;
		System.out.println("1) book appointment");
		System.out.println("2) look for doctor");
		System.out.println("3) check appointments list");
		System.out.println("4) change profile info");
		System.out.println("5) Logout: ");
		do {
		answer =std.nextInt();
		}while(answer<1||answer>5);
		
		return answer;
		
	}
	
	public void appointment_list()
		{
			super.appointment_list();
			if (appointments.size()!=0)
			{
				String answer;
				do {
			System.out.println("would you like to cancel an appointment ? this can't be changed later . (Y/N)");
				answer=std.nextLine();
				} while(answer.equals(""));

				if(answer.equals("Y"))
				{
					
					System.out.println("Select appointment id :");
					int id=std.nextInt();
					
				boolean found=false;
				int i=0;
				while(i<appointments.size()&&found==false)
				{
					if(appointments.get(i).getId()==id)
					{
						found=true;
						appointments.get(i).setP_confirm(false);
						System.out.println("Appointment canceled. ");
					}
					else {i++;}
				}
					if (found==false)
					{System.out.println("appointment id invalid.");}
				}
				
		}
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
