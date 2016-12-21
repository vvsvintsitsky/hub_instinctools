package wsvintsitsky.instinctools.resource;

public interface ISharedResource {

	void increaseValue(int value);
	
	void decreaseValue(int value);
	
	int getValue();
}
