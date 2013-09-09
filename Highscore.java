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
    
    //Sätter in ett nytt namn om den har tillräckligt med poäng
    public void insList(String namnet, int poängen){
    	Person nyperson = new Person(namnet, poängen);
    	
    	for(int i=0; i<highscoreLista.size(); i++)
    	{
    		if(highscoreLista.get(i).getPoäng() < nyperson.getPoäng()){
    			highscoreLista.add(i,nyperson);
    			highscoreLista.remove(10);
    			break;
    		}
    		
    		else if(highscoreLista.get(i).getPoäng() == nyperson.getPoäng() && i!= 9){
    			highscoreLista.add(i+1,nyperson);
    			highscoreLista.remove(10);
    			break;
    		}	
    	}
    	
    	/*for(int k=0; k<highscoreLista.size(); k++){
    		System.out.println(highscoreLista.get(k).getNamn() + " " + highscoreLista.get(k).getPoäng());
    	}*/
    }
    
    //Returnerar ett stringobjekt med hela listan
    public String getList() {
    	String highscore = "-------Topplista-------\n";
   		for(int i=0; i<highscoreLista.size(); i++)
    	{
    		highscore += highscoreLista.get(i).getPoäng() + " poäng  -  " + highscoreLista.get(i).getNamn() + "\n";
    	}
    return highscore;
    }
    
    //KOllar om en person kan komma med i listan
    public boolean getInList(int poäng)
    {
    	boolean kommerIn = false;
    	for(int i=0; i<highscoreLista.size(); i++){
    		if(highscoreLista.get(i).getPoäng() < poäng){
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
	    		outfile.println(highscoreLista.get(i).getPoäng() +" "+ highscoreLista.get(i).getNamn());
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
    
    //Läser in listan från textfilen och lägger in den i vektorn
    public void readList(){
    	highscoreLista.clear();
    	try{
    		Scanner sc = new Scanner (new File("Highscore.txt"));
			while (sc.hasNext()){
				int hgscpoäng = sc.nextInt();
				String hgscnamn = sc.nextLine();
				
				Person person = new Person(hgscnamn, hgscpoäng);
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