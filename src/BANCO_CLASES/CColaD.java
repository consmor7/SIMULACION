package BANCO_CLASES;

public class CColaD extends CPilaD
{
    public void insfinal(int x)
    {
        if(vacia())
            crear(x);
        else
            {
                CNodo p=new CNodo(x);
                p.sig=null;
                p.ant=Ultimo;
                Ultimo.sig=p;
                Ultimo=p;
            }
    }
}
