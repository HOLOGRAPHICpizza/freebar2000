package org.peak15.freebar2000.network;

public final class ConnectionStatus {
	private final boolean connected;
	
	public ConnectionStatus(boolean connected) {
		this.connected = connected;
	}
	
	public boolean isConnected() {
		return connected;
	}
}
