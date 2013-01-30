package org.peak15.freebar2000.common;

import java.util.ArrayList;
import java.util.List;

public class DefaultMusic implements Music {
	
	private final Type type;
	private final List<Music> list;
	private String name;
	
	/**
	 * Create a SONG
	 * 
	 * @param name of the song 
	 */
	public DefaultMusic(String name) {
		this.type = Type.SONG;
		this.name = name;
		this.list = null;
	}
	
	/**
	 * Create a LIST
	 * 
	 * @param list of music
	 */
	public DefaultMusic(String name, List<Music> list) {
		this.type = Type.LIST;
		this.name = name;
		this.list = new ArrayList<>(list);
	}
	
	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the list, this can be modified.
	 * 
	 * @return list of child music, or null if there are no children
	 * @requires this.getType() == MusicType.LIST
	 */
	@Override
	public List<Music> getList() {
		return list;
	}
}