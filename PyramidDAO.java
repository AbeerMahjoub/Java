/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author M.user
 */
public class PyramidDAO {
    List<Pyramid> pyramids;
    
    public PyramidDAO(String file){
        
        pyramids = new ArrayList<Pyramid>();
        File f = new File(file);
        List<String> lines = new ArrayList<String>();
        
        try {
            lines = Files.readAllLines(f.toPath());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        for (int i=1; i< lines.size(); i++){
            String line = lines.get(i).replaceAll("[\\)(?]", "");
            String[] fields = line.split(",");
   
            Pyramid p = new Pyramid(fields[0], fields[2], fields[4], fields[14]);
            pyramids.add(p);
            
        }
            
        }
    public void showFirstFive(){
       for(int j =0; j<5; j++){
           System.out.println(pyramids.get(j).toString());
       }
   
    }
    public static void main(String[] args){
        PyramidDAO dao = new PyramidDAO("pyramids.csv");
        dao.showFirstFive();
        
    }
    
}
