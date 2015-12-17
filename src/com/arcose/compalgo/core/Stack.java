package com.arcose.compalgo.core;

import java.math.BigInteger;

public class Stack {
	
	private StackElement[] Elements;
	private BigInteger SAverage, SRemainder;
	private Boolean Current = false;
	
	public Stack() {
		
	}
	
	private int Size() {
		return Elements.length;
	}
	
	private void Push(StackElement sEnt) {
		//TODO: Modify method to use ArrayUtils.
		Current = false;
		StackElement[] newStack = new StackElement[Size() + 1];
		int i = 1;
		for(StackElement se : Elements)
			newStack[i++] = se;
		newStack[0] = sEnt;
		Elements = newStack;
	}
	
	private StackElement Pop() {
		//TODO: Modify method to use ArrayUtils.
		Current = false;
		StackElement se = Elements[0];
		StackElement[] newStack = new StackElement[Size() - 1];
		for(int i = 0; i < Size() - 1; i++)
			newStack[i] = Elements[i + 1];
		Elements = newStack;
		return se;
	}
	
	private BigInteger[] Calculate_AverageRemainder() {		
		BigInteger s = new BigInteger(Integer.toString(Size()));
		BigInteger avg = new BigInteger("0");
		for(StackElement se : Elements)
			avg = avg.add(se.toBigInteger());
		
		BigInteger[] sAvgRem = avg.divideAndRemainder(s);
		SAverage = sAvgRem[0];
		SRemainder = sAvgRem[1];
		
		Current = true;
		return sAvgRem;
	}
	
	private BigInteger Average() {
		return (Current ? SAverage : Calculate_AverageRemainder()[0]);
	}
	
	private BigInteger Remainder() {
			return (Current ? SRemainder : Calculate_AverageRemainder()[1]);
	}

}
