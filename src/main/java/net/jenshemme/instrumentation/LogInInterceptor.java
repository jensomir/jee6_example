package net.jenshemme.instrumentation;

import net.jenshemme.context.ContextRegistry;
import net.jenshemme.context.RegistryKey;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.UUID;

/**
 * Logs you in.
 */
public class LogInInterceptor {

    @Inject
    private ContextRegistry registry;

    @AroundInvoke
    public Object logIn(InvocationContext ic) throws Exception {
        registry.put(RegistryKey.AUTHORIZATION_TOKEN, UUID.randomUUID());
        return ic.proceed();
    }

}
