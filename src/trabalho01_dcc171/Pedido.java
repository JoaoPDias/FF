
package trabalho01_dcc171;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.util.converter.LocalDateTimeStringConverter;


public class Pedido {
    private LocalTime horaAbertura = LocalTime.now();
    private String horaAbriu;
    private String horaFechou;
    private LocalTime horaFechamento;
    private int numPedido = 0;
    private List<Item> itens;
    private boolean conta; // enquanto for true, podem ser adicionados mais itens ao pedido.

    public Pedido() {    
        horaAbriu = horaAbertura.toString();
        this.conta = true;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public boolean isConta() {
        return conta;
    }

    public void setConta(boolean conta) {
        this.conta = conta;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public int getNumPedido() {
        return numPedido;
    }

    @Override
    public String toString() {
        return "Pedido "+this.numPedido+ "|| Hora de Abertura: " + this.horaAbriu;
    }
    
    
    
}
