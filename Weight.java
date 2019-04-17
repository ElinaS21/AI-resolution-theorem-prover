
public class Weight extends Predicate{
	String edgeName;
	String w;
	String str = "Weight";
	
	public Weight(String s) {
		super();
		this.toParse = new String(s);
		this.type = 4;
		int commaIndex = toParse.indexOf(',');
		this.edgeName = new String(toParse.substring(0, commaIndex));
		this.w = new String(toParse.substring(commaIndex+1, toParse.length()));
	}

	@Override
	void print() {
		System.out.print(str+"("+edgeName+","+w+")");

	}

	@Override
	void update(String a1, String a2) {
		if(w.equals(a1))
			this.w = new String(a2);
		if(edgeName.equals(a1))
			this.edgeName = new String(a2);
		
		this.toParse = new String(edgeName+","+w);

	}

	@Override
	boolean canResolve(Predicate other) {
		if(other.type==4) //is an Edge
			if(w.equals(((Weight)other).w) && edgeName.equals(((Weight)other).edgeName))
				if((false_value && !other.false_value) || (!false_value && other.false_value))
					return true;
			
		return false;
	}

	

}
