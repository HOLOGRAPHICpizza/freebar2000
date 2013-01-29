package org.peak15.freebar2000.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A tree of music
 * 
 * immutable
 */
public final class Music {
	public enum MusicType {
		SONG,	// one song
		LIST	// a list of music
	}
	
	private final MusicType type;
	private final String name;
	private final List<Music> list;
	
	/**
	 * Create a SONG
	 * 
	 * @param name of the song 
	 */
	public Music(String name) {
		this.type = MusicType.SONG;
		this.name = name;
		this.list = null;
	}
	
	/**
	 * Create a LIST
	 * 
	 * @param list of music
	 */
	public Music(String name, List<Music> list) {
		this.type = MusicType.LIST;
		this.name = name;
		this.list = new ArrayList<Music>(list);
	}
	
	public MusicType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	/**
	 * Get the list of child music
	 * 
	 * @return list of child music, or null if there are no children
	 */
	public List<Music> getChildren() {
		if(list == null) {
			return null;
		}
		return Collections.unmodifiableList(list);
	}
}
