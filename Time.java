
public class Time extends Predicate{
	String t;
	String s;
	String str = "Time";
	
	public Time(String s) {
		super();
		this.toParse = new String(s);
		this.type = 9;
		int commaIndex = toParse.indexOf(',');
		this.t = new String(toParse.substring(0, commaIndex));
		this.s = new String(toParse.substring(commaIndex+1, toParse.length()));
	}

	@Override
	void print() {
		System.out.print(str+"("+t+","+s+")");
	}

	@Override
	void update(String a1, String a2) {
		if(t.contains("+")) {
			int plusIndex = t.indexOf('+');
			String firstHalf = new String(t.substring(0, plusIndex));
			String secondHalf = new String(t.substring(plusIndex+1, t.length()));
			
			if(firstHalf.equals(a1)) {
				this.t = new String(a2+"+"+secondHalf);
				firstHalf = a2;
			}
			if(secondHalf.equals(a1)) {
				this.t = new String(firstHalf+"+"+a2);
				secondHalf = a2;
			}
			try {
				int firstInt = Integer.parseInt(firstHalf);
				
				int secondInt = Integer.parseInt(secondHalf);

				int sum = (firstInt+secondInt);
				this.t = String.valueOf(sum);
			}
			catch (Exception e) {
			}

		}
		else if(t.equals(a1))
			this.t = new String(a2);
		
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
		
		this.toParse = new String(t+","+s);
	}

	@Override
	boolean canResolve(Predicate other) {
		if(other.type==9) //is an Time
			if(t.equals(((Time)other).t) && s.equals(((Time)other).s))
				if((false_value && !other.false_value) || (!false_value && other.false_value))
					return true;
		return false;
	}

	

}
