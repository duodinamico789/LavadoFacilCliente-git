package Entidades.Objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BrechaHoraria implements Serializable {
    private Date horaInicio;
    private Date horaFin;
    private String diasVigencia;
    private int limitees;
    private boolean noDisponible;

    public BrechaHoraria() {
    }

    public BrechaHoraria(Date horaInicio, Date horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public BrechaHoraria(Date horaInicio, Date horaFin, int limitees, boolean noDisponible) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.limitees = limitees;
        this.noDisponible = noDisponible;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getHoraInicioStr() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(horaInicio);
    }

    public String getHoraFinStr() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(horaFin);
    }
    
    public String getDiasVigencia() {
        return diasVigencia;
    }
    
    public String[] getDiasVigenciaSeparados() {
        return diasVigencia.split(",");
    }

    public void setDiasVigencia(String _diasVigencia) {
        this.diasVigencia = _diasVigencia;
    }
    
    public int getLimitees() {
        return limitees;
    }

    public void setLimitees(int limitees) {
        this.limitees = limitees;
    }

    public boolean getNoDisponible() {
        return noDisponible;
    }

    public void setNoDisponible(boolean noDisponible) {
        this.noDisponible = noDisponible;
    }    

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
            
        String[] dias = this.getDiasVigenciaSeparados();
        for(String dia : dias) {
            value.append(dia.substring(0, 2)).append(", ");
        }

        value.delete(value.length(), value.length() - 2);
        value.append("; ");
        value.append("HI: " + this.getHoraInicioStr() + " - HF: " + this.getHoraFinStr());
        return value.toString();
    }
    
    
}
