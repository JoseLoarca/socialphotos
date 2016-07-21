package org.jcloarca.socialphotos.libs.base;

/**
 * Created by JCLoarca on 7/20/2016 11:22 PM.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
