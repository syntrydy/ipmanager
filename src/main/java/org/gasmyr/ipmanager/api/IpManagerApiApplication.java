package org.gasmyr.ipmanager.api;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.gasmyr.ipmanager.util.ApiConstants;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(ApiConstants.BASE_API_URL)
@OpenAPIDefinition(info = @Info(title = "IP Manager API.", description = "This API enables the allocation of IP resources from pre-defined IP Pools.", version = "1.0", contact = @Contact(name = "Mougang Gasmyr", url = "https://github.com/syntrydy")), servers = {
		@Server(url = "http://localhost:8080") }, externalDocs = @ExternalDocumentation(url = "https://github.com/syntrydy", description = "Developer's github account"), tags = {
				@Tag(name = "IP Manager API.", description = "IP allocation api."), })
public class IpManagerApiApplication extends Application {

}
