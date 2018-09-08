import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	static Pattern pattern;
	static Matcher matcher;

	public static int add(String source) {
		int summOfNumbers = 0;
		StringBuffer sourseTest = new StringBuffer();
		sourseTest.append(source);

		if (source == null || source == "") {
			return 0;
		}
		// ////// kata9
		pattern = Pattern.compile("[-]+[\\d]");
		matcher = pattern.matcher(sourseTest);
		if (matcher.find()) {
			throw new NumberFormatException();
		}
		// ///////////// kata 5
		pattern = Pattern.compile("[//]+[\\d+]+[\n]+[\\d]+[\\d]+[\\d]");
		matcher = pattern.matcher(sourseTest);
		if (matcher.matches()) {
			throw new NumberFormatException();
		}

		source = source.replaceAll("[\\D]", ",");
		String[] arrayNumbers = source.split("[,]");
		for (String i : arrayNumbers) {
			if (!i.equals("") && Integer.parseInt(i) <= 1000) {
				summOfNumbers += Integer.parseInt(i);

			}
		}
		return summOfNumbers;
	}

	public static int add(String source1, String... sourceN) {
		int summ = add(source1);
		for (int i = 0; i < sourceN.length; i++) {
			summ += add(sourceN[i]);
		}
		return summ;
	}
}
