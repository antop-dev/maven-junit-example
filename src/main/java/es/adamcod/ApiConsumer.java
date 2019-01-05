package es.adamcod;

public class ApiConsumer {

	private final ThirdPartyApi api;

	public ApiConsumer(ThirdPartyApi api) {
		this.api = api;
	}

	public void fetchAll() {
		int page = 1;

		Response response = null;
		do {
			response = api.get(page++);
		} while (api.hasMore(response));
	}
}
