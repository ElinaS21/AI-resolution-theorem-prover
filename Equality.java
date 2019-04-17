
public class Equality extends Predicate{
	String n1;
	String n2;
	String str = "Equality";
	
	public Equality(String s) {
		super();
		this.toParse = new String(s);
		this.type = 13;
		int eqIndex = toParse.indexOf(',');
		this.n1 = new String(toParse.substring(0, eqIndex));
		this.n2 = new String(toParse.substring(eqIndex+1,toParse.length()));
	}


	@Override
	void print() {
		System.out.print(str+"("+n1+","+n2+")");

	}

	@Override
	void update(String a1, String a2) {
		if(n1.contains("+")) {
			int plusIndex = n1.indexOf('+');
			String firstHalf = new String(n1.substring(0, plusIndex));
			String secondHalf = new String(n1.substring(plusIndex+1, n1.length()));
			
			if(firstHalf.equals(a1)) {
				this.n1 = new String(a2+"+"+secondHalf);
				firstHalf = a2;
			}
			if(secondHalf.equals(a1)) {
				this.n1 = new String(firstHalf+"+"+a2);
				secondHalf = a2;
			}
			try {
				int firstInt = Integer.parseInt(firstHalf);
				
				int secondInt = Integer.parseInt(secondHalf);

				int sum = (firstInt+secondInt);
				this.n1 = String.valueOf(sum);
			}
			catch (Exception e) {
			}

		}
		else if(n1.equals(a1))
			this.n1 = new String(a2);
		
		if(n2.equals(a1))
			this.n2 = new String(a2);
		
		this.toParse = new String(n1+","+n2);	}

	@Override
	boolean canResolve(Predicate other) {
		if(other.type==13) //is an Equality
			if(n1.equals(((Equality)other).n1) && n2.equals(((Equality)other).n2))
				if((false_value && !other.false_value) || (!false_value && other.false_value))
					return true;
		
		return false;
	}



}
