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
}
