/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

/**
 *
 * @author M.user
 */
public class Pyramid {

    /**
     * @param args the command line arguments
     */
    private String phaName;
    private String modernName;
    private String site;
    private String material;
    
    public Pyramid(String o, String m, String s, String mat){
        super();
        phaName = o;
        modernName = m;
        site = s;
        material = mat;
        
    }

 
   
 
    @Override
    public String toString(){
        return this.phaName + ", "+ this.modernName+ ", "+ this.site+", "+ this.material;
    }
    
    
    

    
}
