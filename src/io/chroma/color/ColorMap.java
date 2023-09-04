package io.chroma.color;

public class ColorMap {
	
	private static final ColorMap INSTANCE = new ColorMap();
	
	private static final int MAXIMAL_COLOR_CHANNEL_VALUE = 255;
	private static final int MINIMAL_COLOR_CHANNEL_VALUE = 0;
	
	private final byte[][][] colorIDs = new byte[MAXIMAL_COLOR_CHANNEL_VALUE + 1][MAXIMAL_COLOR_CHANNEL_VALUE + 1][MAXIMAL_COLOR_CHANNEL_VALUE + 1];
	private final int[][][] colorDistances = new int[MAXIMAL_COLOR_CHANNEL_VALUE + 1][MAXIMAL_COLOR_CHANNEL_VALUE + 1][MAXIMAL_COLOR_CHANNEL_VALUE + 1];
	
	private ColorMap() {
		addColors();
	}
	
	private void addColors() {
		long time = System.currentTimeMillis();
		boolean firstColor = true;
		
		for(Color color : Color.getColors()) {

			if(firstColor) {
				firstColor = false;

				addDefaultColor(color);
				continue;
			}

			addColor(color);
		}
		
		System.out.println(System.currentTimeMillis() - time);
	}
	
	private void addDefaultColor(Color color) {
		long time = System.currentTimeMillis();
		
		for(int red = MINIMAL_COLOR_CHANNEL_VALUE; red <= MAXIMAL_COLOR_CHANNEL_VALUE; red++) {
			for(int green = MINIMAL_COLOR_CHANNEL_VALUE; green <= MAXIMAL_COLOR_CHANNEL_VALUE; green++) {
				for(int blue = MINIMAL_COLOR_CHANNEL_VALUE; blue <= MAXIMAL_COLOR_CHANNEL_VALUE; blue++) {
					
					int dr = red - color.getRed();
					int dg = green - color.getGreen();
					int db = blue - color.getBlue();
					int d = dr * dr + dg * dg + db * db;
					
					colorIDs[red][green][blue] = color.getID();
					colorDistances[red][green][blue] = d;
				}
			}
		}
		
		System.out.println(System.currentTimeMillis() - time);
	}
	
	private void addColor(Color color) {
		long time = System.currentTimeMillis();
		
		for(int red = MINIMAL_COLOR_CHANNEL_VALUE; red <= MAXIMAL_COLOR_CHANNEL_VALUE; red++) {
			for(int green = MINIMAL_COLOR_CHANNEL_VALUE; green <= MAXIMAL_COLOR_CHANNEL_VALUE; green++) {
				for(int blue = MINIMAL_COLOR_CHANNEL_VALUE; blue <= MAXIMAL_COLOR_CHANNEL_VALUE; blue++) {
					
					int colorDistance = colorDistances[red][green][blue];
					int dr = red - color.getRed();
					int dg = green - color.getGreen();
					int db = blue - color.getBlue();
					int d = dr * dr + dg * dg + db * db;
					
					if(d < colorDistance) {
						colorIDs[red][green][blue] = color.getID();
						colorDistances[red][green][blue] = d;
					}
				}
			}
		}
		
		System.out.println(System.currentTimeMillis() - time);
	}
	
	public Color getColor(int red, int green, int blue) {
		byte colorID = colorIDs[red][green][blue];
		
		return Color.getColor(colorID);
	}
	
	public static ColorMap getInstance() {
		return INSTANCE;
	}
	
}
