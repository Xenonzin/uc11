
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarVendidos();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos Vendidos");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "Valor", "Status"}
        ));

        jScrollPane1.setViewportView(tabela);

        add(jScrollPane1);
        setSize(500,300);
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;

    private void listarVendidos(){
        ProdutosDAO dao = new ProdutosDAO();
        ArrayList<ProdutosDTO> lista = dao.listarProdutosVendidos();

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);

        for(int i = 0; i < lista.size(); i++){
            model.addRow(new Object[]{
                lista.get(i).getId(),
                lista.get(i).getNome(),
                lista.get(i).getValor(),
                lista.get(i).getStatus()
            });
        }
    }
}
