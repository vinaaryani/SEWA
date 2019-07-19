/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sewa;

/**
 *
 * @author Acer
 */

//memanggil library/api yang diperlukan
import Koneksi.koneksidb;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;


public class formtransaksikembali extends javax.swing.JFrame {

    //membuat objek    
    private DefaultTableModel model;
    
    //deklarasi variabel
    String id_pengembalian, id_peminjam, id_petugas, id_penyewa, id_kamera, merk_kamera, jaminan_pinjam, tanggal_pinjam, tanggal_kembali, strharga_sewa, strdenda, strlama_sewa, strtotal_bayar;
    Double harga_sewa, denda, lama_sewa, total_bayar;
    /**
     * Creates new form formtransaksikembali
     */
    public formtransaksikembali() {
        initComponents();
        
        //membuat obyek
        model = new DefaultTableModel();
        
        //memberi nama header pada tabel
        tabelpengembalian.setModel(model);
        model.addColumn("ID PENGEMBALIAN");
        model.addColumn("ID PEMINJAM");
        model.addColumn("ID PETUGAS");
        model.addColumn("ID PENYEWA");
        model.addColumn("ID KAMERA");
        model.addColumn("MERK KAMERA");
        model.addColumn("JAMINAN PINJAM");
        model.addColumn("TANGGAL PINJAM");
        model.addColumn("TANGGAL KEMBALI");
        model.addColumn("LAMA SEWA");
        model.addColumn("HARGA SEWA");
        model.addColumn("DENDA");
        model.addColumn("TOTAL BAYAr");
        
        cbidpeminjam();
        
        getDataPengembalian();
    }
    
