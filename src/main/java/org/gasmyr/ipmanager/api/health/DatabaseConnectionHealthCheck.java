package org.gasmyr.ipmanager.api.health;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;
import org.gasmyr.ipmanager.exception.DatabaseConnectionErrorException;
import org.gasmyr.ipmanager.service.DatabaseService;

@Readiness
@ApplicationScoped
public class DatabaseConnectionHealthCheck implements HealthCheck {

	@Inject
	DatabaseService databaseService;

	public HealthCheckResponse call() {
		HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("IP Manager readiness");
		try {
			checkDatabaseConnection();
			responseBuilder.up();
		} catch (DatabaseConnectionErrorException e) {
			responseBuilder.down().withData("error", e.getMessage());
		}
		return responseBuilder.build();
	}

	private void checkDatabaseConnection() throws DatabaseConnectionErrorException {
		databaseService.checkConnection();
	}

}
