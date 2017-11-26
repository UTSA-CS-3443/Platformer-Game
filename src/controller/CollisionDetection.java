package controller;

import java.util.ArrayList;

import model.Entity;

//Unimplemented when done should detect collisions between entities and take appropriate action

public class CollisionDetection {
	private ArrayList<Entity> entities;
	public CollisionDetection()
	{
		entities = new ArrayList<Entity>();
	}
	
	public void CollisionCheck()
	{
		for(int i=0; i<entities.size();i++)
		{
			for(int x=i+1; x<entities.size(); x++)
			{
				if(entities.get(i).collides(entities.get(x)))
				{
					entities.get(i).collided();
					entities.get(x).collided();
				}
			}
		}
	}
	
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	
	public void removeEntity(Entity e)
	{
		entities.remove(e);
	}
	
	public ArrayList<Entity> getList()
	{
		return entities;
	}
	
	public void reset()
	{
		for(Entity e : entities)
			e.start();
	}
}
