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
    public void setPhaName(String phaName) {
        this.phaName = phaName;
    }

    public void setModernName(String modernName) {
        this.modernName = modernName;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    

    public String getPhaName() {
        return phaName;
    }

    public String getModernName() {
        return modernName;
    }

    public String getSite() {
        return site;
    }

    public String getMaterial() {
        return material;
    }
    

 

 
   
 
    @Override
    public String toString(){
        return this.phaName + ", "+ this.modernName+ ", "+ this.site+", "+ this.material;
    }
    
    
    

    
}
