package Exercise;

import java.util.ArrayList;
import java.util.List;

public class E17_generateParenthesis {
	public void add(List<String> list, int open, int close, int n, String temp) {
		if (temp.length() == n * 2)
			list.add(temp);
		if (open < n)
			add(list, open + 1, close, n, temp + "(");
		if (close < open)
			add(list, open, close + 1, n, temp + ")");
	}

	public List<String> generateParenthesis(int n) {

		List<String> list = new ArrayList<>();
		add(list, 0, 0, n, "");
		return list;
	}

	public static void main(String[] args) {
		E17_generateParenthesis parenthesis = new E17_generateParenthesis();
		System.out.println(parenthesis.generateParenthesis(3));
	}
}
