public class sinandcos extends pcharge 
{
    public double magnitude;
    public double sin;
    public double cos;
    public double angle;
    public double sinang;
    public double cosang;
    
    public sinandcos()
    {
        
        sin = 0.0;
        cos = 0.0;
        magnitude = 0.0;
        double angle =0.0;
    }
    public sinandcos(String porQ1, int l, int t, double e,double x,double y,double mag,double sinang1,double cosang1)
    {
        super(porQ1,l,t,e);
        sin = x;
        cos = y;
        magnitude =mag;
        sinang = sinang1;
        cosang = cosang1;      
    }
    public void setSinang(double r)
    {
        sinang=r;
    }
    public void setCosang(double r)
    {
        cosang=r;
    }
    public void setX1(double r)
    {
        cos=r;
    }
    public void setY1(double r)
    {
         sin=r;
    }
    public void setMag(double r)
    {
        magnitude=r;
    }
    public double getCosang()
    {
        return cosang;
    }
    public double getSinang()
    {
        return sinang;
    }
    public double getX1()
    {
        return cos;
    }
    public double getY1()
    {
        return sin;
    }
    public double getMag()
    {
        return magnitude;
    }
    public String toString()
    {
        String str = super.toString()+"\n"+"The Magnitude:"+magnitude+"\n"+"The cos:"+cosang+"\n"+"The valure of the x component of the Electical field  is:"+cos+"\n"+"The sin:"+sinang+"\n"+"The valure of the y component of the Electical field  is:"+sin;
        return str;
    }
    
}