package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.primefaces.model.UploadedFile;


public class CargarArchivo {
    public String capturaArchivo(UploadedFile archivo, String destino){
    String nombreArchivo="";
    if(archivo != null){
        nombreArchivo= archivo.getFileName();
        System.out.print("El nombre del archivo es:: "+nombreArchivo+ "Tamaño de Archivo::"+archivo.getSize());
        try{
            copyFile(archivo.getFileName(), archivo.getInputstream(), destino);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
        return nombreArchivo;
    }
    
    public void copyFile(String nombreArchivo, InputStream in, String destino) throws FileNotFoundException, IOException{
        try{
            OutputStream out= new FileOutputStream(new File(destino+nombreArchivo));
            int read=0;
            byte[] bytes= new byte[1024];
            while ((read = in.read(bytes)) != -1){
                out.write(bytes,0,read);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}
