package wsvintsitsky.instinctools.pattern.chain;

public class AuthenticateOperation extends ChainNode {

	public AuthenticateOperation(ChainNode chainNode) {
		super(chainNode);
	}

	@Override
	public void hanldeRequest() {
		System.out.println("authenticating");
		if (getChainNode() != null) {
			getChainNode().hanldeRequest();
		}
	}
}
