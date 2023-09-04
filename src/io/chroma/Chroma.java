package io.chroma;

import io.chroma.color.Color;

public class Chroma {
	
	public static void main(String[] args) {
		System.out.println(Color.getClosestColor(127, 127, 127).getID());
	}
	
}
