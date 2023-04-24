package app;
import java.util.Scanner;
import java.util.ArrayList;
public abstract class User {
	
	Scanner std=new Scanner(System.in);
	protected String Name;
	protected String LastName;
	protected String email;
	protected String Number;
	protected int id;
	protected String username;
	protected String password;
	protected ArrayList<Appointment> appointments=new ArrayList<Appointment>();
	private static int count=0;
	public User() {id=++count;}
	
	
	public abstract int menu();
	
	public abstract void change_info();
	
		
	
	public void appointment_list() 
	{
		for (int i=0; i<appointments.size(); i++)
		{
			System.out.println(appointments.get(i).toString());
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
		
		appointments.add(a);
		
	}
	
	
	public void setNumber(String Number)
	
	{
		this.Number=Number;		
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
		return id+"#"+Name+"#"+LastName+"#"+email+"#"+Number+"#"+username+"#"+password;
	}

	public String toString() 
	{
		return id+" "+Name+" "+LastName+" "+email+" "+Number;
	}
}
