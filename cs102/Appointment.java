package app;

public class Appointment {

	private int id;
	private String Date;
	private String MedicalCase;
	private String Diagnosis;
	private String prescription;
	private boolean urgent=false;
	private Doctor Doc;
	private Patient pat;
	private boolean p_confirm=false;
	private boolean d_confirm=false; 
	
	
	private static int count=0;
	
	public Appointment() {id=++count;}
	
	public void setP_confirm(boolean c)
	{
		p_confirm=c;
	}
	
	public void setD_confirm(boolean c)
	{
		d_confirm=c;
	}
	
	public Appointment(Doctor Doc, String Date, String MedicalCase, Patient pat)
	{
		this.Date=Date;
		this.MedicalCase=MedicalCase;
		this.Doc=Doc;
		this.pat=pat;
		id=++count;
	}
	
	public Appointment(String Date, Doctor Doc) {
		this.Date=Date;
		this.Doc=Doc;
		d_confirm=true;
		id=++count;
	}
	
	public void setUrgency(boolean urgent)
	{
		this.urgent=urgent;	
	}
	
	public void setDate(String Date)
	{
		this.Date=Date;
	}
	
	public void setDiagnosis(String Diagnosis) {
		
		this.Diagnosis=Diagnosis;
	}
	
	public void setPrescription(String prescription) {
		
		this.prescription=prescription;
	}
	
	public String toString()
	{
		return "Date : "+Date+"/nMedical Case : "+MedicalCase+" | Doctor's diagnosis : "+Diagnosis+"\nPrescription : "+prescription;      
	}
	
}
