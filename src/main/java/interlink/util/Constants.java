package interlink.util;

import static interlink.util.lang.A.ADD_OBJECT;
import static interlink.util.lang.D.DRAG_HANDLE;
import static interlink.util.lang.E.ELEVATION_GRAPH;
import static interlink.util.lang.F.FIND_MY_LOCATION;
import static interlink.util.lang.S.SEARCH_1;
import static interlink.util.lang.S.SEARCH_2;
import static interlink.util.lang.T.TOTAL_DISTANCE;
import static interlink.util.lang.V.VIEW_HOLDER;
import static interlink.util.lang.Z.ZOOM_IN;
import static interlink.util.lang.Z.ZOOM_OUT;
import static interlink.util.lang.word.C.COMPASS;
import static interlink.util.lang.word.L.LOGIN;
import static interlink.util.lang.word.P.POLYGON;
import static interlink.util.lang.word.R.RULER;
import static interlink.util.lang.word.S.SETTINGS;
import static works.lysenko.util.chrs.____.INFO;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.S.SEARCH;

@SuppressWarnings({"HardCodedStringLiteral", "MissingJavadoc", "StaticMethodOnlyUsedInOneClass", "WeakerAccess", "PublicStaticArrayField", "HardcodedLineSeparator"})
public record Constants() {

    public final static String[] MAIN_SCREEN_ELEMENTS = {c(INFO), c(SEARCH), ZOOM_IN, ZOOM_OUT, VIEW_HOLDER, ADD_OBJECT,
            c(RULER), TOTAL_DISTANCE, c(POLYGON), ELEVATION_GRAPH, FIND_MY_LOCATION, c(COMPASS), DRAG_HANDLE, c(LOGIN),
            c(SETTINGS), SEARCH_1, SEARCH_2};

    // Short strings
    public static final String CONNECT_TEXT = "Підключення";
    public static final String UKROP_SYNC_BETA = "UkropSync Beta";
    public static final String EMAIL = "Email";
    public static final String PASSWORD = "Password";
    public static final String LOGIN_BUTTON_TEXT = "Увійти";
    public static final String URL_SETTINGS_LOCATOR = "URL Settings";

    // Long strings
    public static final String USER_CREDENTIAL_PROMPT = "Введіть дані свого облікового запису UkropSync";
    public static final String API_INTEGRATION_MESSAGE = "Ми працюємо над інтеграцією API в TacticMap, і наразі цей функціонал доступний лише в рамках закритого бета-тестування.\n\nЯкщо ви хочете спробувати API та отримати доступ, зв'яжіться з нами через WhatsApp: +380933394092.\nБудемо раді співпраці та вашим відгукам!";


    public static final String CREATE_LAYER = "Створити шар";
    public static final String CANCEL_BUTTON_LABEL = "Скасувати";
    public static final String NO_LAYERS_TEXT = "Немає шарів";
    public static final String WARNING_LAYER_REQUIRED = "Перед додаванням об'єкта, необхідно створити шар";
    public static final String SECURITY_TEXT = "Безпека";
    public static final String FEEDBACK_BUTTON_TEXT = "Залишити відгук";
    public static final String FUNCTION_PROPOSAL_TEXT = "Запропонувати функцію";
    public static final String CONTACT_DEVELOPER_TEXT = "Зв'язатися з розробником";
    public static final String MAP_LABEL = "Мапа";
    public static final String SETTINGS_TITLE = "Налаштування";
    public static final String MEASUREMENT_UNITS_LABEL = "Одиниці виміру";
    public static final String PERSONALIZATION_TEXT = "Персоналізація";
    public static final String FRIEND_INVITE_MESSAGE = "Розповісти другу";
    public static final String TITLE_SHAPES_AND_OBJECTS = "Шари та об'єкти";
    public static final String CALL_SIGN_TEXT = "Позивний";
    public static final String EXPORT_IMPORT_CALLSIGN_DESCRIPTION = "Позивний допомагає визначити. хто створив шар під час експорту та імпорту тактичної обстановки";
    public static final String GENERAL_SETTINGS_TITLE = "Загальні";
    public static final String SUPPORT_TEXT = "Підтримка";
    public static final String CLOSE_BUTTON_TEXT = "Закрити";
    public static final String OPEN_WHATSAPP_TEXT = "Відкрити WhatsApp";
    public static final String AGGREGATE_AREA_TEXT = "Загальна площа";
    public static final String ADD_BUTTON_TEXT = "Додати";
    public static final String CLEAR_BUTTON_TEXT = "Скинути";
    public static final String MORE_TEXT = "Більше";
    public static final String TOTAL_DISTANCE_TEXT = "Загальна відстань";
    public static final String COPY_BUTTON_TEXT = "Копіювати";
    public static final String NEW_OBJECT_TEXT = "Новий об'єкт";
    public static final String MAP_CENTER_TEXT = "Центр мапи";
    public static final String DISTANCE_TEXT = "На відстані: ";
    public static final String COORDINATES_TEXT = "Координати";
    public static final String HEIGHT_TEXT = "Висота";
    public static final String MAP_NOMENCLATURE_TEXT = "Номенклатура мапи";
}