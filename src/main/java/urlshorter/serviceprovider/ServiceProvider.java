package urlshorter.serviceprovider;

import urlshorter.link.HibernateLinkService;
import urlshorter.link.LinkService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServiceProvider {
    private static Map<Class<? extends  Object>, Object> SERVICES = new HashMap<>();

    static {
        SERVICES.put(LinkService.class, new HibernateLinkService());
    }
    @SuppressWarnings(value = "unchecked")
    public static <T> T get(Class<T> tClass) {
        return (T) SERVICES.get(tClass);
    }
}
