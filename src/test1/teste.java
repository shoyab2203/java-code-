package test1;
 public class teste {
public boolean customElementWaitWithTimeoutWithProperties(WebDriver UtilDriver,By locatorWithLocation,int Timeout)
{
    WebDriver driver = UtilDriver;
    boolean elementFound=false;

    int i=1;
    try
    {

        while(i<=Timeout )
        {
            if(((Boolean.compare(elementFound,false)))==0)
            {


                List<WebElement> listOfAllMatchingElements = driver.findElements(locatorWithLocation);
                if(!(listOfAllMatchingElements.isEmpty()) && (((Boolean.compare(elementFound,false)))==0))
                {
                    if(listOfAllMatchingElements.size()>1)
                    {
                        log.info("Common Methods :customElementWaitWithTimeout: More than one element is found for given location, check the location !!");

                        elementFound=false;
                        break;
                    }
                    else if(listOfAllMatchingElements.size()==1 && (((Boolean.compare(elementFound,false)))==0))
                    {


                        log.info("Common Methods :customElementWaitWithTimeout: Element  found on "+i+" attempt !!");
                        elementFound=true;


                        break;

                    }
                }
                else if ((listOfAllMatchingElements.isEmpty()))
                {

                    log.info("Common Methods :customElementWaitWithTimeout: Element  is not found on "+i+" attempt!!");

                }
                Thread.sleep(1200);
            }
            i=i+1;
        }


    }
    catch(Exception elementFoundCheck)
    {
        log.error("Common Methods[customElementWaitWithTimeout]: Exception caught !!");
        elementFoundCheck.printStackTrace();
    }

    return elementFound;
}
