package com.grupo3.Caso1.Model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

/*@SqlResultSetMapping(name = "misHeviculos",classes = {
		@ConstructorResult(targetClass = MisVehiculos.class,
				columns = {
						@ColumnResult(name="chasis_vehiculo"),
						@ColumnResult(name="links_imagen"),
						@ColumnResult(name="marca"),
						@ColumnResult(name="modelo")
				})
})*/
public class MisVehiculos {

    private String chasis_vehiculo;
    private String links_imagen;
    private String marca;
    private String modelo;

    public MisVehiculos(String chasis_vehiculo, String links_imagen, String marca, String modelo) {
        this.chasis_vehiculo = chasis_vehiculo;
        this.links_imagen = links_imagen;
        this.marca = marca;
        this.modelo = modelo;
    }

    public MisVehiculos() {
    }

    /**
     * @return String return the chasis_vehiculo
     */
    public String getChasis_vehiculo() {
        return chasis_vehiculo;
    }

    /**
     * @param chasis_vehiculo the chasis_vehiculo to set
     */
    public void setChasis_vehiculo(String chasis_vehiculo) {
        this.chasis_vehiculo = chasis_vehiculo;
    }

    /**
     * @return String return the links_imagen
     */
    public String getLinks_imagen() {
        return links_imagen;
    }

    /**
     * @param links_imagen the links_imagen to set
     */
    public void setLinks_imagen(String links_imagen) {
        this.links_imagen = links_imagen;
    }

    /**
     * @return String return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return String return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}