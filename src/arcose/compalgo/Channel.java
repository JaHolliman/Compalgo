package arcose.compalgo;

public class Channel {
	
	private Buffer[] Contents = new Buffer[0];
	private int Length = 0;

	public Buffer[] getContents() {
		return this.Contents;
	}

	public void setContents(Buffer[] buf) {
		this.Contents = buf;
		this.setLength(buf.length);
	}
	
	public int getLength() {
		return this.Length;
	}

	public int setLength(int length) {
		return this.Length = length;
	}
	
	//Channel.Push(Buffer): Returns the number of elements in the channel.
	public int Push(Buffer buf) {
		//TODO Boundary checks on array.
		Buffer[] newCh = new Buffer[this.getLength() + 1];
		
		newCh[0] = buf;
		for(int i = 0; i < this.getLength(); i++)
			newCh[i + 1] = this.getContents()[i];
		
		return this.setLength(newCh.length);
	}
	
	public Buffer Pop() {
		//TODO Boundary checks on array.
		Buffer buf = this.getContents()[0];
		Buffer[] newCh = new Buffer[this.getLength() - 1];

		for(int i = 0; i < this.getLength() - 1; i++)
			newCh[i] = this.getContents()[i + 1];
		
		return buf;
	}
}