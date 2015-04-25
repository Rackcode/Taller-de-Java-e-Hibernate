/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumnos;
import Modelo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alonso Campos
 */
public class AlumnosController {
    public static boolean AlumnosAdd(String nombre,String apellidos, int edad){
        Session sesion = HibernateUtil.getSessionFactory().openSession();  
        sesion.beginTransaction();
        Alumnos alumno = new Alumnos();
            
        try {
            alumno.setNombre(nombre);
            alumno.setApellidos(apellidos);
            alumno.setEdad(edad);
            sesion.save(alumno);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    public static boolean AlumnosDelete(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
        Alumnos busqueda =  (Alumnos) sesion.createCriteria(Alumnos.class)
                    .add(Restrictions.eq("id", id)).uniqueResult();
        sesion.delete(busqueda);
        sesion.getTransaction().commit();
        return true;
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    public static boolean AlumnosUpdate(int id, String nombre,String Apellidos, int edad){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
        Alumnos busqueda =  (Alumnos) sesion.createCriteria(Alumnos.class)
                    .add(Restrictions.eq("id", id)).uniqueResult();
        busqueda.setApellidos(Apellidos);
        busqueda.setNombre(nombre);
        busqueda.setEdad(edad);
        sesion.update(busqueda);
        sesion.getTransaction().commit();
        return true;
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    
    
    
}
