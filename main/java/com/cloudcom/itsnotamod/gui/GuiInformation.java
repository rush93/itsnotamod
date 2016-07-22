package com.cloudcom.itsnotamod.gui;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.GameType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;

public class GuiInformation extends GuiScreen {
	
	private Gui parentScreen;
	private String title;
	private String description;
	
	public GuiInformation(Gui screen, String title, String description) {
		this.parentScreen = screen;
		this.title = title;
		this.description = description;
	}	
	
	/**
	 * Ajout des différents "controls" à l'écran en question
	 */
	@Override
	public void initGui()
	{
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, this.width / 2 - 80, this.height - 28, 150, 20, "J'ai compris. GO!"));
	}
	
	/**
	 * Draws the screen and all the components in it. Args : mouseX, mouseY,
	 * renderPartialTicks
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRendererObj, title, this.width / 2, 20, -1);
		this.drawString(this.fontRendererObj, description, this.width / 2 - 100, 47, -6250336);

		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		if (button.enabled)
		{
			if (button.id == 0)
			{
				this.mc.displayGuiScreen(null); // (this.parentScreen);
			}			
		}
	}
	
	
}
