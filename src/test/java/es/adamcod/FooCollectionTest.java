package es.adamcod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://adamcod.es/2014/05/15/test-doubles-mock-vs-stub.html
 */
public class FooCollectionTest {
	@Test
	public void it_should_maintain_a_count() {
		FooCollection sut = new FooCollection();
		sut.add(new FooDummy());
		sut.add(new FooDummy());
		assertEquals(2, sut.count());
	}

	@Test
	public void it_should_return_joined_bars() {
		FooCollection sut = new FooCollection();
		sut.add(new FooStub());
		sut.add(new FooStub());
		assertEquals("bazbaz", sut.joined());
	}

	/**
	 * Dummy
	 * 구현체도 필요 없다. 테스트시 존재만을 대신하는 클래스를 더미라 한다.
	 */
	private class FooDummy implements Foo {
		@Override
		public String bar() {
			// 구현 안해도 된다.
			return null;
		}
	}

	/**
	 * Stub
	 * 구현체를 단순하게 구현하여 정해진 테스트 용도로 쓰인다.
	 */
	private class FooStub implements Foo {

		/**
		 * 이 메서드는 무조건 "baz" 값을 리턴한다.
		 * @return "baz"
		 */
		@Override
		public String bar() {
			return "baz";
		}
	}

}
