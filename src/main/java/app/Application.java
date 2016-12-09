package app;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class Application extends javax.ws.rs.core.Application implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(HealthResource.class).in(Singleton.class);
    }
}
