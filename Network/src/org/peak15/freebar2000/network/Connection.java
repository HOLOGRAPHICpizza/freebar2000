package org.peak15.freebar2000.network;

import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

public class Connection implements Lookup.Provider {
	
	private final InstanceContent content = new InstanceContent();
	private final Lookup lookup = new AbstractLookup(content);
	
	private ConnectionStatus status = new ConnectionStatus(false);
	
	public void connect() {
		setConnectionStatus(new ConnectionStatus(true));
	}
	
	@Override
	public Lookup getLookup() {
		return lookup;
	}
	
	private void setConnectionStatus(ConnectionStatus status) {
		content.remove(this.status);
		this.status = status;
		content.add(this.status);
	}
	
	private Connection() {
		content.add(this.status);
	}
	
	public static Connection getInstance() {
		return ConnectionHolder.INSTANCE;
	}
	
	private static class ConnectionHolder {
		private static final Connection INSTANCE = new Connection();
	}
}
