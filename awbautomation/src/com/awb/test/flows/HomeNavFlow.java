package com.awb.test.flows;

import com.awb.test.pages.AdhocAnalysisPage;
import com.awb.test.pages.HomePage;
import com.awb.test.pages.InsightsPage;
import com.awb.test.pages.PortfolioOverviewPage;
import com.awb.test.pages.PortfolioWCPage;
import com.awb.test.pages.ReportingPage;
import com.awb.test.pages.SearchPage;

/**
 * This flow class provide navigation to different list page from the HomePage
 * @author sshyamala 
 */
public class HomeNavFlow {

	// From the Home Page, go to PortfolioOverviewPage
	public static PortfolioOverviewPage goToPortfolioOverview(HomePage hPage)	{
		
		hPage.ClickPortfolioOverviewLink();        
        return new PortfolioOverviewPage(hPage);
	}
	
	// From the Home Page, go to PortfolioWCPage
	public static PortfolioWCPage goToPortfolioWC(HomePage hPage)
	{
		hPage.ClickPortfolioWCLink();        
        return new PortfolioWCPage(hPage);
	}
	
	// From the Home Page, go to InsightsPage
	public static InsightsPage goToInsights(HomePage hPage)
	{		
		
		hPage.ClickInsightsLink();        
        return new InsightsPage(hPage);
	}	
	
	// From the Home Page, go to AdhocAnalysisPage
	public static AdhocAnalysisPage goToAdhocAnalysis(HomePage hPage)
	{
		hPage.ClickAdhocAnalysisLink();
		return new AdhocAnalysisPage(hPage);
	}
	
	// From the Home Page, go to ReportingPage
	public static ReportingPage goToReporting(HomePage hPage)
	{
		hPage.ClickReportingLink();
		return new ReportingPage(hPage);
	}
	
	// From the Home Page, go to goToSearchPage	
	public static SearchPage goToSearchPage(HomePage hPage)
	{		
		hPage.ClickSearchLink();	
		return new SearchPage(hPage);
	}
	
}
