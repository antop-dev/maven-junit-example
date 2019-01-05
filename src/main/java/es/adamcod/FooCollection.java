package es.adamcod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		return list.stream().map(Foo::bar).collect(Collectors.joining());
	}
}
