package tacticmap.util.spec;

import works.lysenko.base.StringParser;
import works.lysenko.util.apis._PropEnum;

import java.util.Locale;

import static java.util.Objects.isNull;
import static works.lysenko.Base.properties;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.spec.Symbols.*;

@SuppressWarnings({"MissingJavadoc", "OverloadedVarargsMethod", "Singleton"})
public enum PropEnum implements _PropEnum {

    _APP_VERSION(String.class, _1_, _DOT_, _8_, _DOT_, _0_);

    private final Class<?> type;
    private final String defaultValue;

    /**
     * Constructs a PropEnum instance with a specified type and default string value.
     *
     * @param type              the type of the property, represented as a {@link Class}
     * @param defaultStringValue the default value of the property, represented as a {@link String}
     */
    PropEnum(final Class<?> type, final String defaultStringValue) {

        this.type = type;
        defaultValue = defaultStringValue;
    }

    /**
     * Constructs a PropEnum instance with a specified type and default character value.
     *
     * @param type             the type of the property, represented as a {@link Class}
     * @param defaultCharValue the default value of the property, represented as a {@code char}
     */
    PropEnum(final Class<?> type, final char defaultCharValue) {

        this.type = type;
        defaultValue = s(defaultCharValue);
    }

    /**
     * Constructor for the PropEnum class.
     *
     * @param type         the type of the PropEnum, represented as a Class of Integer
     * @param defaultChars a variable number of char arguments used to compute a default value
     */
    PropEnum(final Class<?> type, final char... defaultChars) {

        this.type = type;
        defaultValue = new String(defaultChars);
    }

    /**
     * Retrieves the default value associated with the property enumerator.
     *
     * @return the default value of the property as a string
     */
    @Override
    public String defaultValue() {

        return defaultValue;
    }

    /**
     * Retrieves the value associated with the enumerated property. If the properties object is null,
     * the default value of the property is parsed and returned. Otherwise, the value from the properties
     * object associated with this enumerated property is retrieved and returned.
     *
     * @param <T> the type of the property value
     * @return the value of the enumerated property, either from the properties object or parsed from
     *         the default value, casted to the appropriate type T
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T get() {

        return (isNull(properties)) ? (T) StringParser.create(defaultValue, type).result() : (T) properties.getEnum(this);
    }

    /**
     * Retrieves the property name associated with the enumerator in a converted format.
     * The name is transformed to lowercase, replacing underscores with dots.
     *
     * @return the formatted property name as a string
     */
    @Override
    public String getPropertyName() {

        return s(name().toLowerCase(Locale.ROOT).replace(UND_SCR, _DOT_));
    }

    @Override
    public boolean silent() {

        return false;
    }

    /**
     * Retrieves the type of the property associated with this property enumerator.
     *
     * @return the class type of the property
     */
    @Override
    public Class<?> type() {

        return type;
    }
}
