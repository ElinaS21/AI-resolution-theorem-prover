
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Parser {
	
	Predicate predicate;
	boolean negative;
	
	public void parse() {
		File file = new File("kb.txt");
		try(BufferedReader br = new BufferedReader(new FileReader(file)); )
		{
			String line;
			while ((line = br.readLine()) != null){
				LinkedList<Predicate> predicateList = new LinkedList<Predicate>();
				int startIndex = 0;
				int endIndex = 0;
				while(endIndex<line.length()+1){
					boolean negative=false;

					if(endIndex<(line.length()-1) && !line.substring(endIndex,endIndex+2).equals("or")) { 
					}
				
					if(endIndex>=line.length()-1||line.substring(endIndex,endIndex+2).equals("or")){ 
						if(!(endIndex>=line.length()-1))
							endIndex--;
					
						if(line.charAt(startIndex)=='~') {
							negative=true;
							startIndex++;
						}
						if(line.substring(startIndex,startIndex+3).equals("Loc")) {

							predicate = new Loc(line.substring(startIndex+4, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+4).equals("Edge")) {

							predicate = new Edge(line.substring(startIndex+5, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+7).equals("Shelter")) {

							predicate = new Shelter(line.substring(startIndex+8, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+6).equals("Weight")) {

							predicate = new Weight(line.substring(startIndex+7, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+8).equals("Deadline")) {

							predicate = new Deadline(line.substring(startIndex+9, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+8).equals("Carrying")) {

							predicate = new Carrying(line.substring(startIndex+9, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+4).equals("Safe")) {

							predicate = new Safe(line.substring(startIndex+5, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+2).equals("At")) {

							predicate = new At(line.substring(startIndex+3, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+4).equals("Time")) {

							predicate = new Time(line.substring(startIndex+5, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+2).equals("OK")) {

							predicate = new OK(line.substring(startIndex+3, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						else if(line.substring(startIndex,startIndex+8).equals("Equality")) {

							predicate = new Equality(line.substring(startIndex+9, endIndex));
							predicate.false_value = negative;
							predicateList.add(predicate);
							endIndex+=3;
							startIndex = endIndex;
							
						}
						
					}
					endIndex++;	
				}
				main.kb.add(predicateList);
			}
		}
		catch(IOException e){
			System.out.println("Unable to open file");
			e.printStackTrace();
		}
	}

}
