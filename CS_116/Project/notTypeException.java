public class notTypeException extends Exception
{
    public notTypeException()
    {
        super();
    }
    public String getMessage()
    {
        String str = "The information in the file is incorrect";
        return str;
    }
    public String toString()
    {
        return "notTypeException exception was thrown";
    }
}