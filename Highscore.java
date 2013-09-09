/*****************************************************
TNM040 - GUI project
Group 1:
Dag Hansson
Mathias Bergqvist
Henrik Gunnarsson
*****************************************************/
import java.util.*;
import java.io.*;

public class Highscore {

	private Vector<Person> highscoreLista; 
	
	//Skapar en tom lista med 10 platser i
    public Highscore() {
   		highscoreLista = new Vector<Person>(10);
    }
    
    //S�tter in ett nytt namn om den har tillr�ckligt med po�ng
    public void insList(String namnet, int po�ngen){
    	Person nyperson = new Person(namnet, po�ngen);
    	
    	for(int i=0; i<highscoreLista.size(); i++)
    	{
    		if(highscoreLista.get(i).getPo�ng() < nyperson.getPo�ng()){
    			highscoreLista.add(i,nyperson);
    			highscoreLista.remove(10);
    			break;
    		}
    		
    		else if(highscoreLista.get(i).getPo�ng() == nyperson.getPo�ng() && i!= 9){
    			highscoreLista.add(i+1,nyperson);
    			highscoreLista.remove(10);
    			break;
    		}	
    	}
    	
    	/*for(int k=0; k<highscoreLista.size(); k++){
    		System.out.println(highscoreLista.get(k).getNamn() + " " + highscoreLista.get(k).getPo�ng());
    	}*/
    }
    
    //Returnerar ett stringobjekt med hela listan
    public String getList() {
    	String highscore = "-------Topplista-------\n";
   		for(int i=0; i<highscoreLista.size(); i++)
    	{
    		highscore += highscoreLista.get(i).getPo�ng() + " po�ng  -  " + highscoreLista.get(i).getNamn() + "\n";
    	}
    return highscore;
    }
    
    //KOllar om en person kan komma med i listan
    public boolean getInList(int po�ng)
    {
    	boolean kommerIn = false;
    	for(int i=0; i<highscoreLista.size(); i++){
    		if(highscoreLista.get(i).getPo�ng() < po�ng){
    			kommerIn = true;
    			break;
    		}
    	}
    	return kommerIn;
    }
    
    //Sparar listan
    public void saveList() {	
    
	    try{
	    	PrintWriter outfile= new PrintWriter(new BufferedWriter(new FileWriter("Highscore.txt")));
	    	for(int i=0; i<highscoreLista.size(); i++){
	    		outfile.println(highscoreLista.get(i).getPo�ng() +" "+ highscoreLista.get(i).getNamn());
	    	}
	    	outfile.close();
	    }
	    catch(FileNotFoundException a)
	    {
	    	System.out.println("Filen hittades inte!");
	    }
	    catch(IOException e)
	    {
	    	System.out.println("IOException");
	    }	
    }
    
    //L�ser in listan fr�n textfilen och l�gger in den i vektorn
    public void readList(){
    	highscoreLista.clear();
    	try{
    		Scanner sc = new Scanner (new File("Highscore.txt"));
			while (sc.hasNext()){
				int hgscpo�ng = sc.nextInt();
				String hgscnamn = sc.nextLine();
				
				Person person = new Person(hgscnamn, hgscpo�ng);
				highscoreLista.add(person);
			}
		sc.close();
		}
		catch(FileNotFoundException a)
		{
			System.out.println("hittade inte filen!");
		}
    }    
}