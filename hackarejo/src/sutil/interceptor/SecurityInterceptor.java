package sutil.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityInterceptor implements ContainerRequestFilter {

	@Context
	public HttpServletRequest request;

	@Context
	public ResourceInfo info;

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		Method m = info.getResourceMethod();
		System.out
				.println("Filtered: " + requestContext.getUriInfo().getPath());
		if (m.isAnnotationPresent(RolesAllowed.class)) {

			RolesAllowed ra = m.getAnnotation(RolesAllowed.class);

			if (request.getSession().getAttribute("LOGADO") == null) {
				requestContext.abortWith(Response.status(401).build());
			} else {
				System.out.println("Está logado, pode seguir!");
			}
		}
	}
}