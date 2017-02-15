package wsvintsitsky.instinctools.pattern.chain;

public abstract class ChainNode {

	private ChainNode chainNode;
	
	public ChainNode(ChainNode chainNode) {
		super();
		this.chainNode = chainNode;
	}

	protected ChainNode getChainNode() {
		return chainNode;
	}

	protected void setChainNode(ChainNode chainNode) {
		this.chainNode = chainNode;
	}

	public abstract void hanldeRequest();
}
