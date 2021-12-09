package com.solvd.connections;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ConnectionsTask {
	private static final int FREE_POOL_TIMEOUT = 500;
	private static final int EXECUTE_QUERY_TIMEOUT = 250;
	private static final Logger LOG = Logger.getLogger(ConnectionsTask.class.getName());
	private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

	public static void main(String[] args) {
		Runnable r = () -> {
			Thread currentThread = Thread.currentThread();
			String currentThreadName = currentThread.getName();

			try {
				Thread.sleep(250);
				while (!CONNECTION_POOL.hasFreeConnections()) {
					LOG.info(currentThreadName + "in queue");
					Thread.sleep(FREE_POOL_TIMEOUT);
				}
				createConnectionWithThreadName(currentThreadName);
			} catch (InterruptedException e) {
				LOG.info(e.getMessage());
			}
		};
		run(r);
	}

	public static void createConnectionWithThreadName(String threadName) throws InterruptedException {
		Connection connection = CONNECTION_POOL.connect();
		connection.pinging(threadName);
		connection.auth(threadName);
		connection.info(threadName);
		connection.executeQuery(threadName);
		connection.close(threadName);

		Thread.sleep(EXECUTE_QUERY_TIMEOUT);

		CONNECTION_POOL.disconnect(connection);
	}

	public static void run(Runnable r) {
		ArrayList<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			threads.add(new Thread(r, "thread " + i));
			threads.get(i).start();
		}
	}
}
