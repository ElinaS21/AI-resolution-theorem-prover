
public class Deadline extends Predicate{
	String d;
	String str = "Deadline";
	
	public Deadline(String s) {
		super();
		this.toParse = new String(s);
		this.type = 5;
		this.d = new String(toParse.substring(0, toParse.length()));
	}

	@Override
	void print() {
		System.out.print(str+"("+d+")");
	}

	@Override
	void update(String a1, String a2) {
		if(d.equals(a1))
			this.d = new String(a2);
		
		this.toParse = new String(d);		

	}

	@Override
	boolean canResolve(Predicate other) {
		if(other.type==5) //is a Deadline
			if(d.equals(((Deadline)other).d))
				if((false_value && !other.false_value) || (!false_value && other.false_value))
					return true;
		return false;
	}

	
}
