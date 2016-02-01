package Entidades.Datatypes;

import Entidades.Enumeraciones.TipoMov;
import javax.swing.JFrame;

public class FrameMovInfo {
    private TipoMov TipoMovListado;
    private JFrame PadreFrame;

    public FrameMovInfo() { }
    
    public TipoMov getTipoMovListado() {
        return TipoMovListado;
    }

    public void setTipoMovListado(TipoMov TipoMovListado) {
        this.TipoMovListado = TipoMovListado;
    }

    public void setPadreFrame(JFrame PadreFrame) {
        this.PadreFrame = PadreFrame;
    }
    
    public JFrame getPadreFrame() {
        return PadreFrame;
    }
    
}
