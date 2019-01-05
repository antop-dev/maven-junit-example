package es.adamcod;

public interface ThirdPartyApi {

	boolean hasMore(Response previousResponse);

	Response get(int page);

}
