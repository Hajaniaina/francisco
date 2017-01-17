/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

/**
 *
 * @author User
 */
public class calculRetardAbsSuppl 
{
    public double calculRetard(double salair,int retard)
    {
        double shm=new calculRetardAbsSuppl().calculSalaireHorraireMoyer(salair);
        return retard*shm;
    }
    public double calculAbs(double salair,int abs)
    {
        double shm=new calculRetardAbsSuppl().calculSalaireHorraireMoyer(salair);
        return abs*shm;
    }
    public double calculSupplementaire(double salair,int hsup)
    {
         double shm=new calculRetardAbsSuppl().calculSalaireHorraireMoyer(salair);
        return hsup*shm;
    }
    
    public double calculSalaireHorraireMoyer(double salaire)
    {
        return salaire/173.33;
    }
}
