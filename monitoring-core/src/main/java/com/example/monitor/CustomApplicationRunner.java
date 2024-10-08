package com.example.monitor;

import com.example.monitor.chrome.ChromeDriverTool;
import com.example.monitor.chrome.ChromeDriverToolFactory;
import com.example.monitor.infra.discord.DiscordBot;
import com.example.monitor.infra.s3.S3UploaderService;
import com.example.monitor.monitoring.biffi.BiffiMonitorCore;
import com.example.monitor.monitoring.dobulef.DoubleFMonitorCore;
import com.example.monitor.monitoring.gebnegozi.GebenegoziMonitorCore;
import com.example.monitor.monitoring.julian.JulianMonitorCore;
import com.example.monitor.monitoring.julian.JulianProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

import static com.example.monitor.monitoring.biffi.BiffiFindString.BIFFI;
import static com.example.monitor.monitoring.biffi.BiffiFindString.BIFFI_LOG_PREFIX;
import static com.example.monitor.monitoring.dobulef.DoubleFFindString.DOUBLE_F;
import static com.example.monitor.monitoring.dobulef.DoubleFFindString.DOUBLE_F_LOG_PREFIX;
import static com.example.monitor.monitoring.gebnegozi.GebenegoziProdcutFindString.GEBE;
import static com.example.monitor.monitoring.gebnegozi.GebenegoziProdcutFindString.GEBENE_LOG_PREFIX;
import static com.example.monitor.monitoring.julian.JulianFindString.*;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile("!test")
public class CustomApplicationRunner implements ApplicationRunner {

    private final ChromeDriverToolFactory chromeDriverToolFactory;


    private final JulianMonitorCore julianMonitorCore;

    private final DoubleFMonitorCore doubleFMonitorCore;

    private final BiffiMonitorCore biffiMonitorCore;

    private final GebenegoziMonitorCore gebenegoziMonitorCore;

    private final DiscordBot discordBot;

