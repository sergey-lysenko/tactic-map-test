package tacticmap.tree.root.totalDistance;

import interlink.tree.CommonClose;
import interlink.tree.CommonMore;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.ANGLES_FIVE_MORE_ELEMENTS;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class More extends CommonMore {

    public More() {super(ANGLES_FIVE_MORE_ELEMENTS);}

    @Override
    public final void finals() throws SafeguardException {

        new CommonClose().isOk();
    }
}
