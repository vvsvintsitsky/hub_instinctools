package wsvintsitsky.instinctools.resource.producing;

import wsvintsitsky.instinctools.resource.ISharedResource;

public interface IProducingStrategy {

	Integer produce(ISharedResource resource);
}
