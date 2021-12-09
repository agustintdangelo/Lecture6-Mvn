package com.solvd.connections;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	public static final int CONNECTIONS_LIMIT = 5;

	private static ConnectionPool instance;
	private List<Connection> connectionPool;
	private List<Connection> usedConnections = new ArrayList<>(CONNECTIONS_LIMIT);

	private ConnectionPool() {
		this.connectionPool = new ArrayList<>(CONNECTIONS_LIMIT);
		for (int i = 0; i < CONNECTIONS_LIMIT; i++) {
			this.connectionPool.add(new Connection());
		}
	}

	public static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	public boolean hasFreeConnections() {
		return !connectionPool.isEmpty();
	}

	public synchronized Connection connect() {
		if (connectionPool.isEmpty() || usedConnections.size() > CONNECTIONS_LIMIT) {
			throw new RuntimeException("No available connections!");
		}

		Connection connection = connectionPool.remove(connectionPool.size() - 1);
		usedConnections.add(connection);
		return connection;
	}

	public synchronized boolean disconnect(Connection connection) {
		connectionPool.add(connection);
		return usedConnections.remove(connection);
	}
}
