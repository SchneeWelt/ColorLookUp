package objects;

import java.awt.Color;
import java.awt.Graphics2D;

import globalValues.GlobalValue;
import main.Draw;
import tools.rect.VRect;

public class ColorDisplayer implements Draw
{
	private VRect displayer = new VRect(0, 0, 0, 0);

	public ColorDisplayer()
	{
		displayer.setColor(Color.black);
		displayer.setW(GlobalValue.getScreenDimension().width);
		displayer.setH(GlobalValue.getScreenDimension().height);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		displayer.draw(graphics);
	}

	public final void changeColor(Color newColor)
	{
		displayer.setColor(newColor);
	}
}
