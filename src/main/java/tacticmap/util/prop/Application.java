package tacticmap.util.prop;

import static tacticmap.util.spec.PropEnum._APP_VERSION;

public record Application() {

    public static final String version = _APP_VERSION.get();
}
