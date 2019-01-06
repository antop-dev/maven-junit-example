package es.adamcod;

import java.util.ArrayList;
import java.util.List;

public class FooCollection {
	private List<Foo> list = new ArrayList<>();

	public void add(Foo foo) {
		list.add(foo);
	}

	public int count() {
		return list.size();
	}

	public String joined() {
		// java 8 or later
		// return list.stream().map(Foo::bar).collect(Collectors.joining());

		// all java
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).bar());
		}
		return sb.toString();
	}
}