    private final S3UploaderService s3UploaderService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

//        chromeDriverToolFactory.makePrivateChromeDriverTool("test");
//
//        ChromeDriverTool chromeDriverTool = chromeDriverToolFactory.getChromeDriverTool("test");
//
//        ChromeDriver driver = chromeDriverTool.getChromeDriver();
//        WebDriverWait wait = chromeDriverTool.getWebDriverWait();
//
//        driver.get("https://stores.antonioli.eu");


//        chromeDriverToolFactory.makeChromeDriverTool(DOUBLE_F);
//        chromeDriverToolFactory.makeChromeDriverTool(ALL_CATEGORIES);
//        chromeDriverToolFactory.makeChromeDriverTool(PROMO);
//        chromeDriverToolFactory.makeChromeDriverTool(BIFFI);
//        chromeDriverToolFactory.makeChromeDriverTool(GEBE);
//        discordBot.setChromeDriverTool(chromeDriverToolFactory);
//        discordBot.setS3UploaderService(s3UploaderService);
//
//
//        Thread gebeneThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                log.info(GEBENE_LOG_PREFIX + "============================ Load GEBENE Product Start ============================");
//                ChromeDriverTool chromeDriverTool = chromeDriverToolFactory.getChromeDriverTool(GEBE);
//                gebenegoziMonitorCore.runLoadLogic(chromeDriverTool);
//                log.info(GEBENE_LOG_PREFIX + "============================ Load GEBENE Product Finish ============================");
//            }
//        });
//
//        gebeneThread.start();
//
//        Thread biffiThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                log.info(BIFFI_LOG_PREFIX + "============================ Load BIFFI Product Start ============================");
//                ChromeDriverTool chromeDriverTool = chromeDriverToolFactory.getChromeDriverTool(BIFFI);
//                biffiMonitorCore.runLoadLogic(chromeDriverTool);
//                log.info(BIFFI_LOG_PREFIX + "============================ Load BIFFI Product Finish ============================");
//            }
//        });
//
//        biffiThread.start();
//
//
//        Thread doubleFThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ChromeDriverTool chromeDriverTool = chromeDriverToolFactory.getChromeDriverTool(DOUBLE_F);
//                log.info(DOUBLE_F_LOG_PREFIX + "============================ Load DOUBLE_F Product Start ============================");
//                doubleFMonitorCore.runLoadLogic(chromeDriverTool);
//                log.info(DOUBLE_F_LOG_PREFIX + "============================ Load DOUBLE_F Product Finish ============================");
//            }
//        });
//        doubleFThread.start();
//
//
//        Thread julianThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                log.info(JULIAN_LOG_PREFIX + "============================ Load Julian Product Start ============================");
//                try {
//                    //로그인
//                    ChromeDriverTool chromeDriverTool = chromeDriverToolFactory.getChromeDriverTool(ALL_CATEGORIES);
//
//                    ChromeDriver chromeDriver = chromeDriverTool.getChromeDriver();
//                    WebDriverWait wait = chromeDriverTool.getWebDriverWait();
//                    HashMap<String, JulianProduct> brandHashMap = julianMonitorCore.getJulianBrandHashData().getBrandHashMap(ALL_CATEGORIES);
//
//
//                    julianMonitorCore.login(chromeDriver, wait);
//
//                    for (int i = 1; i < 3; i++) {
//                        String url = julianMonitorCore.getUrl(ALL_CATEGORIES_URL, i);
//                        //페이지 이동
//                        julianMonitorCore.changeUrl(chromeDriver, url);
//
//                        //하위 데이터
//                        List<WebElement> productDataDivs = julianMonitorCore.getInnerProductDivs(wait);
//
//                        //상품 하위 데이터 조회
//                        List<JulianProduct> productData = julianMonitorCore.getProductData(productDataDivs, url);
//
//                        //정보가져오기
//                        julianMonitorCore.loadData(brandHashMap, productData);
//
//                    }
//                    //로드체크
//                    chromeDriverTool.isLoadData(true);
//                    log.info(JULIAN_LOG_PREFIX + "== ALL CATEGORIES LOAD DATA FINISH ==");
//                } catch (Exception e) {
//                    log.error(JULIAN_LOG_PREFIX + "All Category Data Load Error");
//                    e.printStackTrace();
//                }
//
//
//                try {
//                    //로그인
//                    ChromeDriverTool chromeDriverTool = chromeDriverToolFactory.getChromeDriverTool(PROMO);
//                    ChromeDriver chromeDriver = chromeDriverTool.getChromeDriver();
//                    WebDriverWait wait = chromeDriverTool.getWebDriverWait();
//                    HashMap<String, JulianProduct> brandHashMap = julianMonitorCore.getJulianBrandHashData().getBrandHashMap(PROMO);
//
//                    julianMonitorCore.login(chromeDriver, wait);
//
//                    for (int i = 1; i < 3; i++) {
//                        String url = julianMonitorCore.getUrl(PROMO_URL, i);
//                        //페이지 이동
//                        julianMonitorCore.changeUrl(chromeDriver, url);
//
//                        //하위 데이터
//                        List<WebElement> productDataDivs = julianMonitorCore.getInnerProductDivs(wait);
//
//                        //상품 하위 데이터 조회
//                        List<JulianProduct> productData = julianMonitorCore.getProductData(productDataDivs, url);
//
//                        //정보가져오기
//                        julianMonitorCore.loadData(brandHashMap, productData);
//
//                    }
//                    //Load 확인
//                    chromeDriverTool.isLoadData(true);
//                    log.info(JULIAN_LOG_PREFIX + "== PROMO LOAD DATA FINISH ==");
//                } catch (Exception e) {
//                    log.error(JULIAN_LOG_PREFIX + "== PROMO LOAD DATA ERROR ==");
//                    e.printStackTrace();
//                }
//
//                log.info(JULIAN_LOG_PREFIX + "============================ Load Julian Product Finish ============================");
//            }
//        });
//
//        julianThread.start();


    }
}
