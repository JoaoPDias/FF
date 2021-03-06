
package trabalho02_dcc171;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class GeradorDePedido {
    private File arq;
    
    private Mesa mesa;

    public GeradorDePedido(Mesa mesa) {
        this.mesa = mesa;
        arq =new File("Dados\\Gerador", "GeradorPedido "+this.mesa.getDescricaoMesa()+" .txt");
    }
    

    public File getArq() {
        
        return arq;
    }

    public Integer getIDPedido() throws FileNotFoundException, IOException {
        if (!this.getArq().exists()) {
            this.getArq().createNewFile();
        }
        FileReader fr = new FileReader(this.getArq());
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        Integer id;
        try {
            id = Integer.parseInt(s);
            br.close();
            fr.close();
            this.addIDPedido(id);
        } catch (NumberFormatException ex) {
            br.close();
            fr.close();
            this.addIDPedido(1);
            id = 1;
        }
        return id;
    }

    public void addIDPedido(Integer id) throws IOException {
        id++;
        if (!this.getArq().exists()) {
            this.getArq().createNewFile();
        }
        FileWriter fw = new FileWriter(this.getArq());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(id.toString());
        bw.close();
        fw.close();

    }
}
