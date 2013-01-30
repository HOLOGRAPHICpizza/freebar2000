package org.peak15.freebar2000.common;

import java.util.List;

/**
 * A tree of music
 * 
 * Constructors:
 *	
 *	Create a SONG
 *	public Music(String name)
 * 
 *	Create a LIST
 *	public Music(String name, List<Music> list)
 */
public interface Music {
	
	enum Type {
		SONG,	// one song
		LIST	// a list of music
	}
	
	/**
	 * Get the list, this can be modified.
	 *
	 * @return list of child music, or null if there are no children
	 * @requires this.getType() == MusicType.LIST
	 */
	List<Music> getList();

	void setName(String name);
	String getName();

	Type getType();
}
