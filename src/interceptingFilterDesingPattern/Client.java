package interceptingFilterDesingPattern;

import exceptions.RegisterException;

public class Client {
   FilterManager filterManager;

   public void setFilterManager(FilterManager filterManager){
      this.filterManager = filterManager;
   }

   public void sendRequest(String[] chain) throws RegisterException{
      filterManager.filterRequest(chain);
   }
}