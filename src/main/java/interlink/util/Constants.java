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

    public static final float DRAG_HANDLE_STEP = 0.05F;

    // Short strings
    public static final String ADD_BUTTON_TEXT = "Додати";
    public static final String AGGREGATE_AREA_TEXT = "Загальна площа";
    public static final String ANGLES_FORMAT_TEXT = "Формат кутів";
    public static final String AREA_FORMAT_TEXT = "Формат площі";
    public static final String CALL_SIGN_TEXT = "Позивний";
    public static final String CANCEL_BUTTON_LABEL = "Скасувати";
    public static final String CLEAR_BUTTON_TEXT = "Скинути";
    public static final String CLOSE_BUTTON_TEXT = "Закрити";
    public static final String CONNECT_TEXT = "Підключення";
    public static final String CONTACT_DEVELOPER_TEXT = "Зв'язатися з розробником";
    public static final String COORDINATES_TEXT = "Координати";
    public static final String COPY_BUTTON_TEXT = "Копіювати";
    public static final String CREATE_LAYER = "Створити шар";
    public static final String DATA_EXCHANGE_TEXT = "Обмін даними";
    public static final String DESCRIPTION_TEXT = "Назва";
    public static final String DISTANCE_FORMAT_TEXT = "Формат відстані";
    public static final String DISTANCE_TEXT = "На відстані: ";
    public static final String ELEVATION_GRAPH_TEXT = "Графік висоти місцевості";
    public static final String EMAIL = "Email";
    public static final String FEEDBACK_BUTTON_TEXT = "Залишити відгук";
    public static final String FRIEND_INVITE_TEXT = "Розповісти другу";
    public static final String FUNCTION_PROPOSAL_TEXT = "Запропонувати функцію";
    public static final String GENERAL_SETTINGS_TEXT = "Загальні";
    public static final String HEIGHT_TEXT = "Висота";
    public static final String LAYER_CREATION_TEXT = "Новий шар";
    public static final String LAYER_NAME_TEXT = "Введіть назву шару";
    public static final String LOGIN_BUTTON_TEXT = "Увійти";
    public static final String MAP_CENTER_TEXT = "Центр мапи";
    public static final String MAP_LABEL_TEXT = "Мапа";
    public static final String MAP_NOMENCLATURE_TEXT = "Номенклатура мапи";
    public static final String MEASUREMENT_UNITS_TEXT = "Одиниці виміру";
    public static final String MORE_TEXT = "Більше";
    public static final String NEW_OBJECT_TEXT = "Новий об'єкт";
    public static final String NOTE_TEXT = "Нотатки";
    public static final String NO_LAYERS_TEXT = "Немає шарів";
    public static final String OFFLINE_MAPS_TEXT = "Офлайн-карти";
    public static final String OPEN_WHATSAPP_TEXT = "Відкрити WhatsApp";
    public static final String PASSWORD = "Password";
    public static final String PERSONALIZATION_TEXT = "Персоналізація";
    public static final String SAVE_BUTTON_TEXT = "Зберегти";
    public static final String SEARCH_TEXT = "Пошук";
    public static final String SECURITY_TEXT = "Безпека";
    public static final String SETTINGS_TITLE_TEXT = "Налаштування";
    public static final String SHAPES_AND_OBJECTS_TEXT = "Шари та об'єкти";
    public static final String SUBSCRIBE_ACTION_TEXT = "Підписатися";
    public static final String SUPPORT_TEXT = "Підтримка";
    public static final String SYSTEM_COORDINATES_TEXT = "Система координат";
    public static final String TACTIC_MAP_PRO_TEXT = "TacticMap Pro";
    public static final String TOTAL_DISTANCE_TEXT = "Загальна відстань";
    public static final String UKROP_SYNC_BETA = "UkropSync Beta";
    public static final String UNLIMITED_LAYERS_TEXT = "Необмежені шари";
    public static final String URL_SETTINGS_LOCATOR = "URL Settings";
    public static final String MAP_RELOCATION_TEXT = "Перемістіть мапу";
    public static final String DEVIATION_TEXT = "Відхилення";
    public static final String HEIGHT_GRAPH_TEXT = "Графік висот";
    public static final String ORIGIN_TEXT = "Початкова";
    public static final String TERMINAL_TEXT = "Кінцева";
    public static final String FUNCTIONS_DISPLAY_TEXT = "Показати всі функції";
    public static final String FULL_VERSION_TEXT = "Повна версія";
    public static final String ADDITIONAL_APPS_TEXT = "Інші наші застосунки";
    public static final String FEATURES_INTRODUCTION_TEXT = "Нові функції";
    public static final String MISCELLANEOUS_TEXT = "Різне";
    public static final String PRIVACY_POLICY_TEXT = "Політика конфіденційності";
    public static final String ACCEPTABLE_USE_TEXT = "Умови використання";
    public static final String LEGAL_NOTICE_TEXT = "Юридична інформація";

    // Long strings
    public static final String API_INTEGRATION_MESSAGE = "Ми працюємо над інтеграцією API в TacticMap, і наразі цей функціонал доступний лише в рамках закритого бета-тестування.\n\nЯкщо ви хочете спробувати API та отримати доступ, зв'яжіться з нами через WhatsApp: +380933394092.\nБудемо раді співпраці та вашим відгукам!";
    public static final String AUTO_RENEWAL_NOTICE_TEXT = "План автоматично поновлюється за 99,99 грн/місяць до скасування.";
    public static final String DOWNLOAD_MAP_PROMPT_TEXT = "Карти завжди з вами — навіть там, де нема зв’язку. Завантажте потрібний фрагмент заздалегідь і використовуйте без інтернету.";
    public static final String EXPORT_IMPORT_CALLSIGN_TEXT = "Позивний допомагає визначити. хто створив шар під час експорту та імпорту тактичної обстановки";
    public static final String INFO_DESCRIPTION_TEXT = "Напишіть додаткову інформацію або резюме";
    public static final String INTEGRATION_TIP_TEXT = "Імпортуйте готові шари від колег або інших систем і миттєво інтегруйте їх у свою роботу. Ідеально для резервних копій.";
    public static final String LAYER_NAME_EXAMPLE_TEXT = "Наприклад, назвою шару може бути: “Ворог” або “Наші війська”";
    public static final String LEGAL_NOTICES_TEXT = "Умови використання та Політика конфіденційності";
    public static final String MISSION_PLANNING_TEXT = "Створюйте необмежену кількість шарів для різних завдань — від оперативного планування до детальної розвідки місцевості.";
    public static final String TOPOGRAPHY_HELP_TEXT = "Переглядайте висоту місцевості. Це допомагає швидко оцінити позиційні переваги для планування.";
    public static final String USER_CREDENTIAL_PROMPT = "Введіть дані свого облікового запису UkropSync";
    public static final String WARNING_LAYER_REQUIRED = "Перед додаванням об'єкта, необхідно створити шар";
    public static final String SHARE_BUTTON_TEXT = "Поділитися";

    // Arrays
    public final static String[] MAIN_SCREEN_ELEMENTS = {c(INFO), c(SEARCH), ZOOM_IN, ZOOM_OUT, VIEW_HOLDER, ADD_OBJECT,
            c(RULER), TOTAL_DISTANCE, c(POLYGON), ELEVATION_GRAPH, FIND_MY_LOCATION, c(COMPASS), DRAG_HANDLE, c(LOGIN),
            c(SETTINGS), SEARCH_1, SEARCH_2};

    public final static String[] AREA_FIVE_MORE_ELEMENTS = {SAVE_BUTTON_TEXT, COPY_BUTTON_TEXT, AREA_FORMAT_TEXT, DISTANCE_FORMAT_TEXT, SYSTEM_COORDINATES_TEXT};
    public final static String[] ANGLES_FIVE_MORE_ELEMENTS = {SAVE_BUTTON_TEXT, COPY_BUTTON_TEXT, ANGLES_FORMAT_TEXT, DISTANCE_FORMAT_TEXT, SYSTEM_COORDINATES_TEXT};
    public final static String[] THREE_MORE_ELEMENTS = {SHARE_BUTTON_TEXT, DISTANCE_FORMAT_TEXT, SYSTEM_COORDINATES_TEXT};


}