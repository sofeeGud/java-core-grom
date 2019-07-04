package lesson9.utils;

public class Checker {

    public int companyNamesValidatedCount = 0;

   public boolean checkCompanyName(String companyName){
       companyNamesValidatedCount++;
        return companyName != "Google" && companyName!="Amazon";

    }
}
