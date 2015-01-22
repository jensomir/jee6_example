package net.jenshemme.instrumentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Tracks the class name and the method name.
 */
public class TracingInterceptor {

    final Logger logger = LoggerFactory.getLogger(TracingInterceptor.class);

    @AroundInvoke
    public Object trace(InvocationContext context) throws Exception {
        logger.info("Target Class: " + context.getTarget().getClass().getSimpleName());
        logger.info("Target Method: " + context.getMethod().getName());
        return context.proceed();
    }
}
