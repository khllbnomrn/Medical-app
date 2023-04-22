package app;
import java.util.Scanner;
public abstract class User {
	
	Scanner std=new Scanner(System.in);
	protected String Name;
	protected String LastName;
	protected String email;
	protected String Number;
	protected int id;
	protected String username;
	protected String password;
	int n=0;
	protected Appointment[] appointments=new Appointment[n];
	private static int count=0;
	public User() {id=++count;}
	
	
	public abstract int menu();
	
	public abstract void change_info();
	
		
	
	public void appointment_list() 
	{
		for (int i=0; i<appointments.length; i++)
		{
			System.out.println(appointments[i].toString());
		}
	}
	
	public User(String Name, String LastName, String email, String Number,String username, String password)
	{
		this.username=username;
		this.password=password;
		this.Name=Name;
		this.LastName=LastName;
		this.Number=Number;
		this.email=email;
		id=++count;	
	}
	
	public void add_appointmentlist(Appointment a)
	{
		
		
		Appointment[] appointment_aux=new Appointment[n+1];
		for (int i=0; i<n ;i++)
		{
			appointment_aux[i]=appointments[i];
			appointment_aux[n]=a;					
		}
		for (int i=0; i<=n ;i++)
		{
			appointments[i]=appointment_aux[i];
		}
		n++;
	}
	
	
	public void setNumber(String Number)
	
	{
		this.Number=Number;		
	}
	
	public boolean auth(String  input_password, String input_username)
	{
		
			
			
			if (input_username==username&&input_password==password)
					{
					System.out.println("Acces granted welcome back !");
						return true;
					}
			else 
			{
				System.out.println("wrong info.");
				return false;
			
			}
	}
	
	
	public String getuser() {return username;}
	public String getpass() {return password;}
	
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
public void setEmail(String email)
	
	{
		
		this.email=email;
		
	}
	
	public String FiletoString() 
	{
		return id+"#"+Name+"#"+LastName+"#"+email+"#"+Number+"#"+password+"#"+username;
	}

	public String toString() 
	{
		return id+" "+Name+" "+LastName+" "+email+" "+Number;
	}
}
