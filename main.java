
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	static LinkedList<LinkedList<Predicate>> kb;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		kb = new LinkedList<LinkedList<Predicate>>();
		
	
		//add axioms and Q' to kb		
		Parser parser = new Parser();
		parser.parse();
		
		for(int i=0; i<kb.size(); i++) {
			System.out.print(i+".   ");
			for(int j=0; j<kb.get(i).size(); j++){
				if(kb.get(i).get(j).false_value)
					System.out.print("~");
				kb.get(i).get(j).print();
				if(j!=kb.get(i).size()-1)
					System.out.print(" V ");
			}
			System.out.println();
		}
		
		boolean run = true;
		while(run) {
			
			resolve();

			System.out.print((kb.size()-1)+".   ");
			for(int i=0; i<kb.get(kb.size()-1).size(); i++){
				if(kb.get(kb.size()-1).get(i).false_value)
					System.out.print("~");
				kb.get(kb.size()-1).get(i).print();
				if(i!=kb.get(kb.size()-1).size()-1)
					System.out.print(" V ");
			}
			System.out.println();
			
			if(kb.get(kb.size()-1).isEmpty())//stop if the last added close is empty
				run =false;
			
		}//while(run)
		
	}//main

	public static void resolve() {
		
		System.out.print("Please enter first line to resolve:  ");
		int first = sc.nextInt();
		System.out.print("Please enter second line to resolve:  ");
		int second = sc.nextInt();
		System.out.print("Please enter unifier (ex. t/0,s/S0):  ");
		String unifier = sc.next();
		
		LinkedList<Predicate> l1 = new LinkedList<Predicate>();
		for(int i=0;i<kb.get(first).size();i++) {
			Predicate p = null;
			if(kb.get(first).get(i).type==1) {//Loc
				p = new Loc(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==2) {//Edge
				p = new Edge(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==3) {
				p = new Shelter(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==4) {
				p = new Weight(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==5) {
				p = new Deadline(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==6) {
				p = new Carrying(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==7) {
				p = new Safe(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==8) {
				p = new At(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==9) {
				p = new Time(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==12) {
				p = new OK(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			else if(kb.get(first).get(i).type==13) {
				p = new Equality(kb.get(first).get(i).toParse);
				p.false_value=kb.get(first).get(i).false_value;
			}
			l1.add(p);
		}
		
		LinkedList<Predicate> l2 = new LinkedList<Predicate>();//the same as l1
		for(int i=0;i<kb.get(second).size();i++) {
			Predicate p = null;
			if(kb.get(second).get(i).type==1) {//Loc
				p = new Loc(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==2) {//Edge
				p = new Edge(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==3) {
				p = new Shelter(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==4) {
				p = new Weight(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==5) {
				p = new Deadline(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==6) {
				p = new Carrying(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==7) {
				p = new Safe(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==8) {
				p = new At(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==9) {
				p = new Time(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==12) {
				p = new OK(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			else if(kb.get(second).get(i).type==13) {
				p = new Equality(kb.get(second).get(i).toParse);
				p.false_value=kb.get(second).get(i).false_value;
			}
			l2.add(p);
		}
		
		LinkedList<Predicate> toAdd = new LinkedList<Predicate>();
		
		int unifierCounter=1;
		for(int i=0;i<unifier.length();i++) {
			if (unifier.charAt(i)==',')
				unifierCounter++;
		}
			
		
		int startIndex = 0;
		while(unifierCounter>1){//not last
			int commaIndex = unifier.indexOf(',', startIndex);
			int slashIndex = unifier.indexOf('/', startIndex);
		
			String a1 = unifier.substring(startIndex, slashIndex);
			String a2 = unifier.substring(slashIndex+1, commaIndex);
			
			for(int i=0;i<l1.size();i++) {//change in lists
				l1.get(i).update(a1,a2);
			}
			for(int i=0;i<l2.size();i++) {
				((Predicate)l2.get(i)).update(a1,a2);
			}
				
			
			startIndex=commaIndex+1;
			unifierCounter--;
		}
		
		//last
		int slashIndex = unifier.indexOf('/', startIndex);
		String a1 = unifier.substring(startIndex, slashIndex);
		String a2 = unifier.substring(slashIndex+1, unifier.length());
		
		for(int i=0;i<l1.size();i++) { //change in lists
			((Predicate)l1.get(i)).update(a1,a2);
		}
		for(int i=0;i<l2.size();i++)
			((Predicate)l2.get(i)).update(a1,a2);

		//the resolution
		int inL1;
		int inL2=0;
		loop:{
		for(inL1=0;inL1<l1.size();inL1++) 
			for(inL2=0;inL2<l2.size();inL2++) 
				if(((Predicate)l1.get(inL1)).canResolve(((Predicate)l2.get(inL2))))
					 break loop;
		}
		for(int i=0;i<l1.size();i++)
			if(i!=inL1)
				toAdd.add(l1.get(i));
		for(int i=0;i<l2.size();i++)
			if(i!=inL2)
				toAdd.add(l2.get(i));
		kb.add(toAdd);
	}
	
	
}

abstract class Predicate{
	
	public boolean false_value;
	public int type;
	public String toParse;
	abstract void print();
	abstract void update(String a1,String a2);//change all the occurrences of a1 to a2
	abstract boolean canResolve(Predicate other);
}







