import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void kata1() {
		int resours = StringCalculator.add(null);
		assertEquals(resours, 0);
		resours = StringCalculator.add("");
		assertEquals(resours, 0);
		resours = StringCalculator.add("1");
		assertEquals(resours, 1);
		resours = StringCalculator.add("1,2");
		assertEquals(resours, 3);
		resours = StringCalculator.add("4,");
		assertEquals(resours, 4);
	}

	@Test
	public void kata2() {
		int resours = StringCalculator.add("1,2,3");
		assertEquals(resours, 6);
		resours = StringCalculator.add("1,1,1,1");
		assertEquals(resours, 4);
		resours = StringCalculator.add("1,2");
		assertEquals(resours, 3);
		resours = StringCalculator.add("1,2");
		assertEquals(resours, 3);
		resours = StringCalculator.add("11,22,33");
		assertEquals(resours, 66);
	}

	@Test
	public void kata3() {
		int resours = StringCalculator.add("1\n2,3");
		assertEquals(resours, 6);
		resours = StringCalculator.add("4\n5\n6");
		assertEquals(resours, 15);
		resours = StringCalculator.add("77\n");
		assertEquals(resours, 77);
	}

	@Test
	public void kata4() {
		int resours = StringCalculator.add("1,1001");
		assertEquals(resours, 1);
		resours = StringCalculator.add("1002\n2");
		assertEquals(resours, 2);
		resours = StringCalculator.add("1,1000");
		assertEquals(resours, 1001);
		resours = StringCalculator.add("1000,1000");
		assertEquals(resours, 2000);
		resours = StringCalculator.add("1001\n1001");
		assertEquals(resours, 0);

	}

	@Test(expected = NumberFormatException.class)
	public void kata5() {
		int resours = StringCalculator.add("//;\n1; 2");
		assertEquals(resours, 3);
		resours = StringCalculator.add("//*\n2,3");
		assertEquals(resours, 5);
		resours = StringCalculator.add("//#\n3#4");// <-- ошибка в условии
		assertEquals(resours, 7);
		resours = StringCalculator.add("//1\n111");
		resours = StringCalculator.add("//;\n1#2");// <-- ошибка в условии

	}

	@Test
	public void kata6() {
		int resours = StringCalculator.add("//[***]\n1 *** 2 *** 3");
		assertEquals(resours, 6);
		resours = StringCalculator.add("//[xy]\n3xy4xy5xy8");
		assertEquals(resours, 20);
	}

	@Test
	public void kata7() {
		int resours = StringCalculator.add("//[*][%]\n1*2%3");
		assertEquals(resours, 6);
		resours = StringCalculator.add("//[&&][|||]\n3|||2&&3");
		assertEquals(resours, 8);
	}

	@Test
	public void kata8() {
		int resours = StringCalculator.add("//[#$]\n1#$2#$3",
				"//[&&][|||\n3|||2&&3");
		assertEquals(resours, 14);
		resours = StringCalculator.add("1", "1,2", "1\n2,3");
		assertEquals(resours, 10);
	}

	@Test(expected = NumberFormatException.class)
	public void kata9() {
		int resours = StringCalculator.add("1,-1");

	}

}
