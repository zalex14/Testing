package zalex14.testing.constants;

public class UserTestConstants {
    /**
     * VALID login
     */
    public static final String DEFAULT_LOGIN = "ivanov";
    public static final String CORRECT_LOGIN = "ivan123";
    public static final String LOWER_CASE_LOGIN = "ivan";
    public static final String UPPER_CASE_LOGIN = "IVAN";
    public static final String NEW_USER_LOGIN = "ivan_ivanov";
    /**
     * INVALID login
     */
    public static final String EMPTY_LOGIN = "";
    public static final String NULL_LOGIN = null;
    public static final String SAME_AS_EMAIL_LOGIN = "ivan.ivanov@yandex.ru";
    public static final String ONLY_SPACES_LOGIN = "  ";
    public static final String FIRST_BRACKET_LOGIN = "(ivan";
    public static final String ILLEGAL_CHARACTERS_LOGIN = "Ivan!";
    public static final String WITH_AT_LOGIN = "ivan@ivanov";
    public static final String WITH_SPACE_LOGIN = "ivan ivanov";
    public static final String WITH_CYRILLIC_LETTERS_LOGIN = "ivаn.ivаnоv";
    public static final String WITH_SCRIPT_LOGIN = "<script>ivan</script>ivanov";
    public static final String WITH_CURLY_BRACE_LOGIN = "{ivan}ivanov";

    /**
     * VALID e-mail
     */
    public static final String DEFAULT_EMAIL = "ivan.ivanov@yandex.ru";
    public static final String CORRECT_EMAIL = "ivanov1234@yandex.ru";
    public static final String LOWER_CASE_EMAIL = "ivan@yandex.ru";
    public static final String UPPER_CASE_EMAIL = "IVAN@YANDEX.RU";
    public static final String WITH_IP_ADDRESS_EMAIL = "ivan@213.180.223.192";

    /**
     * INVALID e-mail
     */
    public static final String EMPTY_EMAIL = "";
    public static final String NULL_EMAIL = null;
    public static final String ONLY_SPACES_EMAIL = "  ";
    public static final String SAME_AS_LOGIN_EMAIL = "ivan.ivanov";
    public static final String WITHOUT_AT_EMAIL = "ivan.ivanov.yandex.ru";
    public static final String WITHOUT_POINT_EMAIL = "ivan@yandex_ru";
    public static final String ILLEGAL_CHARACTERS_EMAIL = "ivan)ivanov@yandex.ru";
    public static final String ONLY_POINT_LOGIN_EMAIL = ".@yandex.ru";
    public static final String WITHOUT_LOGIN_EMAIL = "@yandex.ru";
    public static final String WITHOUT_DOMAIN_EMAIL = "ivan.ivanov@";
    public static final String WITHOUT_UPPER_DOMAIN_EMAIL = "ivan.ivanov@yandex";
}