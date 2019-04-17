
public class Loc extends Predicate{
	String v;
	String s;
	String str = "Loc";
	
	public Loc(String s) {
		super();
		this.toParse = new String(s);
		this.type = 1;
		int commaIndex = toParse.indexOf(',');
		this.v = new String(toParse.substring(0, commaIndex));
		this.s = new String(toParse.substring(commaIndex+1, toParse.length()));
	}


	@Override
	void print() {
		System.out.print(str+"("+v+","+s+")");
	}

	@Override
	void update(String a1, String a2) {
		if(v.equals(a1))
			this.v = new String(a2);
		if(s.length()>10 && s.contains("Result")) {
			int bracket = s.indexOf(')');
			String traverseEdge = new String(s.substring(16, bracket));

			String oldSituation = new String(s.substring(bracket+2,s.length()-1));

			String tmp = null;
			boolean situationChanged = false;
			
			if(traverseEdge.equals(a1)) {
				tmp = new String(s.substring(0,16)+a2+s.substring(bracket, s.length()));
			}

			if(oldSituation.equals(a1)) {
				situationChanged = true;
				if(tmp==null)
					this.s = new String(s.substring(0,bracket+2)+a2+")");
				else {
					int tmpBracket = tmp.indexOf(')');
					this.s = new String(tmp.substring(0,tmpBracket+2)+a2+")");
				}
					
			}
			if(!situationChanged && tmp!=null) {
				this.s = tmp;
			}
				
		}
		else if(s.equals(a1))
			this.s = new String(a2);
		this.toParse = new String(v+","+s);
	}

	@Override
	boolean canResolve(Predicate other) {
		if(other.type==1) //is a Loc
			if(v.equals(((Loc)other).v) && s.equals(((Loc)other).s))
				if((false_value && !other.false_value) || (!false_value && other.false_value))
					return true;
		return false;
	}
}
