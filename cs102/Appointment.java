package app;
import java.util.ArrayList;

public class Appointment {

	private int id;
	public int getId() {
		return id;
	}

		

	private String Date;
	private String MedicalCase;
	private String Diagnosis;
	private String prescription;
	private boolean urgent=false;
	private Doctor Doc;
	private Patient pat;
	public Patient getPat() {
		return pat;
	}


	private boolean p_confirm=false;
	private boolean d_confirm=false; 
	
	
	private static int count=0;
	
	public Appointment() {id=++count;}
	
	public Appointment(String Date, String MedicalCase,String Diagnosis,String prescription,boolean urgent,Doctor Doc,Patient pat, boolean p_confirm,boolean d_confirm) {
		id=++count;
		this.Date=Date;
		this.MedicalCase=MedicalCase;
		this.Doc=Doc;
		this.pat=pat;
		this.Diagnosis=Diagnosis;
		this.prescription=prescription;
		this.urgent=urgent;
		this.p_confirm=p_confirm;
		this.d_confirm=d_confirm;
	
	}
	
	public boolean getP_confirm()
	{
		return p_confirm;
	}

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
	
	public String FiletoString()
	{
		return id+"#"+Date+"#"+MedicalCase+"#"+Diagnosis+"#"+prescription+"#"+urgent+"#"+Doc.getId()+"#"+pat.getId()+"#"+p_confirm+"#"+d_confirm;      
	}


	public String toString()
	{
		return "Appointment id : "+id+" | Patient : "+pat.getName()+" "+pat.getLastName()+"| Doctor : "+Doc.getLastName()+" | Date : "+Date+" | Medical Case : "+MedicalCase+"| Urgent : "+urgent+"| patient confirmation : "+p_confirm+"| Doctor confirmation : "+d_confirm+" | Doctor's diagnosis : "+Diagnosis+" |  Prescription : "+prescription ;      
	}
	
}
