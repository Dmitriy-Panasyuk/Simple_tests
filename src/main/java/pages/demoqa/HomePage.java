package pages.demoqa;

import static common.CommonActions.getDriver;

public class HomePage implements Page {
    public static String url = URLs.HOME;

    public HomePage() {
    }

    @Override
    public Page open() {
        getDriver().get(url);
        return this;
    }

}
