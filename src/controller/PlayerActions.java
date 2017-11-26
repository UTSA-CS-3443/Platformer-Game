//Team We Love Doggos
package controller;

import java.util.ArrayList;
import model.Player;

/**
 * This class provides the controls for the Player actions
 * 
 * @author Chase Booher
 */
public class PlayerActions {
	private ArrayList<String> input;
	
	public PlayerActions()
	{
		input = new ArrayList<String>();
	}
	
	public ArrayList<String> getInput()
	{
		return input;
	}
	
	public void addInput(String s)
	{
		input.add(s);
	}
	
	public void removeInput(String s)
	{
		input.remove(s);
	}
	
	public void takeAction(Player p)
	{
		if (input.contains("UP"))
			p.jump(-20);
		if (input.contains("RIGHT"))
			p.setXVel(5);
		else if (input.contains("LEFT"))
			p.setXVel(-5);
		else
			p.setXVel(0);
	}
}
