package io.chroma.color;

public class Color {
	
	public static final Color WHITE = new Color((byte) 0, 255, 255, 255);
	public static final Color RED = new Color((byte) 1, 255, 0, 0);
	public static final Color GREEN = new Color((byte) 2, 0, 255, 0);
	public static final Color BLUE = new Color((byte) 3, 0, 0, 255);
	public static final Color ORANGE = new Color((byte) 4, 216, 127, 51);
	
	private static final Color[] COLORS = new Color[] {
			WHITE,
			RED,
			GREEN,
			BLUE,
			ORANGE
	};
	
	private final byte id;
	
	private final int red;
	private final int green;
	private final int blue;
	
	public Color(byte id, int red, int green, int blue) {
		this.id = id;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public byte getID() {
		return id;
	}
	
	public int getRed() {
		return red;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public static Color getClosestColor(int red, int green, int blue) {
		ColorMap map = ColorMap.getInstance();
		
		return map.getColor(red, green, blue);
	}
	
	public static Color getColor(byte id) {
		return COLORS[id];
	}
	
	public static Color[] getColors() {
		return COLORS;
	}
	
}
