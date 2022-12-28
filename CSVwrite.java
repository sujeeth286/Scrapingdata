package Sam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CSVwrite 
{
	public static void main(String[] args) throws IOException 
	{
		//initiate csvwriter class
		CSVWriter writer = new CSVWriter(new FileWriter("csvwrite//sample1.csv"));
		
		//write data into csv
		String set1[]= {"country","capital","weather"};		
		String set2[]={"India","NewDelhi","tropical"};
		String set3[]= {"Sweden","Stockholm","Arctic"};
		
		//using writenext method
		writer.writeNext(set1);
		writer.writeNext(set2);
		writer.writeNext(set3);
		
		//flush data into csv
		writer.flush();
		System.out.println("data is entered");
		
		//using writeall method
		CSVWriter writer1 = new CSVWriter(new FileWriter("csvwrite//sample2.csv"));
		
		String set4[]= {"name","company","designation"};
		String set5[]= {"Nikitha","jio","qa"};
		String set6[]= {"Bhoomika","TCS","Devops Engineer"};
		String set7[]= {"Harshitha","Concave","BA"};
		List setlist=new ArrayList();
		setlist.add(set4);
		setlist.add(set5);
		setlist.add(set6);
		setlist.add(set7);
		
		writer1.writeAll(setlist);
		writer1.flush();
		System.out.println("data is entered again");
		

	}

}
