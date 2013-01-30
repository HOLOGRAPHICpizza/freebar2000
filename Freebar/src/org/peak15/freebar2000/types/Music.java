package org.peak15.freebar2000.types;

import java.util.ArrayList;
import java.util.List;

/**
 * A tree of music
 */
public class Music {
	public enum Type {
		SONG,	// one song
		LIST	// a list of music
	}
	
	private final Type type;
	private final List<Music> list;
	private String name;
	
	/**
	 * Create a SONG
	 * 
	 * @param name of the song 
	 */
	public Music(String name) {
		this.type = Type.SONG;
		this.name = name;
		this.list = null;
	}
	
	/**
	 * Create a LIST
	 * 
	 * @param list of music
	 */
	public Music(String name, List<Music> list) {
		this.type = Type.LIST;
		this.name = name;
		this.list = new ArrayList<Music>(list);
	}
	
	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the list, this can be modified.
	 * 
	 * @return list of child music, or null if there are no children
	 * @requires this.getType() == MusicType.LIST
	 */
	public List<Music> getList() {
		return list;
	}
}
