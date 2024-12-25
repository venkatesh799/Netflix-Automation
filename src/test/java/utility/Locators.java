package utility;

import java.util.HashMap;
import java.util.Map;

public class Locators {

    private static final Map<String, String> xpaths = new HashMap<>();
    static {
        // HomePage Xpaths
        xpaths.put("NETFLIX", "https://www.netflix.com/");
        xpaths.put("NETFLIX_LOGO", "//span[@class = 'default-ltr-cache-0 ev1dnif0']");
        xpaths.put("HOME_SIGN_IN", "//a[contains(text(), 'Sign In')]");
        xpaths.put("EMAIL_FIELD", "//input[@id=':r0:']");
        xpaths.put("SIGN_IN_CODE", "//button[contains(text(), 'Use a sign-in code ')]");
        xpaths.put("HOMEPAGE_GETSTARTED", "//button[@data-uia = 'nmhp-card-cta+hero_card']");
        xpaths.put("LANGUAGE_DROPDOWN", "//select[@id =':Rladalalal4l:']");
        xpaths.put("SPANISH_LANGUAGE", "(//option[@label='Español'])[2]");
        xpaths.put("SPANISH_SIGNIN_BUTTON", "//a[contains(text(), 'Iniciar sesión')]");
        xpaths.put("ENGLISH_LANGUAGE","(//option[@label='English'])[2]");
        xpaths.put("TRENDING_NOW","//h2[normalize-space(text())='Trending Now']");
        xpaths.put("COUNTRY_DROP_DOWN","//select[@id =':R59l75at4l:']");
        xpaths.put("GLOBAL_OPTION","(//option[@label ='Global'])[1]");
        xpaths.put("DROP_DOWN_MOVIES","//select[@id=':R5al75at4l:']");
        xpaths.put("MOVIES_OTHER_LANGUAGE","(//option[@label='Films – other languages'])[1]");
        xpaths.put("TVSHOWS_OTHER_LANGUAGE","(//option[@label='TV programmes – English'])[1]");
        xpaths.put("KIDS_PROFILE", "//h3[normalize-space(text())= 'Create profiles for children']");

        // Signin Page Xpaths
        xpaths.put("INPUT_PASSWORD", "//input[@id=':r3:']");
        xpaths.put("FORGOT_PASSWORD", "//a[contains(text(), 'Forgot password?')]");
        xpaths.put("REMEMBER_ME_CHECK_BOX", "//input[@id = ':R1aben75:']");
        xpaths.put("NEWTONETFLIX_SIGNUP", "//p[@data-uia= 'login-signup-now']");
        xpaths.put("ENTER_VALIED_EMAIL_WARNING", "//div[@id =':r1:']");
        xpaths.put("ENTER_VALIED_PASSWORD_WARNING", "//div[@id =':r4:']");
        xpaths.put("SPANISH_SIGN_IN", "//button[contains(text(), 'Iniciar sesión')]");
        xpaths.put("SIGNIN_BUTTON", "//button[contains(text(), 'Sign In')]");
        xpaths.put("INCORRECT_PASSWORD", "//div[@class = 'default-ltr-cache-mkkf9p e191g6e31']");

        //forgot password
        //xpaths.put("RESET_BY_EMAIL", "//input[@id ='bxid_resetPasswordChoice_email']");
        xpaths.put("RESET_BY_EMAIL", "//label[@for ='bxid_resetPasswordChoice_email']");
        //xpaths.put("RESET_BY_TEXT", "//input[@id='bxid_resetPasswordChoice_text']");
        xpaths.put("RESET_BY_TEXT","//input[@data-uia='text']");
        xpaths.put("US_PHONE_ICON", "//div[@class ='ui-select-current']");
        xpaths.put("FORGOT_PASSWORD_INPUT",  "//input[@id ='forgot_password_input']");
        xpaths.put("EMAIL_ME", "//button[contains(text(), 'Email Me')]");
        xpaths.put("TEXT_ME", "//button[contains(text(), 'Text Me')]");




    }
    public static String getXpath(String elementName) {
        return xpaths.getOrDefault(elementName, "");
    }
}
