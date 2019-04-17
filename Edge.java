
public class Edge extends Predicate{

	String v1;
	String v2;
	String edgeName;
	String str = "Edge";
	
	
	public Edge(String s) {
		super();
		this.toParse = new String(s);
		this.type = 2;
		int commaIndex = toParse.indexOf(',');
		int secondCommaIndex = toParse.indexOf(',', commaIndex+1);
		this.edgeName = new String(toParse.substring(0, commaIndex));
		this.v1 = new String(toParse.substring(commaIndex+1,secondCommaIndex));
		this.v2 = new String(toParse.substring(secondCommaIndex+1,toParse.length()));
	}

	@Override
	void print() {
		System.out.print(str+"("+edgeName+","+v1+","+v2+")");

	}

	@Override
	void update(String a1, String a2) {
	
		if(v1.equals(a1))
			this.v1 = new String(a2);
		if(v2.equals(a1))
			this.v2 = new String(a2);
		if(edgeName.equals(a1))
			this.edgeName = new String(a2);
		
		this.toParse = new String(edgeName+","+v1+","+v2);		
	}

	@Override
	boolean canResolve(Predicate other) {
		if(other.type==2) //is an Edge
			if(v1.equals(((Edge)other).v1) && v2.equals(((Edge)other).v2) && edgeName.equals(((Edge)other).edgeName))
				if((false_value && !other.false_value) || (!false_value && other.false_value))
					return true;
			
		return false;
	}

	

}
