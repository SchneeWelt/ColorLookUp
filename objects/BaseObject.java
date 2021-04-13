package objects;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import globalValues.GlobalValue;
import handler.OnKeyRelease;
import main.Draw;

public class BaseObject implements Draw, OnKeyRelease
{
	private ColorDisplayer colorDisplayer = new ColorDisplayer();

	public BaseObject()
	{
		GlobalValue.getKeyEventHandler().addOnKeyRelease(this);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		colorDisplayer.draw(graphics);
	}

	@Override
	public void onKeyRelease(KeyEvent e)
	{
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;

		colorDisplayer.changeColor(printPixelColorOnScreen(x, y));
	}

	/**
	 * Gibt die Farbe des Pixels auf P(x, y) zurück, Returns the color of pixel on
	 * point(x, y) on screen. ColorFormat=rgb, Farbformat=rgb.
	 * 
	 * @return The color read from the x and y position
	 */

	private final Color printPixelColorOnScreen(int x, int y)
	{
		Color color = null;

		try
		{
			color = new Robot().getPixelColor(x, y);
		} catch (AWTException e)
		{
			e.printStackTrace();
		}

		String message = "R: " + color.getRed();
		message += " G: " + color.getGreen();
		message += " B: " + color.getBlue();

		System.out.println(message);
		
		return color;
	}

}
