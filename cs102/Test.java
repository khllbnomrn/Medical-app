package app;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
public class Test {
	
	
	public static void main(String[] args) {
		Scanner std=new Scanner(System.in);
		boolean login=false;
		int user_in=0;
		Files file_init = new Files();
		File file;
		int n=0;
		User[] users= new User[2];
		User temp=new Doctor("Name","last name","email","numer","username","password","office","spec");
		User temp2=new Doctor("name","last name","email","numer","username","password","office","spec");
		file_init.createfile("Users.txt");
		file_init.createfile("appointments.txt");
		users[0]=temp;
		users[1]=temp2;
		file_init.writefile("Users.txt", users);
		
		String[] user_info=file_init.ReadFile("Users.txt");
		 //String_user(user_info);
		

		
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
					temp=signup('D');
					break;
					
				case 2 : 
					temp=signup('P');
					
					break;

					}
				//users[i]=temp;	
				login=true;
				break;
				
			case 2 :	
				
				
				String answer="";
				boolean exit=false;
				do {
					System.out.print("Username : ");
					String username=std.nextLine();
					System.out.print("Password : ");
					String password=std.nextLine();
				
					/*look for user_id in array and assign it to temp*/
					
				if (temp.auth(password,username))
				{	
					exit=true;
					login=true;
				}
				else {
					System.out.print("would you like to try again? (Y/N)");
					answer=std.nextLine();
				}
				
				if (answer=="N")
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
		

		
		
		
		
		
		
		
}
	public static User[] String_user(String [] user_info)
	{
		User [] users=new User[user_info.length];
		for (int i=0; i<user_info.length;i++)
		{
			if (user_info[i].charAt(0)=='D')
			{
				users[i]=new Doctor();
			}
			else { users[i]=new Patient();}
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
	

	
}







