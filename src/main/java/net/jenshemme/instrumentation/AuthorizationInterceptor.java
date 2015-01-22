package net.jenshemme.instrumentation;

import net.jenshemme.context.ContextRegistry;
import net.jenshemme.context.RegistryKey;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Checks if current user is authorized.
 */
public class AuthorizationInterceptor {

    @Inject
    private ContextRegistry registry;

    @AroundInvoke
    public Object checkAuthorization(InvocationContext ic) throws Exception {
        Object bla = registry.get(RegistryKey.AUTHORIZATION_TOKEN);
        if (registry.get(RegistryKey.AUTHORIZATION_TOKEN) != null) {
            return ic.proceed();
        } else {
            throw new SecurityException("Authorization token is missing!");
        }
    }
}
