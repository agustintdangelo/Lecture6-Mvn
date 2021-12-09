package com.solvd.connections;

import java.util.logging.Logger;

public class Connection {
	private static final Logger LOG = Logger.getLogger(Connection.class.getName());

	public void pinging(String message) {
		LOG.info(message);
	}

	public void auth(String message) {
		LOG.info(message);
	}

	public void info(String message) {
		LOG.info(message);
	}

	public void executeQuery(String message) {
		LOG.info(message);
	}

	public void close(String message) {
		LOG.info(message);
	}
}