    public void getDataPengembalian(){
        //kosongkan tabel
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        //eksekusi koneksi dan kirimkan query ke database
        try{
            //tes koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            
            //perintah sql untuk membaca data dari tabel kategori        
            String sql = "SELECT * FROM pengembalian";
            ResultSet res = stat.executeQuery(sql);
            
            //baca data
            while(res.next()){
                //membuat obyek berjenis array
                Object[] obj = new Object[15];
                obj[0]=res.getString("id_pengembalian");
                obj[1]=res.getString("id_peminjam");
                obj[2]=res.getString("id_petugas");
                obj[3]=res.getString("id_penyewa");
                obj[4]=res.getString("id_penyewa");
                obj[5]=res.getString("merk_kamera");
                obj[6]=res.getString("jaminan_pinjam");
                obj[7]=res.getString("tanggal_pinjam");
                obj[8]=res.getString("tanggal_kembali");
                obj[9]=res.getString("lama_sewa");
                obj[10]=res.getString("harga_sewa");
                obj[11]=res.getString("denda");
                obj[12]=res.getString("total_bayar");
                model.addRow(obj);
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    //membaca data 
    public void loadDataPengembalian(){
        id_pengembalian = tidkembali.getText();
        id_peminjam = (String) cbidpeminjam.getSelectedItem();
        id_petugas = (String) idpetugas.getText();
        id_penyewa = (String) idpenyewa.getText();
        id_kamera = (String) idkamera.getText();
        merk_kamera = tmerkkamera.getText();
        jaminan_pinjam = thargasewa.getText();
        tanggal_pinjam = ttanggalpinjam.getText();
        tanggal_kembali = tanggalkembali.getText();
        strlama_sewa = tlamasewa.getText();
        strharga_sewa = thargasewa.getText();
        strdenda = tdenda.getText();
        strtotal_bayar = ttotalbayar.getText();
        
    }
    
    //memilih data saat baris pada tabel dipilih dengan mouse
    public void dataSelect(){
        //deklarasi variabel
        int i = tabelpengembalian.getSelectedRow();
        
        //uji adakah data di tabel?
        if(i == -1){
            //tidak ada yang terpilih atau dipilih.
            return;
        }
        tidkembali.setText(""+model.getValueAt(i,0));
        cbidpeminjam.setSelectedItem(""+model.getValueAt(i,1));
        tanggalkembali.setText(""+model.getValueAt(i,8));
        tlamasewa.setText(""+model.getValueAt(i,9));
        thargasewa.setText(""+model.getValueAt(i,10));
        tdenda.setText(""+model.getValueAt(i,11));
        ttotalbayar.setText(""+model.getValueAt(i,12));
    }
    
    public void cbidpeminjam()
    {
        try {
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            String sql = "SELECT id_peminjam FROM peminjaman order by id_peminjam asc";
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
            
                cbidpeminjam.addItem((String) ob[0]);
            }
            res.close();
            stat.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void dataPeminjam(){   
        try{
            //tes koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel produk
            String sql = "SELECT * FROM peminjaman WHERE id_peminjam = '"+ cbidpeminjam.getSelectedItem() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
            while(res.next()){
                //membuat obyek berjenis array
                idpetugas.setText(res.getString("id_petugas"));
                idpenyewa.setText(res.getString("id_penyewa"));
                idkamera.setText(res.getString("id_kamera"));
                tmerkkamera.setText(res.getString("merk_kamera"));
                tjaminan.setText(res.getString("jaminan_pinjam"));
                ttanggalpinjam.setText(res.getString("tanggal_pinjam"));
                thargasewa.setText(res.getString("harga_sewa"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tmerkkamera = new javax.swing.JTextField();
        ttanggalpinjam = new javax.swing.JTextField();
        thargasewa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tjaminan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tidkembali = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tlamasewa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tdenda = new javax.swing.JTextField();
        ttotalbayar = new javax.swing.JTextField();
        cbidpeminjam = new javax.swing.JComboBox<>();
        idpetugas = new javax.swing.JTextField();
        idpenyewa = new javax.swing.JTextField();
        idkamera = new javax.swing.JTextField();
        tanggalkembali = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        bsimpan = new javax.swing.JButton();
        breset = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpengembalian = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setText("PENGEMBALIAN KAMERA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setText("ID Peminjam");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setText("Merk Kamera");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setText("ID Kamera");

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setText("ID Petugas");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setText("Tanggal Pinjam");

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel11.setText("ID Penyewa");

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setText("Harga Sewa / Hari");

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel12.setText("Jaminan Pinjam");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setText("ID Pengembalian");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setText("Tanggal Kembali");

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel9.setText("Lama Sewa");

        tlamasewa.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tlamasewaInputMethodTextChanged(evt);
            }
        });
        tlamasewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlamasewaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel13.setText("Denda");

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel14.setText("Total Bayar");

        tdenda.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tdendaInputMethodTextChanged(evt);
            }
        });

        cbidpeminjam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Peminjam-" }));
        cbidpeminjam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbidpeminjamItemStateChanged(evt);
            }
        });

        tanggalkembali.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        tanggalkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalkembaliActionPerformed(evt);
            }
        });
        tanggalkembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tanggalkembaliKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tmerkkamera, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(idpenyewa, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idpetugas, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbidpeminjam, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tidkembali, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(idkamera)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ttanggalpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(tlamasewa)
                    .addComponent(thargasewa)
                    .addComponent(tdenda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ttotalbayar)
                    .addComponent(tanggalkembali))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ttanggalpinjam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tidkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)))))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(cbidpeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggalkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tlamasewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(thargasewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(idpenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tdenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel5)
                            .addComponent(idkamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tmerkkamera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel14)
                                .addComponent(ttotalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tjaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        bsimpan.setBackground(new java.awt.Color(102, 102, 102));
        bsimpan.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        breset.setBackground(new java.awt.Color(102, 102, 102));
        breset.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        breset.setText("RESET");
        breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresetActionPerformed(evt);
            }
        });

        bubah.setBackground(new java.awt.Color(102, 102, 102));
        bubah.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        bubah.setText("UBAH");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bhapus.setBackground(new java.awt.Color(102, 102, 102));
        bhapus.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bkeluar.setBackground(new java.awt.Color(102, 102, 102));
        bkeluar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        bkeluar.setText("KELUAR");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelpengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelpengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpengembalianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpengembalian);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //mengosongkan form
    public void reset(){
        id_pengembalian = "";
        id_peminjam = "";
        id_petugas = "";
        id_penyewa = "";
        id_kamera = "";
        merk_kamera = "";
        jaminan_pinjam = "";
        tanggal_pinjam = "";
        tanggal_kembali = "";
        lama_sewa = 0.0;
        harga_sewa = 0.0;
        denda = 0.0;
        total_bayar = 0.0;
               
        tidkembali.setText(id_pengembalian);
        cbidpeminjam.setSelectedItem("-Pilih Peminjam-");
        //idpetugas.getText();
        //idpenyewa.getText();
        //idkamera.getText();
        //tmerkkamera.setText(merk_kamera);
        tjaminan.setText(jaminan_pinjam);
        ttanggalpinjam.setText(tanggal_pinjam);
        

        idpetugas.setText(id_petugas);
        idpenyewa.setText(id_penyewa);
        idkamera.setText(id_kamera);
        tmerkkamera.setText(merk_kamera);
        //thargasewa.getText();
        ttanggalpinjam.setText(tanggal_pinjam);
        tanggalkembali.setText(tanggal_kembali);
        
        //tlamasewa.setText(String.format("%.0f",Double.toString(lama_sewa)));
        tlamasewa.setText(Double.toString(lama_sewa));
        //thargasewa.setText(String.format("%.0f",Double.toString(harga_sewa)));
        thargasewa.setText(Double.toString(harga_sewa));
        //tdenda.setText(String.format("%.0f",Double.toString(denda)));
        tdenda.setText(Double.toString(denda));
        //ttotalbayar.setText(String.format("%.0f",Double.toString(total_bayar)));
        ttotalbayar.setText(Double.toString(total_bayar));
    }
    
    public void simpanDataPengembalian(){
        
        loadDataPengembalian();
        //uji koneksi dan eksekusi perintah
        try{
            //test koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String  sql =   "INSERT INTO pengembalian(id_pengembalian, id_peminjam, id_petugas, id_penyewa, id_kamera, merk_kamera, jaminan_pinjam, tanggal_pinjam, tanggal_kembali, lama_sewa, harga_sewa, denda, total_bayar )"
                            + "VALUES('"+ id_pengembalian+"','"+id_peminjam +"','"+ id_petugas +"','"+ id_penyewa +"','"+ id_kamera +"','"+merk_kamera+"','"+jaminan_pinjam+"','"+tanggal_pinjam+"','"+tanggal_kembali+"','"+strlama_sewa+"','"+strharga_sewa+"','"+strdenda+"','"+strtotal_bayar+"')";
            PreparedStatement p = (PreparedStatement) koneksidb.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getDataPengembalian();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void hapusDataPengembalian(){
        //panggil fungsi ambil data
        loadDataPengembalian();
        
        //Beri peringatan sebelum melakukan penghapusan data
        int pesan = JOptionPane.showConfirmDialog(null, "HAPUS DATA" + id_pengembalian +"?","KONFIRMASI", JOptionPane.OK_CANCEL_OPTION);
        
        //jika pengguna memilih OK lanjutkan proses hapus data
        if(pesan == JOptionPane.OK_OPTION){
            //uji koneksi
            try{
                //buka koneksi ke database
                Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
                
                //perintah hapus data
                String sql = "DELETE FROM pengembalian WHERE id_pengembalian='"+ id_pengembalian +"'";
                PreparedStatement p =(PreparedStatement)koneksidb.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                
                //fungsi reset data
                reset();
                
                getDataPengembalian();
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        }
    }
    
    public void perbaruhiDataPengembalian(){
        //fungsi load data 
        loadDataPengembalian();
        
        try{
            //uji koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            
            //kirim perintah sql
            String sql = "UPDATE pengembalian SET id_peminjam = '"+id_peminjam +"',"
                    +"id_petugas = '"+id_petugas +"',"
                    +"id_penyewa = '"+id_penyewa +"',"
                    +"id_kamera = '"+id_kamera +"',"
                    +"merk_kamera = '"+merk_kamera +"',"
                    +"jaminan_pinjam = '"+jaminan_pinjam +"',"
                    +"tanggal_pinjam = '"+tanggal_pinjam +"',"
                    +"tanggal_kembali = '"+tanggal_kembali +"',"
                    +"lama_sewa = '"+lama_sewa +"',"
                    +"harga_sewa = '"+harga_sewa +"',"
                    +"denda = '"+denda +"',"
                    +"total_bayar = '"+total_bayar +"'"
                    +"WHERE id_pengembalian = '"+id_pengembalian +"'";
                    
            PreparedStatement p =(PreparedStatement)koneksidb.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            reset();

            getDataPengembalian();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void selisihtanggal(){
        //SimpleDateFormat Format = new SimpleDateFormat("");
        String tglpinjam = ttanggalpinjam.getText();
        String tglkembali = tanggalkembali.getText();
        try {
            int tahunP = Integer.parseInt(tglpinjam.substring(0, 4));
            int hariP = Integer.parseInt(tglpinjam.substring(8, 10));
            int bulanpinjam = Integer.parseInt(tglpinjam.substring(5, 7));
            
            int tahunK = Integer.parseInt(tglkembali.substring(0, 4));
            int hariK = Integer.parseInt(tglkembali.substring(8, 10));
            int bulankembali = Integer.parseInt(tglkembali.substring(5, 7));
            
            int hasilHari = hariK - hariP;
            int hasilBulan = (bulankembali - bulanpinjam) * 30;
            int hasiltahun = (tahunK - tahunP) * 365;
            int totalwaktu = (hasilHari + hasilBulan + hasiltahun);
            tlamasewa.setText(String.valueOf(totalwaktu));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void denda(){
        lama_sewa = Double.parseDouble(tlamasewa.getText());
        harga_sewa = Double.parseDouble(thargasewa.getText());
        //strlama_sewa = String.format("%.0f",Double.toString(lama_sewa));
        if (lama_sewa > 1.0){
            denda =  harga_sewa * 0.3;
        } else {
            denda = 0.0;
        }
        tdenda.setText(Double.toString(denda));
    }
    
    public void total(){
        total_bayar = (harga_sewa * lama_sewa) + denda;
        ttotalbayar.setText(Double.toString(total_bayar));
    }
    
    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        simpanDataPengembalian();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        hapusDataPengembalian();
    }//GEN-LAST:event_bhapusActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        // TODO add your handling code here:
        perbaruhiDataPengembalian();
    }//GEN-LAST:event_bubahActionPerformed

    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_bresetActionPerformed

    private void cbidpeminjamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbidpeminjamItemStateChanged
        // TODO add your handling code here:
        dataPeminjam();
    }//GEN-LAST:event_cbidpeminjamItemStateChanged

    private void tanggalkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalkembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalkembaliActionPerformed

    private void tanggalkembaliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tanggalkembaliKeyReleased
        // TODO add your handling code here:
        selisihtanggal();
        denda();
        total();
    }//GEN-LAST:event_tanggalkembaliKeyReleased

    private void tlamasewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlamasewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tlamasewaActionPerformed

    private void tlamasewaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tlamasewaInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tlamasewaInputMethodTextChanged

    private void tdendaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tdendaInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tdendaInputMethodTextChanged

    private void tabelpengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpengembalianMouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tabelpengembalianMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formtransaksikembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formtransaksikembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formtransaksikembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formtransaksikembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formtransaksikembali().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton breset;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JComboBox<String> cbidpeminjam;
    private javax.swing.JTextField idkamera;
    private javax.swing.JTextField idpenyewa;
    private javax.swing.JTextField idpetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelpengembalian;
    private javax.swing.JFormattedTextField tanggalkembali;
    private javax.swing.JTextField tdenda;
    private javax.swing.JTextField thargasewa;
    private javax.swing.JTextField tidkembali;
    private javax.swing.JTextField tjaminan;
    private javax.swing.JTextField tlamasewa;
    private javax.swing.JTextField tmerkkamera;
    private javax.swing.JTextField ttanggalpinjam;
    private javax.swing.JTextField ttotalbayar;
    // End of variables declaration//GEN-END:variables
}
