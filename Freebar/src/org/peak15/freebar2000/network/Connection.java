package org.peak15.freebar2000.network;

import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

public class Connection implements Lookup.Provider {
	
	private final InstanceContent content = new InstanceContent();
	private final Lookup lookup = new AbstractLookup(content);
	
	@Override
	public Lookup getLookup() {
		return lookup;
	}
	
	private Connection() {
	}
	
	public static Connection getInstance() {
		return ConnectionHolder.INSTANCE;
	}
	
	private static class ConnectionHolder {
		private static final Connection INSTANCE = new Connection();
	}
}
