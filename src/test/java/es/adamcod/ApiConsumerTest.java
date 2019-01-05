package es.adamcod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApiConsumerTest {

	@Test
	public void it_should_get_all_pages() {
		ThirdPartyApiSpy spy = new ThirdPartyApiSpy();
		ApiConsumer sut = new ApiConsumer(spy);
		sut.fetchAll();

		assertEquals(1, spy.callCount);
	}

	/**
	 * Spy
	 * 내부적인 행동을 체크하는 클래스
	 */
	private class ThirdPartyApiSpy implements ThirdPartyApi {

		public int callCount;

		@Override
		public boolean hasMore(Response previousResponse) {
			if (this.callCount == 0) {
				return true;
			}
			return false;
		}

		@Override
		public Response get(int page) {
			this.callCount++;
			return new ResponseDummy();
		}

	}

	/**
	 * Dummy
	 */
	private class ResponseDummy implements Response {
	}
}
