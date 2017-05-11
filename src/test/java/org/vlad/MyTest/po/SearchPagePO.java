package org.vlad.MyTest.po;

import org.openqa.selenium.By;

public class SearchPagePO extends AbstractPO {
    private By searchJobsField = By.id("search");
    private By searchCityField = By.className("js-main-region");
    private By searchButton = By.className("btn-search");

    public SearchPagePO typeJobName(String jobName){
        sendKeys(searchJobsField, jobName);
        return this;
    }

    public SearchPagePO typeCity(String cityName){
        sendKeys(searchCityField, cityName);
        return this;
    }

    public SearchResultsPagePO clickSearchButton(){
        click(searchButton);
        //action that redirects to another Page should return new PagePo
        //if doesn't redirect - just return this;
        return new SearchResultsPagePO();

    }
}
