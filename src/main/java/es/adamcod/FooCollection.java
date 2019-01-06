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
		return list.stream().map(Foo::bar).collect(Collectors.joining());
	}
}
