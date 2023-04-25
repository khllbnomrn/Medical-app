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
			String aux;
			
			do {
				System.out.println("what would you like to change?");
				System.out.println("1) Phone Number : ");
				System.out.println("2) Email : ");
				System.out.println("3) Password : ");
				System.out.println("4) Office Adress : ");
			
			
				answer=std.nextInt();
				}while(answer<1||answer>4);
			
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
					case 4 : 
				do {
					System.out.println("New Office Adress : ");
					aux=std.nextLine();
				}while(aux.equals(""));	
					office_adress=aux;
					break;		
				
					
			}
				System.out.println("personal info updated");
			}

		

		public void appointment_debrief()
		{
			System.out.println("id of appointment to change : (check appointments list)");
			int id=std.nextInt();
			int i=0;
			while(appointments.get(i).getId()!=id)
			{
				i++;
			}

			String diag;
			String pres;
			do{
			System.out.println("Diagnosis/Notes :");
			diag=std.nextLine();
			System.out.println("Prescription and instructions : ");
			pres=std.nextLine();
			}while(diag.equals("")||pres.equals(""));
			appointments.get(i).setDiagnosis(diag);
			appointments.get(i).setPrescription(pres);
			System.out.println("debrief succesful");
		}
		


		public void appointment_list()
		{
			super.appointment_list();
			if (appointments.size()!=0)
			{
				String answer;
				do {
			System.out.println("would you like to confirm an appointment ? this can't be changed later . (Y/N)");
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
						appointments.get(i).setD_confirm(true);
						
						System.out.println("Appointment confirmed. ");
					}
					else {i++;}
				}
					if (found==false)
					{System.out.println("appointment id invalid.");}
				}
				
		}



		}


		public int menu() {
			int answer=0;
			do {
			
			System.out.println("1) patient database");
			System.out.println("2) appointment debrief");
			System.out.println("3) check appointments list");
			System.out.println("4) change profile info");
			System.out.println("5) Logout: ");
			answer=std.nextInt();	
			}while(answer<1||answer>5);
			
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
		
		for (int i=0; i<appointments.size(); i++)
			{
			System.out.println(appointments.get(i).getPat().toString());	
			
		
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