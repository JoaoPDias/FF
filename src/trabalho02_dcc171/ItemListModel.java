/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02_dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ItemListModel implements ListModel<Item>{

    private final List<Item> itens;
    private final List<ListDataListener> dataListeners;

    public ItemListModel(List<Item> itens) {
        this.itens = itens;
        this.dataListeners = new ArrayList<>();
    }

    public List<Item> getItens() {
        return itens;
    }
    
    @Override
    public int getSize() {
        return this.itens.size();
    }

    @Override
    public Item getElementAt(int index) {
        return this.itens.get(index);

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
