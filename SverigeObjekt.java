/*****************************************************
TNM040 - GUI project
Group 1:
Dag Hansson
Mathias Bergqvist
Henrik Gunnarsson
*****************************************************/
import java.util.*;

public class SverigeObjekt {
	
	//instansvariabler
	private int nummer;
	private String namn;

	//konstruktor
	public SverigeObjekt(Scanner infil)
	{
		nummer  = infil.nextInt();
		namn  = infil.next();
	}
	
	//instansmetoder
	public String getNamn()
	{
		return namn;
	}
	
	public int getNummer()
	{
		return nummer;
	}
	
}