package com.arcose.compalgo.core;

import java.math.BigInteger;

public class StackElement {

	private byte[] Entry; //Main array to hold data for this object.
	private final Boolean NullInit; //True if the initialization of this StackEntry held a null value.
	private Boolean IsCurrent = false;
	private BigInteger CachedBigInt;
	
	public StackElement() {
		NullInit = true;
		Entry = (byte[])null;
	}
	
	public StackElement(String s) {
		NullInit = false;
		Entry = s.getBytes(); //Entry is set to the byte array of the input string.
	}
	
	public int Length() {
		return Entry.length;
	}
	
	private void Push(byte b) {
		//TODO: Modify method to use ArrayUtils.
		byte[] newEntry = new byte[Length() + 1];
		int i = 1;
		for(byte index : Entry)
			newEntry[i++] = index;
		newEntry[0] = b;
		Entry = newEntry;
		IsCurrent = false;
	}
	
	private byte Pop() {
		//TODO: Modify method to use ArrayUtils.
		byte b = Entry[0];
		byte[] newEntry = new byte[Length() - 1];
		for(int i = 0; i < Length() - 1; i++)
			newEntry[i] = Entry[i + 1];
		Entry = newEntry;
		IsCurrent = false;
		return b;
	}
	
	private byte[] Reverse() {
		int len = Length();
		byte[] rEntry = new byte[len];
		int i = 1;
		for(byte b : Entry)
			rEntry[len - (i++)] = b;
		return rEntry;
	}
	
	public BigInteger toBigInteger() {
		if(IsCurrent)
			return CachedBigInt;
		
		byte[] inEntry = Entry;
		if(NullInit)
			inEntry = Reverse();
		String inStr = "";
		for(byte b : inEntry) {
			String pushStr = Integer.toString((int)b);
			while(pushStr.length() < 3)
				pushStr = "0" + pushStr;
			inStr += pushStr;
		}
		IsCurrent = true;
		return (CachedBigInt = new BigInteger(inStr));
	}

}
