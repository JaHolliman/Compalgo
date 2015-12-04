package arcose.compalgo;

import java.math.BigInteger;

public class Buffer {
	
	private byte[] Contents;
	private int Length = 0;
	
	public Buffer() {
		// TODO Exception: Can not create null buffer.
	}
	
	public Buffer(byte[] buf) {
		setBuffer(buf);
	}
	
	public Buffer(String buf) {
		setBuffer(buf.getBytes());
	}
	
	public byte[] getBuffer() {
		return this.Contents;
	}
	
	public void setBuffer(byte[] buf) {
		this.Contents = buf;
		this.setLength(buf.length);
	}
	
	public int getLength() {
		return Length;
	}

	public void setLength(int length) {
		Length = length;
	}

	public BigInteger toBigInteger() {
		String curDec = ""; 
		String decRep = ""; //String for decimal representation of byte array to create BigInteger.
		
		for(int i = 0; i < this.getLength(); i++) {
			curDec = Integer.toString((int)this.getBuffer()[i]);
			while(curDec.length() < 3)
				curDec = "0" + curDec;
			decRep += curDec;
		}
		
		return new BigInteger(decRep);
	}
}
