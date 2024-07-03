package vitals;
class Battery 
{
    private float temperature;
    private float soc;
    private float chargeRate;
    public Battery(float temperature, float soc, float chargeRate)
    {
        this.temperature=temperature;
        this.soc=soc;
        this.chargeRate=chargeRate;
    }
    public float getTemperature()
    {
        return temperature();
    }
    public float getSoc()
    {
        return soc();
    }
    public float getChargeRate()
    {
        return chargeRate();
    }
}     
class BatteryChecker
    {
    private static final float min_temp=0;
    private static final float max_temp=45;
    private static final float min_soc=20;
    private static final float max_soc=80;
    private static final float max_chargeRate=0.8f;
    public static boolean isBatteryOk(Battery battery)
    {
        boolean temperatureOk= checkTemperature(battery.getTemperature());
        boolean socOk= checkSoc(battery.getSoc());
        boolean chargeRateOk= checkChargeRate(battery.getChargeRate());
        return temperatureOk&&socOk&&chargeRateOk;
    }
    private static boolean checkTemperature(float temperature)
    {
        if(temperature<min_temp || temperature>max_temp)
        {
            System.out.println("Temperature is beyond the range");
            return false;
        }
        return true;
    }
    private static boolean checkSoc(float soc)
    {
        if(soc<min_soc || soc>max_soc)
        {
            System.out.println("SOC is beyond the range");
            return false;
        }
        return true;
    }
     private static boolean checkChargeRate(float chargeRate)
    {
        if(chargeRate>max_chargeRate)
        {
            System.out.println("ChargeRate is beyond the range");
            return false;
        }
        return true;
    }
}
    
public class Main {
    public static void main(String[] args) 
    {
        Battery battery123 = new Battery(25,70,0.7f);
        Battery battery456 = new Battery(50,85,0.0f);
        assert(!BatteryChecker.isBatteryOk(battery123));
        assert(!BatteryChecker.isBatteryOk(battery456));

        System.out.println("Some more tests are needed");
    }
}
