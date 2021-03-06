/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02_dcc171;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author pedrofreitas
 */
public class PedidoListModel implements ListModel<Pedido> {

    private final List<Pedido> pedidos;
    private final List<ListDataListener> dataListeners;
    private PedidoDAO pedidosDAO;

    public PedidoListModel(Mesa mesa) throws IOException {
        this.pedidosDAO = new PedidoDAO(mesa);
        this.pedidos = pedidosDAO.getPedidos();
        dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return this.pedidos.size();
    }

    @Override
    public Pedido getElementAt(int index) {
        if (!pedidos.isEmpty()) {
            return this.pedidos.get(index);
        }
        return null;
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }


}
