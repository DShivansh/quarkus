package io.quarkus.arc;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;

/**
 * It can be used by synthetic {@link InjectableBean} definitions to destroy a contextual instance.
 *
 * @param <T>
 * @see Contextual#destroy(Object, CreationalContext)
 */
public interface BeanDestroyer<T> {

    /**
     *
     * @param instance
     * @param creationalContext
     * @param params
     */
    void destroy(T instance, CreationalContext<T> creationalContext, Map<String, Object> params);

    class CloseableDestroyer implements BeanDestroyer<Closeable> {
        @Override
        public void destroy(Closeable instance, CreationalContext<Closeable> creationalContext, Map<String, Object> params) {
            try {
                instance.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class AutoCloseableDestroyer implements BeanDestroyer<AutoCloseable> {
        @Override
        public void destroy(AutoCloseable instance, CreationalContext<AutoCloseable> creationalContext,
                Map<String, Object> params) {
            try {
                instance.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
