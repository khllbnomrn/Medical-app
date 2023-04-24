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

		
		//testing values User temp=new Doctor("Name","last name","email","numer","username","password","office","spec");users.add(temp);
		
		//testing values User temp2=new Doctor("name","last name","email","numer","username","password","office","spec");users.add(temp2);
		file_init.createfile("Users.txt");
		file_init.createfile("appointments.txt");
		
		ArrayList<String> arr=file_init.ReadFile("Users.txt");

		ArrayList<User> users= new ArrayList<User>();

		

		if (file.length()!=0)
		{
			users=String_user(arr);
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
					users.add(signup('D'));
					break;
					
				case 2 : 
					users.add(signup('P'));
					
					break;

					}
					
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
			
				
					User temp=new getuser(username,temp);

					System.out.print("Password : ");
					String password=std.nextLine();
				
				if (auth(password,temp)
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
		
		
		System.out.println("what would you like to do next?");
			System.out.println(temp.menu());
		

		
		file_init.writefile("Users.txt", users);
		
		
		
		
		
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

	public static User signup (char U)
	{
		User temp;
		
		Scanner std=new Scanner(System.in);
		
		System.out.print("choose username : ");
		String username=std.nextLine();
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

	public static boolean auth(String  input_password, String input_username, ArrayList<User> users)
	{
		
			
			for (int i=0; i<users.size();i++)
			{	
			if (input_username.equals(users.get(i).username)&&input_password.equals(users.get(i).password))
					{
					System.out.println("Acces granted welcome back !");
						return true;
					}
				
			
			}
			System.out.println("wrong info.");
				return false;
	}

	public static User getuser()
	{
		
	}

	
}







