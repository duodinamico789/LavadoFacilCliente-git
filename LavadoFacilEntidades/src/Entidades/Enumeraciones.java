package Entidades;

import java.util.HashMap;
import java.util.Map;

public class Enumeraciones {
    
    public enum TipoEmpleado {
        Delivery(1), Supervisor(2), Mostrador(3), Interno(4), Dueño(5);
        private int value;
        private static Map<Integer, TipoEmpleado> map = new HashMap<>();
        static {
            for (TipoEmpleado _enum : TipoEmpleado.values()) {
                map.put(_enum.value, _enum);
            }
        }
        private TipoEmpleado(final int value) { this.value = value; }
        public static TipoEmpleado valueOf(int value) {
            return map.get(value);
        }
        public static TipoEmpleado valueOfStr(String value) {
            return valueOf(value);
        }
        public int getValue() { return value; }
    }
    
    public enum EstadosSolicitud {
        En_Proceso(1), Finalizada(2);
        private int value;
        private static Map<Integer, EstadosSolicitud> map = new HashMap<>();
        static {
            for (EstadosSolicitud _enum : EstadosSolicitud.values()) {
                map.put(_enum.value, _enum);
            }
        }
        private EstadosSolicitud(final int value) { this.value = value; }
        public static EstadosSolicitud valueOf(int value) {
            return map.get(value);
        }
        public int getValue() { return value; }
    }    
    
    public enum TipoMov {
        Gasto(1), Ingreso(2);
        private int value;
        private static Map<Integer, TipoMov> map = new HashMap<>();
        static {
            for (TipoMov _enum : TipoMov.values()) {
                map.put(_enum.value, _enum);
            }
        }
        private TipoMov(final int value) { this.value = value; }
        public static TipoMov valueOf(int value) {
            return map.get(value);
        }
        public int getValue() { return value; }
    }
    
    public enum OperacionPrendaExtended {
        Ninguna(0), Alta(1), Baja(2), Modificar(3);
        private int value;
        private static Map<Integer, OperacionPrendaExtended> map = new HashMap<>();
        static {
            for (OperacionPrendaExtended _enum : OperacionPrendaExtended.values()) {
                map.put(_enum.value, _enum);
            }
        }
        private OperacionPrendaExtended(final int value) { this.value = value; }
        public static OperacionPrendaExtended valueOf(int value) {
            return map.get(value);
        }
        public int getValue() { return value; }
    }
}
