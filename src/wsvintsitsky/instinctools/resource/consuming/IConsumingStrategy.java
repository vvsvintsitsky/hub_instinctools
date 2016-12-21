package wsvintsitsky.instinctools.resource.consuming;

import wsvintsitsky.instinctools.resource.ISharedResource;

public interface IConsumingStrategy {

	int consume(ISharedResource resource);
}
