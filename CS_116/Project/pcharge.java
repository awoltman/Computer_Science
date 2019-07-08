public class pcharge extends xyplane
{
    public int r;
    public double q;
        
    public pcharge()
    {
        x = 0;
        y = 0;
        q = 0.0;
        
    }
    public pcharge(String porQ1, int l, int t, double x)
    {
        super(porQ1,l,t);
        q= x;    
    }
    public double getQ()
    {
        return q;
    }
    public void setQ(double s)
    {
        q=s;
    }
    
    public String toString()
    {
        String st = super.toString()+"\n"+ "The charge is:"+q;
        return st;
    }
    public void distance()
    {
        
    }
    public void magnitude()
    {

    }
    public void charge()
    {

    }
    
}