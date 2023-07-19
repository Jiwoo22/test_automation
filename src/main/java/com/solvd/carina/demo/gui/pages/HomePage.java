//package com.solvd.carina.demo.gui.pages;
//
//import com.solvd.carina.demo.gui.components.HeaderMenu;
//import com.solvd.carina.demo.gui.components.WeValuePrivacyAd;
//import com.solvd.carina.demo.gui.components.footer.FooterMenu;
//import com.solvd.carina.demo.gui.pages.ios.BrandModelsPage;
//import com.zebrunner.carina.utils.R;
//import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
//import com.zebrunner.carina.webdriver.gui.AbstractPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//
//import java.lang.module.Configuration;
//import java.util.List;
//import java.util.logging.Logger;
//
//public class HomePage extends AbstractPage {
//
//    private static final Logger LOGGER = Logger.getLogger(HomePage.class);
//
//    @FindBy(id = "header")
//    private HeaderMenu header;
//
//    @FindBy(id = "footmenu")
//    private FooterMenu footerMenu;
//
//    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
//    private List<ExtendedWebElement> brandLinks;
//
//    private ExtendedWebElement newsColumn;
//
////    private PhoneFinderMenu phoneFinderBlock;
//
//    public HomePage(WebDriver driver) {
//        super(driver);
//        setUiLoadedMarker(newsColumn);
//        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
//    }
//
//    public FooterMenu getFooterMenu() {
//        return footerMenu;
//    }
//
//    public HeaderMenu getHeaderMenu() {
//        return header;
//    }
//
////    public PhoneFinderMenu getPhoneFinderMenu() {
////        return phoneFinderBlock;
////    }
//
//    public BrandModelsPage selectBrand(String brand) {
//        LOGGER.info("selecting '" + brand + "' brand...");
//        for (ExtendedWebElement brandLink : brandLinks) {
//            String currentBrand = brandLink.getText();
//            LOGGER.info("currentBrand: " + currentBrand);
//            if (brand.equalsIgnoreCase(currentBrand)) {
//                brandLink.click();
//                return new BrandModelsPage(driver);
//            }
//        }
//        throw new RuntimeException("Unable to open brand: " + brand);
//    }
//
//    public WeValuePrivacyAd getWeValuePrivacyAd() {
//        return new WeValuePrivacyAd();
//    }
//
////    public boolean isPhoneFinderBlockPresent() {
////        return phoneFinderBlock.isUIObjectPresent();
////    }
//}
