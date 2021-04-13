package main;

import java.awt.Graphics2D;

import globalValues.GlobalValue;
import gui.IFrame;
import gui.RepaintControler;
import objects.BaseObject;

/**
 * WhatsTheColor ist ein Programm, dass die Farbe eines Bildschirmpixels
 * ausgibt.
 */

public class Main implements Draw
{
	private BaseObject baseObject = new BaseObject();
	private IFrame iFrame = new IFrame("ColorLookUp");

	public Main()
	{
		setup();

		/* game loop */
		while (true)
		{
			sleep();
			draw(iFrame.getIPanelGraphics());
			RepaintControler.getRepaintControler().repaintIPanel();
		}
	}

	/*
	 * The draw method is called every new tick.
	 */

	@Override
	public final void draw(Graphics2D graphics)
	{
		baseObject.draw(graphics);
	}

	private final void sleep()
	{
		try
		{
			Thread.sleep((int) GlobalValue.getTickrate());
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private final void setup()
	{
		RepaintControler.initReapaintControler(iFrame);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
