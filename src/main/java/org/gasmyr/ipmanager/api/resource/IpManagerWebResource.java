package org.gasmyr.ipmanager.api.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.gasmyr.ipmanager.model.IpAddress;
import org.gasmyr.ipmanager.service.IpPoolService;
import org.gasmyr.ipmanager.util.ApiConstants;

@Path(ApiConstants.RESERVE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IpManagerWebResource {

	@Inject
	IpPoolService ipPoolService;

	@GET
	@Path(ApiConstants.DYNAMIC_IP)
	@Operation(summary = "Reserve dynamics ip(s) addresses")
	@APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IpAddress[].class, required = true)))
	public Response reserveDynamicIps(@QueryParam(ApiConstants.QUANTITY) @DefaultValue("1") int quantity) {
		try {
			return Response.ok(ipPoolService.reserveDynamicIps(quantity)).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path(ApiConstants.STATIC_IP)
	@Operation(summary = "Reserve static ip(s) addresses")
	@APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IpAddress[].class, required = true)))
	public Response reserveStaticIps(@QueryParam(ApiConstants.QUANTITY) @DefaultValue("1") int quantity) {
		try {
			return Response.ok(ipPoolService.reserveStaticIps(quantity)).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@POST
	@Path(ApiConstants.BLACKLIST_IP)
	@Operation(summary = "Blacklist a static IP address")
	@APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IpAddress[].class, required = true)))
	public Response blackListStaticIp() {
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

	@POST
	@Path(ApiConstants.FREE_IP)
	@Operation(summary = "Free an IP address")
	@APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IpAddress[].class, required = true)))
	public Response freeIp() {
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

	@POST
	@Path(ApiConstants.RETRIVE_IP_RESOURCE)
	@Operation(summary = "Retrieve an IP resource")
	@APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IpAddress[].class, required = true)))
	public Response reserveIpResource() {
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

}
