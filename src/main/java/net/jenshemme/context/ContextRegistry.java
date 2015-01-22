package net.jenshemme.context;

import javax.annotation.Resource;
import javax.transaction.TransactionSynchronizationRegistry;

/**
 * A Wrapper around TransactionalSynchronizationRegistry.
 * Holds the context for the current transaction.
 */
public class ContextRegistry {

    @Resource
    private TransactionSynchronizationRegistry registry;

    public void put(RegistryKey key, Object value) {
        registry.putResource(key, value);
    }

    public Object get(RegistryKey key) {
        return registry.getResource(key);
    }
}
