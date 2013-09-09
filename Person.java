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
	private int poäng;

	//konstruktor
    public Person(String namnet, int poängen) {
    namn = namnet;
    poäng = poängen;
    }
    
    //instansmetoder
    public String getNamn()
    {
    	return namn;
    }

    public int getPoäng()
    {
    	return poäng;
    }
    
}