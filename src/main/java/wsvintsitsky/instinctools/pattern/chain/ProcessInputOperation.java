package wsvintsitsky.instinctools.pattern.chain;

public class ProcessInputOperation extends ChainNode {

	public ProcessInputOperation(ChainNode chainNode) {
		super(chainNode);
	}

	@Override
	public void hanldeRequest() {
		System.out.println("processing input");
		if (getChainNode() != null) {
			getChainNode().hanldeRequest();
		}
	}
}
