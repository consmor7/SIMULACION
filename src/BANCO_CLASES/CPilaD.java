package BANCO_CLASES;
public class CPilaD 
{       //Propiedades de CPilaD
    public CNodo Primero;
    protected CNodo Ultimo;
    //Constructor de CPilaD
    public CPilaD(){Primero=Ultimo=null;}
        //*****************************************
        //********   CNodo    *********************
        protected class CNodo
        {   //Propiedades de CNodo
            protected int info;
            protected CNodo ant,sig;
            //Constructor
            protected CNodo(){}
            protected CNodo(int x){this.info=x;} 
        }
        //*******************************************
    public boolean vacia(){return (Primero==null);}
    
    public void crear(int x)
    {   CNodo p=new CNodo(x);
        p.sig=p.ant=null;
        Primero=Ultimo=p;
    }
    
    public void insinicio(int x)
    {   if(vacia())
            crear(x);
        else
           {   CNodo p=new CNodo(x);
               p.ant=null;
               p.sig=Primero;
               Primero.ant=p;
               Primero=p;
           }
    }
    
    public int delinicio()
    {   int x=-1;
        if(vacia())
            return x;
        else {  x=Primero.info;
                if(Primero==Ultimo)
                        Primero=Ultimo=null;
                else { 
                        Primero=Primero.sig;
                        Primero.ant=null;
                     }
             }
        return x;
    }    
    
    @Override
    public String toString()
    {   if(vacia())
            return "No existen elementos";
        else
           {  String s="Primero-> ";
              CNodo p=Primero;
              do
              {   s=s+p.info+" ";
                  p=p.sig;
              }while(p!=null);
              s=s+"<-Ultimo";
              return s;
           }
    }
    
}
