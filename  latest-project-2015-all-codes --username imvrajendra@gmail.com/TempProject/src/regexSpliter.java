import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class regexSpliter {

	public static void main(String[] args) {
		Pattern pat = Pattern.compile("[a-zA-Z]{3}");
		Matcher match = pat.matcher("anddogcatandanddogandand");
		
		while(match.find()){
			System.out.print(" - "+match.group());
		}
	}

}
