package org.vlad.MyTest.po;

import org.openqa.selenium.By;

import java.util.ArrayList;

/**
 * Created by Vlad on 08.05.2017.
 */
public class SearchResultsPagePO extends AbstractPO {
    private By recentDropdown = By.id("dropdownMenu1");
    private By resultsItems = By.cssSelector("#center .col-left .card h2 a");

    private By dropdownItem(Integer item) {
        String itemLocator = ".dropdown-menu > li:nth-child(" + item + ")";
        return By.cssSelector(itemLocator);
    }

    public SearchResultsPagePO clickRecentDropdown() {
        click(recentDropdown);
        return this;
    }

    public SearchResultsPagePO clickDropdownItem(Integer item) {
        click(dropdownItem(item));
        return this;
    }

    public SearchResultsPagePO printResults() {
        ArrayList<String> contentValues = getElementsTextContentValues(resultsItems);
        ArrayList<String> visibleValues = getElementsTextVisibleValues(resultsItems);
        for (Integer i = contentValues.size()-1; i >= 0; i--) {
            System.out.println(i.toString() + ": " + contentValues.get(i));
        }
        for (Integer i = 0; i < visibleValues.size(); i++) {
            System.out.println(i.toString() + "- " + visibleValues.get(i));
        }
        return this;
    }

}