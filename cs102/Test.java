package app;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Test {
	
	
	public static void main(String[] args) {
		Scanner std=new Scanner(System.in);
		boolean login=false;
		int user_in=0;
		Files file_init = new Files();
		File file = new File("Users.txt");
		File file2 = new File("appointments.txt");

		User temp= new Doctor();
		Appointment temp2=new Appointment();

		//testing values User temp=new Doctor("Name","last name","email","numer","username","password","office","spec");users.add(temp);
		
		//testing values User temp2=new Doctor("name","last name","email","numer","username","password","office","spec");users.add(temp2);
		file_init.createfile("Users.txt");
		file_init.createfile("appointments.txt");
		
		ArrayList<String> arr=file_init.ReadFile("Users.txt");
		ArrayList<String> arr2=file_init.ReadFile("appointments.txt");

		ArrayList<User> users= new ArrayList<User>();
		ArrayList<Appointment> appointments= new ArrayList<Appointment>();
		
		

		if (file.length()!=0)
		{
			users=String_user(arr);
		}

		if (file2.length()!=0)
		{
			appointments=string_Appointments(arr2,users);
		}

		
		do {
		//login-sign up page
		
		do {	
		System.out.print("Hello!\nChoose Option : 1) signup | 2) login ");
		user_in=std.nextInt();
		}while(user_in<1||user_in>2);
		
		
		
		switch (user_in)
		{
			case 1 : 
				int user_type=0;
				do {
				System.out.print("are you : 1) Doctor | 2) patient ");
				user_type=std.nextInt();
				}while(user_type<1||user_type>2);
				
				switch(user_type) {
				
				case 1 :
					temp=signup('D',users);
					break;
					
				case 2 : 
					temp=signup('P',users);
					
					break;

					}
				users.add(temp);	
				login=true;
				break;
				
			case 2 :	
				
				if (users.size()==0)
				{
					System.out.println("No registries in the system please sign up !");
					break;
				}
				String answer="";
				boolean exit=false;

				do
				{

				
					System.out.print("Username : ");
					String username=std.nextLine();

					System.out.print("Password : ");
					String password=std.nextLine();
					temp=auth(password,username,users);

				if (temp!=null)
				{
					exit=true;
					login=true;
				}
				else 
				{
					System.out.print("would you like to try again? (Y/N)");
					answer=std.nextLine();
				}
				
				if (answer.equals("N"))
				{
					exit=true;
					break;
				}
				
				}while(!exit);
				
				
		
				

		
		}
		//end login-signup
		}while(!login);
	
	
		System.out.println("log in/sign up succesful");
		if (temp instanceof Patient)
		{
			System.out.println(((Patient)temp).toString());
		}
		else {
			System.out.println(((Doctor)temp).toString());
		}
		int option;
		do{
		System.out.println("what would you like to do next?");
			
		option=temp.menu();
		execute(option,temp,users,appointments);

		
		}while (option!=5);
		
		file_init.writefileuse("Users.txt", users);
		file_init.writefileapp("appointments.txt", appointments);
		
		
		System.exit(0);
		
		
}
	public static ArrayList<User> String_user(ArrayList<String> user_info)
	{

		ArrayList<User> users=new ArrayList<User>();
		for (int i=0; i<user_info.size();i++)
		{
		
			String[] filter = user_info.get(i).split("#");
			  
			  
			   if (filter[0].equals("Doctor"))
			   {
				   users.add(new Doctor(filter[2],filter[3],filter[4],filter[5],filter[6],filter[7],filter[8],filter[9]));
			   }
			   else    { 
				users.add(new Patient(filter[2],filter[3],filter[4],filter[5],filter[6],filter[7]));
					   }
			
		
		
	}	
	return users;
}

public static ArrayList<Appointment> string_Appointments(ArrayList<String> appointment_info,ArrayList<User> users)
	{

		ArrayList<Appointment> appointments=new ArrayList<Appointment>();
		for (int i=0; i<appointment_info.size();i++)
		{
			User aux= new Doctor();
			User aux2= new Patient();

			
			String[] filter = appointment_info.get(i).split("#");
			for (int j=0;j<users.size();j++)
			{
				
				if (Integer.parseInt(filter[6])==users.get(j).getId())
					{aux=users.get(j);}

					if (Integer.parseInt(filter[7])==users.get(j).getId())
					{aux2=users.get(j);}
			}

			Appointment a=new Appointment(filter[1],filter[2],filter[3],filter[4],Boolean.valueOf(filter[5]),((Doctor)aux),((Patient)aux2),Boolean.valueOf(filter[8]),Boolean.valueOf(filter[9]));
			appointments.add(a);
			((Doctor)aux).add_appointmentlist(a);
			((Patient)aux2).add_appointmentlist(a);
			   
			
		
		
	}	
	return appointments;
}


	public static void execute(int option, User temp, ArrayList<User> users,ArrayList<Appointment> appointments)
	{
		
		switch(option){
			
			case 1 : 

				if (temp instanceof Doctor)
					{
						((Doctor)temp).patientslist();
					}

			else {
					((Patient)temp).book_appointment(users,appointments);
				}

				break;

			case 2 : 

				if (temp instanceof Patient)
					{
						((Patient)temp).Doc_search(users);
					}

				else {
						((Doctor)temp).appointment_debrief();
				}

				break;

			case 3 : 

				temp.appointment_list();
				break;

			case 4 : 

				temp.change_info();
				break;

			case 5 : 
				System.out.println("Logging out, Goodbye !");

				break;
			}


	}
	public static User signup (char U,ArrayList<User> users)
	{
		User temp;
		
		Scanner std=new Scanner(System.in);
		String username;
		do {
		System.out.print("choose username : ");
		username=std.nextLine();
		}while (username_exists(username,users));

		System.out.print("choose password : ");
		String password=std.nextLine();
		System.out.print("Name : ");
		String name=std.nextLine();
		System.out.print("Last Name : ");
		String lastname=std.nextLine();
		System.out.print("email : ");
		String email=std.nextLine();
		System.out.print("Phone Number : ");
		String number=std.nextLine();
		
		
		
		if (U=='D')
		{
			System.out.print("office_adress : ");
			String office=std.nextLine();
			System.out.print("Speciality : ");
			String spec=std.nextLine();
			
			temp=new Doctor(name,lastname,email,number,username,password,office,spec);
		}else
		{
			temp=new Patient(name,lastname,email,number,username,password);
		}
				
		
		return temp;
	}

	public static User auth(String  input_password, String input_username, ArrayList<User> users)
	{
		
			
			for (int i=0; i<users.size();i++)
			{	
			if (input_username.equals(users.get(i).getUsername())&&input_password.equals(users.get(i).getpass()))
					{
					System.out.println("Acces granted welcome back !");
						return users.get(i);
					}
				
			
			}
			System.out.println("wrong info.");
				return null;
	}

	
public static boolean username_exists(String username, ArrayList<User> users)
{

		for (int i=0;i<users.size();i++)
		{
			if(users.get(i).getUsername().equals(username))
			{System.out.println("username already exists");
			return true;}
				
		}
	return false;

}
	

	
}







