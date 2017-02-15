package wsvintsitsky.instinctools.pattern.chain;

public class ChangeNameOperation extends ChainNode {
	
	public ChangeNameOperation(ChainNode chainNode) {
		super(chainNode);
	}

	@Override
	public void hanldeRequest() {
		System.out.println("changing name");
		if (getChainNode() != null) {
			getChainNode().hanldeRequest();
		}
	}
}
