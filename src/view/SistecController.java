/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos
 */
public class SistecController extends AbstractTableModel {

    private String[] cabecalho;
    private List dados;
    private String separador = ";";

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho.split(separador);
    }

    public String[] getCabecalho() {
        return cabecalho;
    }

    public void setDados(List dados) {
        this.dados = dados;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }

    @Override
    public int getRowCount() {
        if (this.dados == null) {
            return 0;
        } else {
            return this.dados.size();
        }
    }

    @Override
    public int getColumnCount() {
        if (this.cabecalho == null) {
            return 0;
        } else {
            return this.cabecalho.length;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String linha = (String) dados.get(rowIndex);
        String[] campos = linha.split(separador);
        return campos[columnIndex].replaceAll("\"", "");
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.cabecalho[columnIndex].replaceAll("\"", "");
    }

}
