
package alumnos;

import java.util.ArrayList;


public class CargaDiscos {
    private String info;
    private Tienda new_Disco = new Tienda();
    private Archivo archivo;
    private ArrayList<Tienda> arreglo = new ArrayList<>();
    
 
    public CargaDiscos(String archivo){
        this.archivo= new Archivo(archivo);
        this.info = this.archivo.Leer();
        if(!info.isEmpty()){
            do{
                new_Disco.setGenero(info.substring(0, info.indexOf(";")));
                info=info.substring(info.indexOf(";")+1);
                new_Disco.setGenero((
                         info.substring(0, info.indexOf(";"))));
                info=info.substring(info.indexOf(";")+1);
                new_Disco.setPrecioVenta(
                        info.substring(0, info.indexOf("\n")==-1?
                        info.length():info.indexOf("\n")));
                info=info.substring(info.indexOf("\n")==-1?
                        info.length():info.indexOf("\n")+1);
                arreglo.add(new Tienda(new_Disco.getGenero(),
                        new_Disco.getGenero(), new_Disco.getPrecioVenta()));
            }while(info.length()>0);
        }
    }

    public Tienda Consulta(int pos){
        return pos>=0 && pos<arreglo.size()?arreglo.get(pos):null;
    }
  
    public int BuscaAlumno(Tienda alumno){
        return arreglo.isEmpty()?-1:arreglo.indexOf(alumno);
    }
   
    public int BuscaNombre(String Nombre){
        boolean ban=false;
        int pos = 0;
        for(int cont=0; cont!=arreglo.size(); cont++){
            if (arreglo.get(cont).getGenero().toUpperCase().equals(Nombre.toUpperCase())){
                ban=true;
                pos=cont;
            }
            System.out.println("#"+arreglo.get(cont).getGenero().toUpperCase()+"#");
        }
        return ban?pos:-1;
    }
  
    public boolean Alta(Tienda alumno){
        return arreglo.add(alumno);
    }
 
    public boolean Alta(String Genero, String Interprete, String Album){
        return arreglo.add(new Tienda(Genero,PrecioUnitario,));
    }
   
    public boolean Baja(Tienda alumno){
        return arreglo.remove(alumno);
    }
  
    public boolean Baja(int pos){
        new_Disco=arreglo.get(pos);
        return Baja(new_Disco);
    }
  
    public int Tamaño(){
        return arreglo.size();
    }
 
    public boolean Guardar(){
         String cambios = "";
         for (int cont=0; cont!=Tamaño();cont++){
             cambios=cambios+Consulta(cont).toString()+"\n";
         }
         return archivo.Escribir(cambios, false);
    }
}
