
public class OK extends Predicate{
	
	String edgeName;
	String v1;
	String v2;
	String s;
	String str = "OK";
	
	public OK(String s) {
		super();
		this.toParse = new String(s);
		this.type = 12;
		int commaIndex = toParse.indexOf(',');
		int secondCommaIndex = toParse.indexOf(',', commaIndex+1);
		int thirdCommaIndex = toParse.indexOf(',', secondCommaIndex+1);
		this.edgeName = new String(toParse.substring(0, commaIndex));
		this.v1 = new String(toParse.substring(commaIndex+1,secondCommaIndex));
		this.v2 = new String(toParse.substring(secondCommaIndex+1,thirdCommaIndex));
		this.s = new String(toParse.substring(thirdCommaIndex+1,toParse.length()));
	}

	@Override
	void print() {
		System.out.print(str+"("+edgeName+","+v1+","+v2+","+s+")");
	}

	@Override
	void update(String a1, String a2) {
		if(v1.equals(a1))
			this.v1 = new String(a2);
		if(v2.equals(a1))
			this.v2 = new String(a2);
		if(edgeName.equals(a1))
			this.edgeName = new String(a2);
		if(s.equals(a1))
			this.s = new String(a2);
		
		this.toParse = new String(edgeName+","+v1+","+v2+","+s);
	}

	@Override
	boolean canResolve(Predicate other) {
		if(other.type==12) //is an OK
			if(v1.equals(((OK)other).v1) && v2.equals(((OK)other).v2) && edgeName.equals(((OK)other).edgeName) && s.equals(((OK)other).s))
				if((false_value && !other.false_value) || (!false_value && other.false_value))
					return true;
		return false;
	}

	

}
