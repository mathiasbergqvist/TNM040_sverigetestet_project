/*****************************************************
TNM040 - GUI project
Group 1:
Dag Hansson
Mathias Bergqvist
Henrik Gunnarsson
*****************************************************/
public class Person {
	
	//instansvariabler
	private String namn;
	private int po�ng;

	//konstruktor
    public Person(String namnet, int po�ngen) {
    namn = namnet;
    po�ng = po�ngen;
    }
    
    //instansmetoder
    public String getNamn()
    {
    	return namn;
    }

    public int getPo�ng()
    {
    	return po�ng;
    }
    
}