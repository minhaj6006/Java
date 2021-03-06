class CurrencyConverter
{
    double[] exchangeRates = { 63.0, 3.0, 3.0, 595.5, 18.0, 107.0, 2.0 };

    void setExchangeRates(double[] rates)
    {
        exchangeRates = rates;
    }

    double getExchangeRate(int countryIndex)
    {
        return exchangeRates[countryIndex];
    }

    double computeTransferAmount(int countryIndex, double amount)
    {
        return amount * getExchangeRate(countryIndex);
    }

    void printCurrencies()
    {
        System.out.println("rupee: " + exchangeRates[0]);
        System.out.println("dirham: " + exchangeRates[1]);
        System.out.println("real: " + exchangeRates[2]);
        System.out.println("chilean_peso: " + exchangeRates[3]);
        System.out.println("mexican_peso: " + exchangeRates[4]);
        System.out.println("_yen: " + exchangeRates[5]);
        System.out.println("$australian: " + exchangeRates[exchangeRates.length - 1]);
    }
}

class MoneyTransferService
{
    CurrencyConverter cc = new CurrencyConverter();
    double computeTransferAmount(int countryIndex, double amount)
    {
        return cc.getExchangeRate(countryIndex) *amount;
    }
    public static void main(String args[])
    {
        CurrencyConverter cc = new CurrencyConverter();
        MoneyTransferService transferService = new MoneyTransferService();
        double transferAmount = transferService.computeTransferAmount(0, 1000);
        double transferFee = transferAmount * 0.02;
        cc.printCurrencies();
        System.out.println("\nTransfer Amount: " + transferAmount);
        System.out.println("Transfer Fee: " + transferFee);
    }
}