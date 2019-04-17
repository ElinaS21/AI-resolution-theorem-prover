
public class Shelter extends Predicate{
	String v;
	String str = "Shelter";
	
	public Shelter(String s) {
		super();
		this.toParse = new String(s);
		this.type = 3;
		this.v = new String(toParse.substring(0, toParse.length()));

	}


	@Override
	void print() {
		System.out.print(str+"("+v+")");
	}

	@Override
	void update(String a1, String a2) {
		if(v.equals(a1))
			this.v = new String(a2);
		
		this.toParse = new String(v);

	}

	@Override
	boolean canResolve(Predicate other) {
		if(other.type==3) //is a Shelter
			if(v.equals(((Shelter)other).v))
				if((false_value && !other.false_value) || (!false_value && other.false_value))
					return true;
		return false;
	}

}
